package com.cqu.pls.controller;

import com.alibaba.fastjson.JSON;
import com.cqu.pls.entity.Advertisementinfo;
import com.cqu.pls.service.AdvertisementinfoService;
//import com.cqu.pls.utils.MinioUtil;
import com.cqu.pls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Advertisementinfo)表控制层
 *
 * @author makejava
 * @since 2022-06-29 16:29:21
 */
@RestController
@RequestMapping("ad")
public class AdvertisementinfoController {
    /**
     * 服务对象
     */
    @Resource
    private AdvertisementinfoService advertisementinfoService;

//    /**
//     * 分页查询
//     *
//     * @param advertisementinfo 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @GetMapping
//    public ResponseEntity<Page<Advertisementinfo>> queryByPage(Advertisementinfo advertisementinfo, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.advertisementinfoService.queryByPage(advertisementinfo, pageRequest));
//    }

    /**
     *
     * @param ad 实体对象
     * @return
     */
    @PostMapping("queryAll")
    public DataResult queryByPage(@RequestBody(required = false) Advertisementinfo ad) {
        List<Advertisementinfo> advertisementinfos = this.advertisementinfoService.queryAll(ad);
        int size = advertisementinfos.size();
        return DataResult.successByTotalData(advertisementinfos,(long)size);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get")
    public DataResult queryById(@RequestParam("id") Integer id) {
        return DataResult.successByData(this.advertisementinfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ad 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public DataResult add(@RequestBody Advertisementinfo ad) {
        return DataResult.successByMessage("成功",
                this.advertisementinfoService.insert(ad));
    }
    @PostMapping("test")
    public  void  t(MultipartFile file){
        System.out.println("hhhhhh");
    }
//    @PostMapping("/insert")
//    public void insertGoods(@RequestParam(value = "ad",required = false) String ad,
//                                         @RequestParam(value = "file") MultipartFile file) {
////        Advertisementinfo parseObject = JSON.parseObject(ad,Advertisementinfo.class);
//        MinioUtil instance = MinioUtil.getInstance();
////        String upLoadFile = instance.upLoadFile(file);
////        parseObject.setAdImages(upLoadFile);
////        this.advertisementinfoService.insert(parseObject);
////        return resultMap.success().message("添加成功！");
//        System.out.println("执行插入");
////        System.out.println("广告："+parseObject);
//        System.out.println(upLoadFile);
////        return parseObject;
//    }
    /**
     * 编辑数据
     *
     * @param ad 实体
     * @return 编辑结果
     */
    @PostMapping("update")
    public DataResult edit(@RequestBody Advertisementinfo ad) {
        return DataResult.successByMessage("成功",
                this.advertisementinfoService.update(ad));
    }

    /**
     * 删除数据
     *
     * @param sid 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestBody String sid) {
        Integer id = Integer.parseInt(JSON.parseObject(sid).get("id").toString());
        return DataResult.successByMessage("成功",
                this.advertisementinfoService.deleteById(id));
    }

}

