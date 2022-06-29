package com.cqu.pls.service;

import com.cqu.pls.entity.Employeeinfo;
import com.cqu.pls.vo.EmployeeVo;

import java.util.List;


/**
 * (Employeeinfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
public interface EmployeeinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param employeeId 主键
     * @return 实例对象
     */
    Employeeinfo queryById(Integer employeeId);

    /**
     * 通过ID查询单条数据
     *
     * @param employeeinfo
     * @return 实例对象数组
     */
    List<Employeeinfo> queryByPage(Employeeinfo employeeinfo);

    /**
     * 人员信息视图
     * @param employeeinfo
     * @return
     */
    List<EmployeeVo> queryEmployeeVo(Employeeinfo employeeinfo);
    /**
     * 新增数据
     *
     * @param employeeinfo 实例对象
     * @return 实例对象
     */
    Employeeinfo insert(Employeeinfo employeeinfo);

    /**
     * 修改数据
     *
     * @param employeeinfo 实例对象
     * @return 实例对象
     */
    Employeeinfo update(Employeeinfo employeeinfo);

    /**
     * 通过主键删除数据
     *
     * @param employeeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer employeeId);

}
