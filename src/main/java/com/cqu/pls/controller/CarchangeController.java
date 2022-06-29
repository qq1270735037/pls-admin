package com.cqu.pls.controller;

import com.cqu.pls.entity.Carchange;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.service.CarchangeService;

import com.cqu.pls.service.CarinfoService;
import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.utils.result.code.Code;
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
    @Resource
    private CarinfoService carinfoService;
    /**
     * 分页查询
     *
     * @param carchange 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Carchange>> queryByPage(Carchange carchange, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.carchangeService.queryByPage(carchange, pageRequest));
//    }

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

    /**
     * 通过买卖类型筛选数据
     * @param carchange
     * @return
     */
    @PostMapping("getByOperation")
    public DataResult getByOperation(@RequestBody Carchange carchange){
        return DataResult.successByDataArray(this.carchangeService.getByOperation(carchange));
    }

    /**
     * 通过买卖类型筛选数据
     * @param carchange
     * @return
     */
    @PostMapping("updateCarChange")
    public DataResult updateCarChange(@RequestBody Carchange carchange){
        if(carchange==null){
            return DataResult.errByErrCode(Code.ERROR);
        }
        return DataResult.successByMessage("更新成功",this.carchangeService.update(carchange));
    }
    /**
     * 通过买卖类型筛选数据
     * @param carchange
     * @return
     */
    @PostMapping("deleteCarChange")
    public DataResult deleteCarChange(@RequestBody Carchange carchange){
        if(carchange==null){
            return DataResult.errByErrCode(Code.ERROR);
        }
        Integer id = carchange.getCarChangeId();
        return DataResult.successByMessage("删除成功",this.carchangeService.deleteById(id));
    }

    /**
     * 通过买卖类型筛选数据
     * @param carinfo
     * @return
     */
    @PostMapping("insertCarChange")
    public DataResult insertCarChange(@RequestBody Carinfo carinfo){
        if(carinfo==null){
            return DataResult.errByErrCode(Code.ERROR);
        }
        Carinfo car=this.carinfoService.insert(carinfo);
        Carchange carchange = new Carchange();
        carchange.setCarId(car.getCarId());
        carchange.setCarChangeType(car.getCarStyle());
        carchange.setOperation(1);//买入
        return DataResult.successByMessage("插入成功",this.carchangeService.insert(carchange));
    }

    /**
     * 新增一条售出记录
     * @param carchange
     * @return
     */
    @PostMapping("saleCar")
    public DataResult saleCar(@RequestBody Carchange carchange){
        if(carchange==null){
            return DataResult.errByErrCode(Code.ERROR);
        }
        Carinfo car = this.carinfoService.queryById(carchange.getCarId());
        if(car==null){
            return DataResult.err();//数据库中没有该辆车
        }
        else {
            return DataResult.successByMessage("售出成功", this.carchangeService.insert(carchange));
        }
    }
}

