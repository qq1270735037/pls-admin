package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Fixinfo;
import com.cqu.pls.dao.FixinfoDao;
import com.cqu.pls.service.FixinfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.List;

/**
 * (Fixinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("fixinfoService")
@Transactional
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

    /**
     * 通过维修工姓名查询
     * @param fixinfo
     * @return
     */
    @Override
    public List<Fixinfo> queryByName(Fixinfo fixinfo) {

        return this.fixinfoDao.qureyByName(fixinfo);
    }
}
