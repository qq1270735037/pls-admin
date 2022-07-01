package com.cqu.pls.controller;

import com.cqu.pls.dao.MatetialinfoDao;
import com.cqu.pls.dto.MaterialInfoDTO;
import com.cqu.pls.entity.Materialtype;
import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.service.MaterialtypeService;
import com.cqu.pls.service.MatetialinfoService;

import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.vo.MaterialAndType;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Resource
    private MaterialtypeService materialtypeService;

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
    @PostMapping("selectByType")
    @ResponseBody
    public DataResult selectByType(@RequestBody(required = false)Matetialinfo matetialinfo) {

        Long total = matetialinfoService.selectByType(matetialinfo);

//        System.out.println("*****************************");
//        System.out.println(materialInfoDTO);

        return DataResult.successByDatas(total);
    }

    /**
     * 根据类型查询数量
     * @return
     */
    @PostMapping("selectByName")
    @ResponseBody
    public DataResult selectByName(@RequestBody(required = false)MaterialInfoDTO materialInfoDTO) {
        //查询得到总条数
        materialInfoDTO.setPage((materialInfoDTO.getPage() - 1) * materialInfoDTO.getLimit());
        Matetialinfo matetialinfo = new Matetialinfo();
        BeanUtils.copyProperties(materialInfoDTO, matetialinfo);
        List<MaterialAndType> materialAndTypes = matetialinfoService.selectByName(materialInfoDTO);
        BeanUtils.copyProperties(materialAndTypes, matetialinfo);
//        System.out.println("*****************************");
//        System.out.println(materialInfoDTO);
        Long total = this.matetialinfoService.selectByNamecount(matetialinfo);
        return DataResult.successByTotalData(materialAndTypes,total);
    }
    /**
     * 新增数据
     *
     * @param matetialinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody Matetialinfo matetialinfo) {
        System.out.println(matetialinfo);
        return DataResult.successByData(matetialinfoService.insert(matetialinfo));
    }


    @PostMapping("edit")
    public DataResult edit(@RequestBody Matetialinfo matetialinfo) {

        return DataResult.successByData(matetialinfoService.update(matetialinfo));
    }
    /**
     * 删除数据
     *
     * @param matetialinfo 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody Matetialinfo matetialinfo) {
        boolean b = this.matetialinfoService.deleteById(matetialinfo);
        return DataResult.successByDatas(b);
    }

    /**
     * \
     * 联合查询
     *
     * @return
     */
    @PostMapping("getMaterialAndTypeList")
    public DataResult getMaterialAndTypeList(@RequestBody(required = false)MaterialInfoDTO materialInfoDTO) {
//        System.out.println("*****************************");
//        System.out.println(materialInfoDTO);
        //查询得到总条数
        materialInfoDTO.setPage((materialInfoDTO.getPage() - 1) * materialInfoDTO.getLimit());
        Matetialinfo matetialinfo = new Matetialinfo();
        Long total = this.matetialinfoService.count(matetialinfo);
        return DataResult.successByTotalData(this.matetialinfoService.getMaterialAndTypeList(materialInfoDTO),total);
    }

    @PostMapping("selectType")
    public DataResult selectType() {
//        System.out.println(materialtypeService.queryAll());
        return DataResult.successByDataArray(materialtypeService.queryAll());
    }
}

