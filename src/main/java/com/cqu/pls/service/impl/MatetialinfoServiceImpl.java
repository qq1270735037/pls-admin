package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.dao.MatetialinfoDao;
import com.cqu.pls.service.MatetialinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Matetialinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("matetialinfoService")
public class MatetialinfoServiceImpl implements MatetialinfoService {
    @Resource
    private MatetialinfoDao matetialinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param materialId 主键
     * @return 实例对象
     */
    @Override
    public Matetialinfo queryById(Integer materialId) {
        return this.matetialinfoDao.queryById(materialId);
    }

    /**
     * 分页查询
     *
     * @param matetialinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Matetialinfo> queryByPage(Matetialinfo matetialinfo, PageRequest pageRequest) {
        long total = this.matetialinfoDao.count(matetialinfo);
        return new PageImpl<>(this.matetialinfoDao.queryAllByLimit(matetialinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Matetialinfo insert(Matetialinfo matetialinfo) {
        this.matetialinfoDao.insert(matetialinfo);
        return matetialinfo;
    }

    /**
     * 修改数据
     *
     * @param matetialinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Matetialinfo update(Matetialinfo matetialinfo) {
        this.matetialinfoDao.update(matetialinfo);
        return this.queryById(matetialinfo.getMaterialId());
    }

    /**
     * 通过主键删除数据
     *
     * @param materialId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer materialId) {
        return this.matetialinfoDao.deleteById(materialId) > 0;
    }
}
