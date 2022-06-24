package com.cqu.pls.service;

import com.cqu.pls.entity.Merchandiseinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Merchandiseinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface MerchandiseinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param merchandiseId 主键
     * @return 实例对象
     */
    Merchandiseinfo queryById(Integer merchandiseId);

    /**
     * 分页查询
     *
     * @param merchandiseinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Merchandiseinfo> queryByPage(Merchandiseinfo merchandiseinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param merchandiseinfo 实例对象
     * @return 实例对象
     */
    Merchandiseinfo insert(Merchandiseinfo merchandiseinfo);

    /**
     * 修改数据
     *
     * @param merchandiseinfo 实例对象
     * @return 实例对象
     */
    Merchandiseinfo update(Merchandiseinfo merchandiseinfo);

    /**
     * 通过主键删除数据
     *
     * @param merchandiseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer merchandiseId);

}
