package com.cqu.pls.controller;

import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.service.CertificateinfoService;

import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.utils.result.code.Code;
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
    public DataResult queryOne(@RequestBody Certificateinfo certificateinfo){
        return DataResult.successByDataArray(certificateinfoService.queryOne(certificateinfo));
    }



    /**
     * 新增数据
     *
     * @param certificateinfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public DataResult add(@RequestBody Certificateinfo certificateinfo) {

        try{
            boolean b = certificateinfoService.insert(certificateinfo);
            return DataResult.successByDatas(b);

        }catch (Exception ex){

            return DataResult.err().setMessage("新增失败,请查看是否填写字段有误");

        }




    }

    /**
     * 编辑数据
     *
     * @param certificateinfo 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    public DataResult edit(@RequestBody Certificateinfo certificateinfo) {
        Certificateinfo certificateinfo1 = certificateinfoService.update(certificateinfo);
        if(certificateinfo1==null) return DataResult.err().setMessage("修改,请查看是否填写字段有误");
        return DataResult.successByData(certificateinfo1);

    }


    @PostMapping("/deleteById")
    public DataResult deleteById (@RequestBody Certificateinfo certificateinfo) {
        boolean b = certificateinfoService.deleteById(certificateinfo.getCertificateId());
        if(b==false){
            return DataResult.err().setMessage("删除失败");

        }
        return DataResult.successByDatas(b);


    }

}

