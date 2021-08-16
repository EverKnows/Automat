package com.hdu.automat.dal.mapper;

import com.hdu.automat.dal.entity.DeviceDTO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Device)表数据库访问层
 *
 * @author xjm
 * @since 2021-08-03 15:47:45
 */
public interface DeviceMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DeviceDTO loadById(Long id);

    /**
     * 根据Id捞取对应的设备信息
     * @param idList
     * @return
     */
    List<DeviceDTO> batchLoadById(@Param("idList") List<Long> idList);

    /**
     * 更具机器状态捞取机器
     * @param statusList
     * @return
     */
    List<DeviceDTO> loadByStatus(@Param("statusList") List<Integer> statusList);


    /**
     * 新增数据
     *
     * @param deviceDTO 实例对象
     * @return 影响行数
     */
    int insert(DeviceDTO deviceDTO);

  
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过设备Id更新设备机器状态
     * @param id
     * @return
     */
    int offline(@Param("id") Long id,
                @Param("status") Integer status);

}