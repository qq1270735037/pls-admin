package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.dao.AddressinfoDao;
import com.cqu.pls.service.AddressinfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Addressinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:01
 */
@Service("addressinfoService")
public class AddressinfoServiceImpl implements AddressinfoService {
    @Resource
    private AddressinfoDao addressinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param addressId 主键
     * @return 实例对象
     */
    @Override
    public Addressinfo queryById(Integer addressId) {
        return this.addressinfoDao.queryById(addressId);
    }

    /**
     * 分页查询
     *
     * @param addressinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Addressinfo> queryByPage(Addressinfo addressinfo, PageRequest pageRequest) {
        long total = this.addressinfoDao.count(addressinfo);
        return new PageImpl<>(this.addressinfoDao.queryAllByLimit(addressinfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param addressinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Addressinfo insert(Addressinfo addressinfo) {
        this.addressinfoDao.insert(addressinfo);
        return addressinfo;
    }

    /**
     * 修改数据
     *
     * @param addressinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Addressinfo update(Addressinfo addressinfo) {
        this.addressinfoDao.update(addressinfo);
        return this.queryById(addressinfo.getAddressId());
    }

    /**
     * 通过主键删除数据
     *
     * @param addressId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer addressId) {
        return this.addressinfoDao.deleteById(addressId) > 0;
    }
}
