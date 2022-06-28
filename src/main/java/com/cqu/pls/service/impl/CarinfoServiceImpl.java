package com.cqu.pls.service.impl;

import com.cqu.pls.dao.CarinfoDao;
import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.service.CarinfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("carinfoService")
@Transactional
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
     * 分页查询
     * @param carinfoDTO      分页对象
     * @return 查询结果
     */
    @Override
    public List<Carinfo> queryByPage(CarinfoDTO carinfoDTO) {
        return  this.carinfoDao.queryByPage(carinfoDTO);
    }
    /**
     * 条件查询
     * @param carinfoDTO
     * @return
     */
    @Override
    public List<Carinfo> queryBycondition(CarinfoDTO carinfoDTO){
        Page<Carinfo> page = PageHelper.startPage(1, 10).doSelectPage(()-> carinfoDao.queryByCondition(new Carinfo()));
        return this.carinfoDao.queryByCondition(carinfoDTO);
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

    /**
     *
     * @param carinfo
     * @return
     */
    @Override
    public Long getCarByConditionCount(Carinfo carinfo){
        return this.carinfoDao.count(carinfo);
    }
}
