package com.cqu.pls.controller;

import com.cqu.pls.entity.Authority;
import com.cqu.pls.service.AuthorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Authority)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:02
 */
@RestController
@RequestMapping("authority")
public class AuthorityController {
    /**
     * 服务对象
     */
    @Resource
    private AuthorityService authorityService;

    /**
     * 分页查询
     *
     * @param authority 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Authority>> queryByPage(Authority authority, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.authorityService.queryByPage(authority, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Authority> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.authorityService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param authority 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Authority> add(Authority authority) {
        return ResponseEntity.ok(this.authorityService.insert(authority));
    }

    /**
     * 编辑数据
     *
     * @param authority 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Authority> edit(Authority authority) {
        return ResponseEntity.ok(this.authorityService.update(authority));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.authorityService.deleteById(id));
    }

}

