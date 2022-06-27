package com.cqu.pls.service;

import com.cqu.pls.entity.Matetialinfo;

import java.util.List;


/**
 * (Matetialinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MatetialinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    Matetialinfo queryById(Integer materialId);



    /**
     * 新增数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    Matetialinfo insert(Matetialinfo matetialinfo);

    /**
     * 修改数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    Matetialinfo update(Matetialinfo matetialinfo);

    /**
     * 通过主键删除数据
     *
     * @param materialId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer materialId);

    List<Matetialinfo> queryAll();
}
