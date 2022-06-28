package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Merchandiseinfo;
import com.cqu.pls.service.MerchandiseinfoService;

import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 货物表控制层
 *
 * @author qufang
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
     *
     * @param merchandiseinfo
     * @return
     */
    @PostMapping("queryByCondition")
    public DataResult queryByCondition(Merchandiseinfo merchandiseinfo) {
        return DataResult.successByDataArray(this.merchandiseinfoService.queryBycondition(merchandiseinfo));
    }

    /**
     * 新增数据
     *
     * @param merchandiseinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false) Merchandiseinfo merchandiseinfo) {
        return DataResult.successByMessage("成功",this.merchandiseinfoService.insert(merchandiseinfo));
    }

    /**
     * 编辑数据
     *
     * @param merchandiseinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult update(@RequestBody Merchandiseinfo merchandiseinfo) {
        return DataResult.successByMessage("成功",this.merchandiseinfoService.update(merchandiseinfo));
    }
    /**
     * 删除数据
     *
     * @param sid 主键  sid = {id:" xxx"}
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Integer id = Integer.parseInt(JSON.parseObject(sid).get("id").toString());
        return DataResult.successByMessage("成功",this.merchandiseinfoService.deleteById(id));
    }

    /**
     * 分页查询
     *
     * @param merchandiseinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Merchandiseinfo>> queryByPage(Merchandiseinfo merchandiseinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.merchandiseinfoService.queryByPage(merchandiseinfo, pageRequest));
//    }

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

