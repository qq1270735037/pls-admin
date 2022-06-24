package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.dao.CarinfoDao;
import com.cqu.pls.service.CarinfoService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * (Carinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("carinfoService")
public class CarinfoServiceImpl implements CarinfoService {
    @Resource
    private CarinfoDao carinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carId 主键
     * @return 实例对象
     */
    @Override
    public Carinfo queryById(Integer carId) {
        return this.carinfoDao.queryById(carId);
    }



    /**
     * 新增数据
     *
     * @param carinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Carinfo insert(Carinfo carinfo) {
        this.carinfoDao.insert(carinfo);
        return carinfo;
    }

    /**
     * 修改数据
     *
     * @param carinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Carinfo update(Carinfo carinfo) {
        this.carinfoDao.update(carinfo);
        return this.queryById(carinfo.getCarId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carId) {
        return this.carinfoDao.deleteById(carId) > 0;
    }
}
