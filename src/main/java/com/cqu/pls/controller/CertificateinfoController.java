package com.cqu.pls.controller;

import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.entity.Employeeinfo;
import com.cqu.pls.service.CertificateinfoService;

import com.cqu.pls.service.EmployeeinfoService;
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
    @Resource
    private EmployeeinfoService employeeinfoService;


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

        //查询失败不会报错
//        try{
//            employeeinfoService.queryById(certificateinfo.getEmployeeId()); //添加之前先去寻找主表中是否有相应的人员
//        }catch (Exception e){
//            return DataResult.err().setMessage("人员表中查无此人, 无法为其新增证件信息");
//
//        }

        Employeeinfo employeeinfo= employeeinfoService.queryById(certificateinfo.getEmployeeId()); //添加之前先去寻找主表中是否有相应的人员
        if(employeeinfo==null)  return DataResult.err().setMessage("人员表中查无此人, 无法为其新增证件信息");




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


        try{
            Certificateinfo certificateinfo1 = certificateinfoService.update(certificateinfo);
            return DataResult.successByData(certificateinfo1);

        }catch(Exception e){
             return DataResult.err().setMessage("修改失败,请查看是否填写字段有误");
        }



    }


    @PostMapping("/deleteById")
    public DataResult deleteById (@RequestBody Certificateinfo certificateinfo) {

        try{
            boolean b = certificateinfoService.deleteById(certificateinfo.getCertificateId());
            return DataResult.successByDatas(b);


        }

        catch(Exception e){
            return DataResult.err().setMessage("删除失败,");

        }



    }

}

