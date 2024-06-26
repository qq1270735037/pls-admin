package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Companyinfo;
import com.cqu.pls.entity.Employeeinfo;
import com.cqu.pls.service.CompanyinfoService;
import com.cqu.pls.service.EmployeeinfoService;

import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.vo.EmployeeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Employeeinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("employeeinfo")
public class EmployeeinfoController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeinfoService employeeinfoService;

    @Resource
    private CompanyinfoService companyinfoService;
    /**
     * 分页查询
     *
     * @param employeeinfo 筛选条件
     * @return 查询结果
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody(required = false) Employeeinfo employeeinfo) {
        List<EmployeeVo> employeeVos = this.employeeinfoService.queryEmployeeVo(employeeinfo);
        int size = employeeVos.size();
        return DataResult.successByTotalData(employeeVos,(long)size);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get")
    public DataResult queryById(@RequestParam("id") Integer id) {
        return  DataResult.successByData(this.employeeinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false)Employeeinfo employeeinfo) {
        return DataResult.successByMessage("成功",
                this.employeeinfoService.insert(employeeinfo));
    }

    /**
     * 编辑数据
     *
     * @param employeeinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult update(@RequestBody(required = false)Employeeinfo employeeinfo) {
        return DataResult.successByMessage("成功",
                this.employeeinfoService.update(employeeinfo));
    }

    /**
     * 删除数据
     *
     * @param sid 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Integer id = Integer.parseInt(JSON.parseObject(sid).get("id").toString());
        return DataResult.successByMessage("成功",
                this.employeeinfoService.deleteById(id));
    }
}

