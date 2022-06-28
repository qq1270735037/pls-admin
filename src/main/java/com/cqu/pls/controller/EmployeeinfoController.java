package com.cqu.pls.controller;

import com.cqu.pls.entity.Employeeinfo;
import com.cqu.pls.service.EmployeeinfoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    /**
     * 分页查询
     *
     * @param employeeinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Employeeinfo>> queryByPage(Employeeinfo employeeinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.employeeinfoService.queryByPage(employeeinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Employeeinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.employeeinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Employeeinfo> add(Employeeinfo employeeinfo) {
        return ResponseEntity.ok(this.employeeinfoService.insert(employeeinfo));
    }

    /**
     * 编辑数据
     *
     * @param employeeinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Employeeinfo> edit(Employeeinfo employeeinfo) {
        return ResponseEntity.ok(this.employeeinfoService.update(employeeinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.employeeinfoService.deleteById(id));
    }

}

