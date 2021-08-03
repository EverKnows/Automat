package com.hdu.automat.biz.repository;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.hdu.automat.biz.convert.DeviceConvert;
import com.hdu.automat.biz.entity.DeviceEntity;
import com.hdu.automat.biz.enums.DeviceStatus;
import com.hdu.automat.biz.exception.BizException;
import com.hdu.automat.biz.exception.ParamException;
import com.hdu.automat.biz.util.AssertUtil;
import com.hdu.automat.dal.entity.ChannelDTO;
import com.hdu.automat.dal.entity.DeviceDTO;
import com.hdu.automat.dal.mapper.ChannelMapper;
import com.hdu.automat.dal.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jianmiao.xu
 * @date 2021/8/3
 */
@Component
@Slf4j
public class DeviceService {

    @Resource
    private DeviceMapper deviceMapper;

    @Resource
    private ChannelMapper channelMapper;

    public void registry(DeviceEntity deviceEntity) {
        AssertUtil.isTrue(deviceEntity != null, "待注册的机器为空");

        try {
            deviceMapper.insert(DeviceConvert.convert2DTO(deviceEntity));
        } catch (Exception e) {
            log.error("DeviceRepository::registry 注册机器失败, device:{}, e:{}", JSON.toJSONString(deviceEntity), e.getMessage());
            throw new BizException(e.getMessage());
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public void reload(Long deviceId) {
        AssertUtil.isTrue(deviceId != null, "设备Id为空");

        DeviceDTO deviceDTO = deviceMapper.loadById(deviceId);

        AssertUtil.isTrue(deviceDTO != null, "Id对应的设备不存在");

        List<ChannelDTO> channelDTOList = channelMapper.batchLoadBySubId(deviceId);

        AssertUtil.isTrue(!CollectionUtils.isEmpty(channelDTOList), "设备对应的商品通道不存在");

        for (ChannelDTO channelDTO : channelDTOList) {
            channelMapper.updateStock(channelDTO.getId(), channelDTO.getSize());
        }
    }

    public void offline(Long deviceId) {
        AssertUtil.isTrue(deviceId != null, "设备Id为空");

        if (deviceMapper.offline(deviceId, DeviceStatus.ERROR.getCode()) < 1) {
            throw new BizException("更新设备状态失败, 设备ID:" + deviceId);
        }

    }

}