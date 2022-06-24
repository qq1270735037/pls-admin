package com.cqu.pls.service;

import com.cqu.pls.entity.Transportationinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
     * 分页查询
     *
     * @param transportationinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Transportationinfo> queryByPage(Transportationinfo transportationinfo, PageRequest pageRequest);

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

}
