package com.cqu.pls.controller;

import com.cqu.pls.entity.Companyinfo;
import com.cqu.pls.service.CompanyinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Companyinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("companyinfo")
public class CompanyinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyinfoService companyinfoService;

    /**
     * 分页查询
     *
     * @param companyinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Companyinfo>> queryByPage(Companyinfo companyinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.companyinfoService.queryByPage(companyinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Companyinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.companyinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param companyinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Companyinfo> add(Companyinfo companyinfo) {
        return ResponseEntity.ok(this.companyinfoService.insert(companyinfo));
    }

    /**
     * 编辑数据
     *
     * @param companyinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Companyinfo> edit(Companyinfo companyinfo) {
        return ResponseEntity.ok(this.companyinfoService.update(companyinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.companyinfoService.deleteById(id));
    }

}

