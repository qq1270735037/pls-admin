package com.cqu.pls.service;

import com.cqu.pls.entity.Fixinfo;


/**
 * (Fixinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface FixinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param fixId 主键
     * @return 实例对象
     */
    Fixinfo queryById(Integer fixId);



    /**
     * 新增数据
     *
     * @param fixinfo 实例对象
     * @return 实例对象
     */
    Fixinfo insert(Fixinfo fixinfo);

    /**
     * 修改数据
     *
     * @param fixinfo 实例对象
     * @return 实例对象
     */
    Fixinfo update(Fixinfo fixinfo);

    /**
     * 通过主键删除数据
     *
     * @param fixId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer fixId);

}
