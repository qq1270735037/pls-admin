package com.cqu.pls.controller;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.service.AddressinfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Addressinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:33:55
 */
@RestController
@RequestMapping("addressinfo")
public class AddressinfoController {
    /**
     * 服务对象
     */
    @Resource
    private AddressinfoService addressinfoService;

    /**
     * 分页查询
     *
     * @param addressinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Addressinfo>> queryByPage(Addressinfo addressinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.addressinfoService.queryByPage(addressinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Addressinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.addressinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param addressinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Addressinfo> add(Addressinfo addressinfo) {
        return ResponseEntity.ok(this.addressinfoService.insert(addressinfo));
    }

    /**
     * 编辑数据
     *
     * @param addressinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Addressinfo> edit(Addressinfo addressinfo) {
        return ResponseEntity.ok(this.addressinfoService.update(addressinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.addressinfoService.deleteById(id));
    }

}

