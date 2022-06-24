package com.cqu.pls.service.impl;

import com.cqu.pls.entity.Employeeinfo;
import com.cqu.pls.dao.EmployeeinfoDao;
import com.cqu.pls.service.EmployeeinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Employeeinfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@Service("employeeinfoService")
public class EmployeeinfoServiceImpl implements EmployeeinfoService {
    @Resource
    private EmployeeinfoDao employeeinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    @Override
    public Employeeinfo queryById(Integer employeeId) {
        return this.employeeinfoDao.queryById(employeeId);
    }



    /**
     * 新增数据
     *
     * @param employeeinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Employeeinfo insert(Employeeinfo employeeinfo) {
        this.employeeinfoDao.insert(employeeinfo);
        return employeeinfo;
    }

    /**
     * 修改数据
     *
     * @param employeeinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Employeeinfo update(Employeeinfo employeeinfo) {
        this.employeeinfoDao.update(employeeinfo);
        return this.queryById(employeeinfo.getEmployeeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer employeeId) {
        return this.employeeinfoDao.deleteById(employeeId) > 0;
    }
}
