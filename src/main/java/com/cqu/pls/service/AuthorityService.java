package com.cqu.pls.service;

import com.cqu.pls.entity.Authority;


/**
 * (Authority)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
public interface AuthorityService {

    /**
     * 通过ID查询单条数据
     *
     * @param authorityId 主键
     * @return 实例对象
     */
    Authority queryById(Integer authorityId);



    /**
     * 新增数据
     *
     * @param authority 实例对象
     * @return 实例对象
     */
    Authority insert(Authority authority);

    /**
     * 修改数据
     *
     * @param authority 实例对象
     * @return 实例对象
     */
    Authority update(Authority authority);

    /**
     * 通过主键删除数据
     *
     * @param authorityId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer authorityId);

}
