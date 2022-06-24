package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Companyinfo;
import com.cqu.pls.dao.CompanyinfoDao;
import com.cqu.pls.service.CompanyinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Companyinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("companyinfoService")
public class CompanyinfoServiceImpl implements CompanyinfoService {
    @Resource
    private CompanyinfoDao companyinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param companyId 主键
     * @return 实例对象
     */
    @Override
    public Companyinfo queryById(Integer companyId) {
        return this.companyinfoDao.queryById(companyId);
    }

    /**
     * 分页查询
     *
     * @param companyinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Companyinfo> queryByPage(Companyinfo companyinfo, PageRequest pageRequest) {
        long total = this.companyinfoDao.count(companyinfo);
        return new PageImpl<>(this.companyinfoDao.queryAllByLimit(companyinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param companyinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Companyinfo insert(Companyinfo companyinfo) {
        this.companyinfoDao.insert(companyinfo);
        return companyinfo;
    }

    /**
     * 修改数据
     *
     * @param companyinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Companyinfo update(Companyinfo companyinfo) {
        this.companyinfoDao.update(companyinfo);
        return this.queryById(companyinfo.getCompanyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param companyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer companyId) {
        return this.companyinfoDao.deleteById(companyId) > 0;
    }
}
