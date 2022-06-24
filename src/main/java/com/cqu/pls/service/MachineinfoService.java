package com.cqu.pls.service;

import com.cqu.pls.entity.Machineinfo;


/**
 * (Machineinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MachineinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    Machineinfo queryById(Integer machineId);



    /**
     * 新增数据
     *
     * @param machineinfo 实例对象
     * @return 实例对象
     */
    Machineinfo insert(Machineinfo machineinfo);

    /**
     * 修改数据
     *
     * @param machineinfo 实例对象
     * @return 实例对象
     */
    Machineinfo update(Machineinfo machineinfo);

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer machineId);

}
