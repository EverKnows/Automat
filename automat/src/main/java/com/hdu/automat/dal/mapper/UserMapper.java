package com.hdu.automat.dal.mapper;

import com.hdu.automat.dal.entity.UserDTO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author xjm
 * @since 2021-07-30 17:05:14
 */
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserDTO loadById(Long id);


    /**
     * 新增数据
     *
     * @param userDTO 实例对象
     * @return 影响行数
     */
    int insert(UserDTO userDTO);

  
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}