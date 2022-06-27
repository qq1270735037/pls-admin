package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Companyinfo;
import com.cqu.pls.service.CompanyinfoService;

import com.cqu.pls.utils.result.DataResult;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
//    @GetMapping
//    public ResponseEntity<Page<Companyinfo>> queryByPage(Companyinfo companyinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.companyinfoService.queryByPage(companyinfo, pageRequest));
//    }

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

    /**
     * 通过公司名称模糊查询
     * @param companyinfo
     * @return
     */
    @PostMapping("queryByName")
    public DataResult queryByName(@RequestBody Companyinfo companyinfo){
        //System.out.println(companyinfo.getCompanyName());
        //List<Companyinfo> companyinfos = this.companyinfoService.queryByName(companyinfo);

        return DataResult.successByDataArray(this.companyinfoService.queryByName(companyinfo));
    }
}

