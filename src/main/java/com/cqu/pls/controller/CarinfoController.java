package com.cqu.pls.controller;

import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.service.CarinfoService;

import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Carinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@RestController
@RequestMapping("carinfo")
public class CarinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CarinfoService carinfoService;

    /**
     * 分页查询
     *
     * @param carinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Carinfo>> queryByPage(Carinfo carinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.carinfoService.queryByPage(carinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get")
    public ResponseEntity<Carinfo> queryById(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(this.carinfoService.queryById(id));
    }
    @PostMapping("queryByCondition")
    public List<Carinfo> queryByCondition( Carinfo carinfo) {
//        List<Carinfo> carinfos = carinfoService.queryBycondition(carinfo);

//        return DataResult.successByTotalData(carinfos, carinfo);
        return this.carinfoService.queryBycondition(carinfo);
    }
    /**
     * 新增数据
     *
     * @param carinfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Carinfo> add(Carinfo carinfo) {
        return ResponseEntity.ok(this.carinfoService.insert(carinfo));
    }

    /**
     * 编辑数据
     *
     * @param carinfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Carinfo> edit(Carinfo carinfo) {
        return ResponseEntity.ok(this.carinfoService.update(carinfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.carinfoService.deleteById(id));
    }

}

