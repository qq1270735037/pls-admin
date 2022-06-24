package com.cqu.pls.controller;

import com.cqu.pls.entity.Advertisementinfo;
import com.cqu.pls.service.AdvertisementinfoService;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Advertisementinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
@RestController
@RequestMapping("advertisementinfo")
public class AdvertisementinfoController {
    /**
     * 服务对象
     */
    @Resource
    private AdvertisementinfoService advertisementinfoService;

    /**
     * 分页查询
     *
     * @param advertisementinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Advertisementinfo>> queryByPage(Advertisementinfo advertisementinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.advertisementinfoService.queryByPage(advertisementinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Advertisementinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.advertisementinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param advertisementinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Advertisementinfo> add(Advertisementinfo advertisementinfo) {
        return ResponseEntity.ok(this.advertisementinfoService.insert(advertisementinfo));
    }

    /**
     * 编辑数据
     *
     * @param advertisementinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Advertisementinfo> edit(Advertisementinfo advertisementinfo) {
        return ResponseEntity.ok(this.advertisementinfoService.update(advertisementinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.advertisementinfoService.deleteById(id));
    }

}

