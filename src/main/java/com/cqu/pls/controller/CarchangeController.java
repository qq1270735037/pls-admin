package com.cqu.pls.controller;

import com.cqu.pls.entity.Carchange;
import com.cqu.pls.service.CarchangeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Carchange)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@RestController
@RequestMapping("carchange")
public class CarchangeController {
    /**
     * 服务对象
     */
    @Resource
    private CarchangeService carchangeService;

    /**
     * 分页查询
     *
     * @param carchange 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Carchange>> queryByPage(Carchange carchange, PageRequest pageRequest) {
        return ResponseEntity.ok(this.carchangeService.queryByPage(carchange, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Carchange> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.carchangeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param carchange 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Carchange> add(Carchange carchange) {
        return ResponseEntity.ok(this.carchangeService.insert(carchange));
    }

    /**
     * 编辑数据
     *
     * @param carchange 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Carchange> edit(Carchange carchange) {
        return ResponseEntity.ok(this.carchangeService.update(carchange));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.carchangeService.deleteById(id));
    }

}

