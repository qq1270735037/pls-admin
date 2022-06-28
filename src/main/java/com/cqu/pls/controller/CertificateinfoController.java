package com.cqu.pls.controller;

import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.service.CertificateinfoService;

import com.cqu.pls.utils.result.DataResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Certificateinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:04
 */
@RestController
@RequestMapping("/certificateinfo")
public class CertificateinfoController {
    /**
     * 服务对象
     */
    @Resource
    private CertificateinfoService certificateinfoService;


//    @GetMapping
//    public ResponseEntity<Page<Certificateinfo>> queryByPage(Certificateinfo certificateinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.certificateinfoService.queryByPage(certificateinfo, pageRequest));
//    }


    @GetMapping("/selectAll")
    public DataResult queryAll() {

        return DataResult.successByDataArray(certificateinfoService.queryAll());
    }
    @PostMapping("/selectOne")
    public DataResult queryOne(Certificateinfo certificateinfo){
        return DataResult.successByDataArray(certificateinfoService.queryOne(certificateinfo));
    }



    /**
     * 新增数据
     *
     * @param certificateinfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public DataResult add(Certificateinfo certificateinfo) {
        return DataResult.successByData(certificateinfoService.insert(certificateinfo));
    }

    /**
     * 编辑数据
     *
     * @param certificateinfo 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public DataResult edit(Certificateinfo certificateinfo) {
        return DataResult.successByData(certificateinfoService.update(certificateinfo));
    }


    @PostMapping("/deleteById")
    public DataResult deleteById (@RequestBody Certificateinfo certificateinfo) {
        return DataResult.successByDatas(certificateinfoService.deleteById(certificateinfo.getCertificateId()));

    }

}

