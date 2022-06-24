package com.cqu.pls.service;

import com.cqu.pls.entity.Addressinfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Addressinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:00
 */
public interface AddressinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    Addressinfo queryById(Integer addressId);

    /**
     * 分页查询
     *
     * @param addressinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Addressinfo> queryByPage(Addressinfo addressinfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param addressinfo 实例对象
     * @return 实例对象
     */
    Addressinfo insert(Addressinfo addressinfo);

    /**
     * 修改数据
     *
     * @param addressinfo 实例对象
     * @return 实例对象
     */
    Addressinfo update(Addressinfo addressinfo);

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer addressId);

}
