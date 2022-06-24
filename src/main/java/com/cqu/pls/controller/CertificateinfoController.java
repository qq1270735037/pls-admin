package com.cqu.pls.controller;

import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.service.CertificateinfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Certificateinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("certificateinfo")
public class CertificateinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CertificateinfoService certificateinfoService;

    /**
     * 分页查询
     *
     * @param certificateinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Certificateinfo>> queryByPage(Certificateinfo certificateinfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.certificateinfoService.queryByPage(certificateinfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Certificateinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.certificateinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param certificateinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Certificateinfo> add(Certificateinfo certificateinfo) {
        return ResponseEntity.ok(this.certificateinfoService.insert(certificateinfo));
    }

    /**
     * 编辑数据
     *
     * @param certificateinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Certificateinfo> edit(Certificateinfo certificateinfo) {
        return ResponseEntity.ok(this.certificateinfoService.update(certificateinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.certificateinfoService.deleteById(id));
    }

}

