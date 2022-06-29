package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Buildinfo;
import com.cqu.pls.dao.BuildinfoDao;
import com.cqu.pls.service.BuildinfoService;
import com.cqu.pls.vo.BuildAndAddress;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

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
     * @param buildinfo 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Buildinfo buildinfo) {
        return this.buildinfoDao.deleteById(buildinfo) > 0;
    }

    @Override
    public List<Buildinfo> queryAll() {
        return this.buildinfoDao.queryAll();
    }

    @Override
    public List<BuildAndAddress> getBuildAndAddressList() {
        return this.buildinfoDao.getBuildAndAddressList();
    }

    @Override
    public List<BuildAndAddress> getBuildByName(BuildAndAddress buildAndAddress) {
        return this.buildinfoDao.getBuildByName( buildAndAddress);
    }
}
