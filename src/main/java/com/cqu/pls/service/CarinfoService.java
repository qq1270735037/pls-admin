package com.cqu.pls.service;

import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.github.pagehelper.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;


/**
 * (Carinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CarinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    Carinfo queryById(Integer carId);

    /**
     * 分页查询
     * @return
     */
    List<Carinfo> queryByPage(CarinfoDTO carinfoDTO);
    /**
     * 模糊查询
     * @param carinfoDTO
     * @return
     */
    List<Carinfo> queryBycondition(CarinfoDTO carinfoDTO);

    /**
     * 新增数据
     *
     * @param carinfo 实例对象
     * @return 实例对象
     */
    Carinfo insert(Carinfo carinfo);

    /**
     * 修改数据
     *
     * @param carinfo 实例对象
     * @return 实例对象
     */
    Carinfo update(Carinfo carinfo);

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carId);
    /**
     * 根据条件查询总条数
     * @param carinfo
     * @return
     */
    Long getCarByConditionCount(Carinfo carinfo);
}
