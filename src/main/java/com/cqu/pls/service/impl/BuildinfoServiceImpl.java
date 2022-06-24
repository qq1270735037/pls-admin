package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Buildinfo;
import com.cqu.pls.dao.BuildinfoDao;
import com.cqu.pls.service.BuildinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Buildinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@Service("buildinfoService")
public class BuildinfoServiceImpl implements BuildinfoService {
    @Resource
    private BuildinfoDao buildinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param buildId 主键
     * @return 实例对象
     */
    @Override
    public Buildinfo queryById(Integer buildId) {
        return this.buildinfoDao.queryById(buildId);
    }

    /**
     * 分页查询
     *
     * @param buildinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Buildinfo> queryByPage(Buildinfo buildinfo, PageRequest pageRequest) {
        long total = this.buildinfoDao.count(buildinfo);
        return new PageImpl<>(this.buildinfoDao.queryAllByLimit(buildinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param buildinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Buildinfo insert(Buildinfo buildinfo) {
        this.buildinfoDao.insert(buildinfo);
        return buildinfo;
    }

    /**
     * 修改数据
     *
     * @param buildinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Buildinfo update(Buildinfo buildinfo) {
        this.buildinfoDao.update(buildinfo);
        return this.queryById(buildinfo.getBuildId());
    }

    /**
     * 通过主键删除数据
     *
     * @param buildId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buildId) {
        return this.buildinfoDao.deleteById(buildId) > 0;
    }
}
