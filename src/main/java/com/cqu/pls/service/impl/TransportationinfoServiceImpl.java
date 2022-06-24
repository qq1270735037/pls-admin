package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Transportationinfo;
import com.cqu.pls.dao.TransportationinfoDao;
import com.cqu.pls.service.TransportationinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Transportationinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@Service("transportationinfoService")
public class TransportationinfoServiceImpl implements TransportationinfoService {
    @Resource
    private TransportationinfoDao transportationinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param transportationId 主键
     * @return 实例对象
     */
    @Override
    public Transportationinfo queryById(Long transportationId) {
        return this.transportationinfoDao.queryById(transportationId);
    }

    /**
     * 分页查询
     *
     * @param transportationinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Transportationinfo> queryByPage(Transportationinfo transportationinfo, PageRequest pageRequest) {
        long total = this.transportationinfoDao.count(transportationinfo);
        return new PageImpl<>(this.transportationinfoDao.queryAllByLimit(transportationinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param transportationinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Transportationinfo insert(Transportationinfo transportationinfo) {
        this.transportationinfoDao.insert(transportationinfo);
        return transportationinfo;
    }

    /**
     * 修改数据
     *
     * @param transportationinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Transportationinfo update(Transportationinfo transportationinfo) {
        this.transportationinfoDao.update(transportationinfo);
        return this.queryById(transportationinfo.getTransportationId());
    }

    /**
     * 通过主键删除数据
     *
     * @param transportationId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long transportationId) {
        return this.transportationinfoDao.deleteById(transportationId) > 0;
    }
}
