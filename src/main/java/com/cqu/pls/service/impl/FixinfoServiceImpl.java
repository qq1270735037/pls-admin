package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Fixinfo;
import com.cqu.pls.dao.FixinfoDao;
import com.cqu.pls.service.FixinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Fixinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("fixinfoService")
public class FixinfoServiceImpl implements FixinfoService {
    @Resource
    private FixinfoDao fixinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fixId 主键
     * @return 实例对象
     */
    @Override
    public Fixinfo queryById(Integer fixId) {
        return this.fixinfoDao.queryById(fixId);
    }

    /**
     * 分页查询
     *
     * @param fixinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Fixinfo> queryByPage(Fixinfo fixinfo, PageRequest pageRequest) {
        long total = this.fixinfoDao.count(fixinfo);
        return new PageImpl<>(this.fixinfoDao.queryAllByLimit(fixinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param fixinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Fixinfo insert(Fixinfo fixinfo) {
        this.fixinfoDao.insert(fixinfo);
        return fixinfo;
    }

    /**
     * 修改数据
     *
     * @param fixinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Fixinfo update(Fixinfo fixinfo) {
        this.fixinfoDao.update(fixinfo);
        return this.queryById(fixinfo.getFixId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fixId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fixId) {
        return this.fixinfoDao.deleteById(fixId) > 0;
    }
}
