package com.cqu.pls.controller;

import com.cqu.pls.dto.CarinfoDTO;
import com.cqu.pls.entity.Carinfo;
import com.cqu.pls.service.CarinfoService;


import com.cqu.pls.utils.result.DataResult;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

//    /**
//     * 分页查询
//     *
//     * @param carinfo 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
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
//    @GetMapping("get")
//    public ResponseEntity<Carinfo> queryById(@RequestParam("id") Integer id) {
//        return ResponseEntity.ok(this.carinfoService.queryById(id));
//    }
    @GetMapping("get")
    public DataResult queryById(@RequestParam("id") Integer id) {
        Carinfo queryById = this.carinfoService.queryById(id);

        return DataResult.successByData(queryById);
    }

    /**
     * 全部查询，无分页
     * @param carinfo
     * @return
     */
//    @PostMapping("queryByCondition")
//    public DataResult queryByCondition(@RequestBody(required = false)  Carinfo carinfo) {
//        List<Carinfo> carinfos = carinfoService.queryBycondition(carinfo);
//        return DataResult.successByDataArray(carinfos);
//    }

    /**
     * 分页查询
     * @param carinfoDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody(required = false) CarinfoDTO carinfoDTO) {
        System.out.println(carinfoDTO);
        //计算起始条数
        carinfoDTO.setPage((carinfoDTO.getPage() - 1) * carinfoDTO.getLimit());
        Carinfo carinfoCountParam = new Carinfo();
        BeanUtils.copyProperties(carinfoDTO, carinfoCountParam);
        //查询得到总条数
        Long total = this.carinfoService.getCarByConditionCount(carinfoCountParam);
        List<Carinfo> carinfos = this.carinfoService.queryByPage(carinfoDTO);
        return DataResult.successByTotalData(carinfos,total);
    }
    /**
     * 新增数据
     *
     * @param carinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody(required = false) Carinfo carinfo) {
        this.carinfoService.insert(carinfo);
        return DataResult.succ();
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

