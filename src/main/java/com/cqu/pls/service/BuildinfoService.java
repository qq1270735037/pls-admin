package com.cqu.pls.service;

import com.cqu.pls.entity.Buildinfo;


/**
 * (Buildinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
public interface BuildinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param buildId 主键
     * @return 实例对象
     */
    Buildinfo queryById(Integer buildId);



    /**
     * 新增数据
     *
     * @param buildinfo 实例对象
     * @return 实例对象
     */
    Buildinfo insert(Buildinfo buildinfo);

    /**
     * 修改数据
     *
     * @param buildinfo 实例对象
     * @return 实例对象
     */
    Buildinfo update(Buildinfo buildinfo);

    /**
     * 通过主键删除数据
     *
     * @param buildId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buildId);

}
