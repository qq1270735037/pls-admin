package com.cqu.pls.service;

import com.cqu.pls.entity.Carchange;

import java.util.List;


/**
 * (Carchange)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
public interface CarchangeService {

    /**
     * 通过ID查询单条数据
     *
     * @param carChangeId 主键
     * @return 实例对象
     */
    Carchange queryById(Integer carChangeId);



    /**
     * 新增数据
     *
     * @param carchange 实例对象
     * @return 实例对象
     */
    Carchange insert(Carchange carchange);

    /**
     * 修改数据
     *
     * @param carchange 实例对象
     * @return 实例对象
     */
    Carchange update(Carchange carchange);

    /**
     * 通过主键删除数据
     *
     * @param carChangeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer carChangeId);

    /**
     * 通过买卖类型筛选数据
     * @param carchange
     * @return
     */
    List<Carchange> getByOperation(Carchange carchange);
}
