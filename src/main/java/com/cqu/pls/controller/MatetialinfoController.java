package com.cqu.pls.controller;

import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.service.MatetialinfoService;

import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (Matetialinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController

@RequestMapping("matetialinfo")
public class MatetialinfoController {
    /**
     * 服务对象
     */
    @Resource
    private MatetialinfoService matetialinfoService;

    /**
     * 分页查询
     *
     * @param matetialinfo 筛选条件
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Matetialinfo>> queryByPage(Matetialinfo matetialinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.matetialinfoService.queryByPage(matetialinfo, pageRequest));
//    }


//    @GetMapping("{id}")
//    public ResponseEntity<Matetialinfo> queryById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(this.matetialinfoService.queryById(id));
//    }
//    @PostMapping("selectOne")
//    public DataResult selectOne(Integer id,HttpSession httpSession) {
//        Matetialinfo matetialinfo = this.matetialinfoService.queryById(id);
//        System.out.println("id:"+id);
//        System.out.println(matetialinfo);
//        return DataResult.successByData(matetialinfo);
//    }
    @PostMapping("selectOne")
    @ResponseBody
    public DataResult selectOne(@RequestBody(required = false) Matetialinfo matetialinfo) {
        Matetialinfo matetialinfo1 = this.matetialinfoService.queryById(matetialinfo.getMaterialId());
        return DataResult.successByData(matetialinfo1);
    }

    /**
     * 查询全部
     * @return
     */
    @PostMapping("selectAll")
    @ResponseBody
    public DataResult selectAll() {

        return DataResult.successByDataArray(matetialinfoService.queryAll());
    }

    /**
     * 根据名字查询
     * @return
     */
    @PostMapping("selectByName")
    @ResponseBody
    public DataResult selectByName(@RequestBody Matetialinfo matetialinfo) {

        return DataResult.successByDataArray(matetialinfoService.selectByName(matetialinfo));
    }
    /**
     * 新增数据
     *
     * @param matetialinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Matetialinfo> add(Matetialinfo matetialinfo) {
        return ResponseEntity.ok(this.matetialinfoService.insert(matetialinfo));
    }

    /**
     * 编辑数据
     *
     * @param matetialinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Matetialinfo> edit(Matetialinfo matetialinfo) {
        return ResponseEntity.ok(this.matetialinfoService.update(matetialinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.matetialinfoService.deleteById(id));
    }

}

