package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.service.AddressinfoService;
import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Addressinfo)表控制层
 *
 * @author qufang
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

    @PostMapping("queryByCondition")
    public DataResult queryByCondition(@RequestBody Addressinfo addressinfo) {
        return DataResult.successByDataArray(this.addressinfoService.queryBycondition(addressinfo));
    }

//    /**
//     * 新增数据
//     *
//     * @param addressinfo 实体
//     * @return 新增结果
//     */
//    @PostMapping
//    public ResponseEntity<Addressinfo> add(Addressinfo addressinfo) {
//        return ResponseEntity.ok(this.addressinfoService.insert(addressinfo));
//    }

    /**
     * 新增数据
     *
     * @param addressinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false) Addressinfo addressinfo) {
        return DataResult.successByMessage("成功",this.addressinfoService.insert(addressinfo));
    }

    /**
     * 编辑数据
     *
     * @param addressinfo 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult update(@RequestBody Addressinfo addressinfo) {
        return DataResult.successByMessage("成功",this.addressinfoService.update(addressinfo));
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
        return DataResult.successByMessage("成功",this.addressinfoService.deleteById(id));
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

