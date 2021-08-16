package com.hdu.automat.dal.mapper;

import com.hdu.automat.dal.entity.OrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (Order)表数据库访问层
 *
 * @author xjm
 * @since 2021-08-02 14:25:58
 */
public interface OrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderDTO loadById(Long id);


    /**
     * 新增数据
     *
     * @param orderDTO 实例对象
     * @return 影响行数
     */
    int insert(OrderDTO orderDTO);

  
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据时间捞取订单
     * @param beginTime
     * @param endTime
     * @return
     */
    List<OrderDTO> loadByTime(@Param("beginTime") Date beginTime,
                              @Param("endTime") Date endTime,
                              @Param("orderStatusList") List<Integer> orderStatusList);

}