package com.hdu.automat.biz.convert;

import com.hdu.automat.biz.entity.DeviceEntity;
import com.hdu.automat.biz.enums.DeviceStatus;
import com.hdu.automat.dal.entity.DeviceDTO;
import org.apache.commons.compress.utils.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jianmiao.xu
 * @date 2021/8/3
 */
public class DeviceConvert {

    public static DeviceEntity convert2Entity(DeviceDTO deviceDTO) {
        if (deviceDTO == null) {
            return null;
        }
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setId(deviceDTO.getId());
        deviceEntity.setDeviceIp(deviceDTO.getDeviceIp());
        deviceEntity.setSimCardId(deviceDTO.getSimCardId());
        deviceEntity.setDeviceName(deviceDTO.getDeviceName());
        deviceEntity.setStatus(DeviceStatus.getByCode(deviceDTO.getStatus()));
        deviceEntity.setLocation(deviceDTO.getLocation());
        return deviceEntity;
    }

    public static List<DeviceEntity> convert2EntityList(List<DeviceDTO> deviceDTOList) {
        if (CollectionUtils.isEmpty(deviceDTOList)) {
            return Lists.newArrayList();
        }

        return deviceDTOList.stream().map(DeviceConvert::convert2Entity).collect(Collectors.toList());
    }

    public static DeviceDTO convert2DTO(DeviceEntity deviceEntity) {
        if (deviceEntity == null) {
            return null;
        }
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(deviceEntity.getId());
        deviceDTO.setDeviceIp(deviceEntity.getDeviceIp());
        deviceDTO.setSimCardId(deviceEntity.getSimCardId());
        deviceDTO.setDeviceName(deviceEntity.getDeviceName());
        deviceDTO.setStatus(deviceEntity.getStatus().getCode());
        deviceDTO.setLocation(deviceEntity.getLocation());
        return deviceDTO;
    }
}