package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Carchange;
import com.cqu.pls.dao.CarchangeDao;
import com.cqu.pls.service.CarchangeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Carchange)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@Service("carchangeService")
public class CarchangeServiceImpl implements CarchangeService {
    @Resource
    private CarchangeDao carchangeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param carChangeId 主键
     * @return 实例对象
     */
    @Override
    public Carchange queryById(Integer carChangeId) {
        return this.carchangeDao.queryById(carChangeId);
    }

    /**
     * 分页查询
     *
     * @param carchange 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Carchange> queryByPage(Carchange carchange, PageRequest pageRequest) {
        long total = this.carchangeDao.count(carchange);
        return new PageImpl<>(this.carchangeDao.queryAllByLimit(carchange, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param carchange 实例对象
     * @return 实例对象
     */
    @Override
    public Carchange insert(Carchange carchange) {
        this.carchangeDao.insert(carchange);
        return carchange;
    }

    /**
     * 修改数据
     *
     * @param carchange 实例对象
     * @return 实例对象
     */
    @Override
    public Carchange update(Carchange carchange) {
        this.carchangeDao.update(carchange);
        return this.queryById(carchange.getCarChangeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param carChangeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer carChangeId) {
        return this.carchangeDao.deleteById(carChangeId) > 0;
    }
}
