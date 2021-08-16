package com.hdu.automat.dal.mapper;

import com.hdu.automat.dal.entity.ChannelDTO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Channel)表数据库访问层
 *
 * @author xjm
 * @since 2021-08-03 15:47:35
 */
public interface ChannelMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ChannelDTO loadById(Long id);


    /**
     * 新增数据
     *
     * @param channelDTO 实例对象
     * @return 影响行数
     */
    int insert(ChannelDTO channelDTO);

  
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过设备Id加载通道信息
     * @param deviceId
     * @return
     */
    List<ChannelDTO> batchLoadBySubId(Long deviceId);

    /**
     * 更新通道货量
     * @param id
     * @param newStock
     * @return
     */
    int updateStock(@Param("id") Long id,
                    @Param("newStock") Long newStock);

    /**
     * 通过设备以及通道子Id更新商品种类，商品的存量直接清空
     * @param deviceId
     * @param subId
     * @param itemName
     * @return
     */
    int updateChannel(@Param("deviceId") Long deviceId,
                      @Param("subId") Integer subId,
                      @Param("itemName") String itemName);
}