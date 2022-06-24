package com.cqu.pls.controller;

import com.cqu.pls.entity.Merchandiseinfo;
import com.cqu.pls.service.MerchandiseinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Merchandiseinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("merchandiseinfo")
public class MerchandiseinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MerchandiseinfoService merchandiseinfoService;

    /**
     * 分页查询
     *
     * @param merchandiseinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Merchandiseinfo>> queryByPage(Merchandiseinfo merchandiseinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.merchandiseinfoService.queryByPage(merchandiseinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Merchandiseinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.merchandiseinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param merchandiseinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Merchandiseinfo> add(Merchandiseinfo merchandiseinfo) {
        return ResponseEntity.ok(this.merchandiseinfoService.insert(merchandiseinfo));
    }

    /**
     * 编辑数据
     *
     * @param merchandiseinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Merchandiseinfo> edit(Merchandiseinfo merchandiseinfo) {
        return ResponseEntity.ok(this.merchandiseinfoService.update(merchandiseinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.merchandiseinfoService.deleteById(id));
    }

}

