package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Transportationinfo;
import com.cqu.pls.dao.TransportationinfoDao;
import com.cqu.pls.service.TransportationinfoService;
import com.cqu.pls.vo.TransportationAndCar;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<TransportationAndCar> queryBycondition(TransportationAndCar transportationAndCar) {
        return this.transportationinfoDao.queryByCondition(transportationAndCar);
    }
}
