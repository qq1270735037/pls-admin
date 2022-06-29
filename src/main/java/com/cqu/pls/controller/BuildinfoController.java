package com.cqu.pls.controller;

import com.cqu.pls.dto.BuildAndTypeDTO;
import com.cqu.pls.dto.MaterialInfoDTO;
import com.cqu.pls.entity.Buildinfo;
import com.cqu.pls.entity.Matetialinfo;
import com.cqu.pls.service.BuildinfoService;
import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.vo.BuildAndAddress;
import com.cqu.pls.vo.MaterialAndType;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Buildinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:03
 */
@RestController
@RequestMapping("buildinfo")
public class BuildinfoController {
    /**
     * 服务对象
     */
    @Resource
    private BuildinfoService buildinfoService;

    /**
     * 分页查询
     *
     * @param buildinfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<Buildinfo>> queryByPage(Buildinfo buildinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.buildinfoService.queryByPage(buildinfo, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Buildinfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildinfoService.queryById(id));
    }

    @PostMapping("selectAll")
    @ResponseBody
    public DataResult selectAll() {

        return DataResult.successByDataArray(buildinfoService.queryAll());
    }

    /**
     * 新增数据
     *
     * @param buildinfo 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody Buildinfo buildinfo) {
        return DataResult.successByDatas(this.buildinfoService.insert(buildinfo));
    }

    /**
     * 编辑数据
     *
     * @param buildinfo 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody Buildinfo buildinfo) {
        return DataResult.successByDatas(this.buildinfoService.update(buildinfo));
    }

    /**
     * 删除数据
     *
     * @param buildinfo 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody Buildinfo buildinfo) {
        return DataResult.successByDatas(this.buildinfoService.deleteById(buildinfo));
    }

    /**
     * \
     * 联合查询
     *
     * @return
     */
    @PostMapping("getBuildAndAddress")
    public DataResult getBuildAndAddress() {
        return DataResult.successByDataArray(this.buildinfoService.getBuildAndAddressList());
    }

    /**
     * 根据名字查询
     *
     * @return
     */
    @PostMapping("getBuildByName")
    @ResponseBody
    public DataResult getBuildByName(@RequestBody(required = false) BuildAndTypeDTO buildAndTypeDTO) {
        //查询得到总条数
        buildAndTypeDTO.setPage((buildAndTypeDTO.getPage() - 1) * buildAndTypeDTO.getLimit());
        Buildinfo buildinfo = new Buildinfo();
        BeanUtils.copyProperties(buildAndTypeDTO, buildinfo);
        List<BuildAndAddress> buildAndAddresses = buildinfoService.getBuildByName(buildAndTypeDTO);

        BeanUtils.copyProperties(buildAndAddresses, buildinfo);

        Long total = this.buildinfoService.selectByNamecount(buildinfo);

        return DataResult.successByTotalData(buildAndAddresses,total);
    }

}

