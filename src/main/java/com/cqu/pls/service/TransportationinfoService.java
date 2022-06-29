package com.cqu.pls.service;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Transportationinfo;

import java.util.List;


/**
 * (Transportationinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
public interface TransportationinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param transportationId 主键
     * @return 实例对象
     */
    Transportationinfo queryById(Long transportationId);



    /**
     * 新增数据
     *
     * @param transportationinfo 实例对象
     * @return 实例对象
     */
    Transportationinfo insert(Transportationinfo transportationinfo);

    /**
     * 修改数据
     *
     * @param transportationinfo 实例对象
     * @return 实例对象
     */
    Transportationinfo update(Transportationinfo transportationinfo);

    /**
     * 通过主键删除数据
     *
     * @param transportationId 主键
     * @return 是否成功
     */
    boolean deleteById(Long transportationId);


    /**
     *
     * @param transportationinfo
     * @return
     */
    List<Transportationinfo> queryBycondition(Transportationinfo transportationinfo);

}
