package com.cqu.pls.service;

import com.cqu.pls.entity.Companyinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Companyinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface CompanyinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param companyId 主键
     * @return 实例对象
     */
    Companyinfo queryById(Integer companyId);

    /**
     * 分页查询
     *
     * @param companyinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Companyinfo> queryByPage(Companyinfo companyinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param companyinfo 实例对象
     * @return 实例对象
     */
    Companyinfo insert(Companyinfo companyinfo);

    /**
     * 修改数据
     *
     * @param companyinfo 实例对象
     * @return 实例对象
     */
    Companyinfo update(Companyinfo companyinfo);

    /**
     * 通过主键删除数据
     *
     * @param companyId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer companyId);

}
