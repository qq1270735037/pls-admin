package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Authority;
import com.cqu.pls.dao.AuthorityDao;
import com.cqu.pls.service.AuthorityService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (Authority)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {
    @Resource
    private AuthorityDao authorityDao;

    /**
     * 通过ID查询单条数据
     *
     * @param authorityId 主键
     * @return 实例对象
     */
    @Override
    public Authority queryById(Integer authorityId) {
        return this.authorityDao.queryById(authorityId);
    }



    /**
     * 新增数据
     *
     * @param authority 实例对象
     * @return 实例对象
     */
    @Override
    public Authority insert(Authority authority) {
        this.authorityDao.insert(authority);
        return authority;
    }

    /**
     * 修改数据
     *
     * @param authority 实例对象
     * @return 实例对象
     */
    @Override
    public Authority update(Authority authority) {
        this.authorityDao.update(authority);
        return this.queryById(authority.getAuthorityId());
    }

    /**
     * 通过主键删除数据
     *
     * @param authorityId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer authorityId) {
        return this.authorityDao.deleteById(authorityId) > 0;
    }
}
