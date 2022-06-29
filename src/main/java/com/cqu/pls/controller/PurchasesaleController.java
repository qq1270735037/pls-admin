package com.cqu.pls.controller;

import com.cqu.pls.entity.Merchandiseinfo;
import com.cqu.pls.entity.Purchasesale;
import com.cqu.pls.service.MerchandiseinfoService;
import com.cqu.pls.service.PurchasesaleService;
import com.cqu.pls.utils.result.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

/**
 * (Purchasesale)表控制层
 *
 * @author makejava
 * @since 2022-06-29 10:59:25
 */
@RestController
@RequestMapping("purchasesale")
public class PurchasesaleController {
    //从dao层新增查询sql语句创建操控另外一张表的函数addTo...和reduceTo..., 在增购销信息和更改购销信息时需要使用到



    @Resource
    private MerchandiseinfoService merchandiseinfoService;

    /**
     * 服务对象
     */
    @Resource
    private PurchasesaleService purchasesaleService;

    @GetMapping("/selectAll")
    public DataResult selectAll(){
        return DataResult.successByDataArray(purchasesaleService.queryAll());

    }

    @PostMapping("/selectOne")
    public DataResult selectOne(@RequestBody Purchasesale purchasesale){
        return DataResult.successByDataArray(purchasesaleService.queryOne(purchasesale));


    }

    @PostMapping("/add")
    public DataResult add(@RequestBody Purchasesale purchasesale){

        //当主表没有货物编号需要自己去增加
        //查不着返回的是null
        //无论是购入还是售出都需要主表有相应的货物编号
        Merchandiseinfo merchandiseinfo= merchandiseinfoService.queryById(purchasesale.getMerchandiseId());
        if(merchandiseinfo==null){
            return DataResult.err().setMessage("货物主表中查无此货物,请到货物主表添加后再新建购售信息");

        }

        //当主表有相应货物编号
        if(purchasesale.getPurchasesaleType().equals("购入")){
            purchasesaleService.insert(purchasesale);
            Boolean b =purchasesaleService.addToMerchandiseInfo(purchasesale);

            if(b==false){
                return DataResult.err().setMessage("修改货物表单信息失败");
            }
            return DataResult.successByDatas(b);

        }
        else if(purchasesale.getPurchasesaleType().equals("售出")){
            if(merchandiseinfo.getRepositoryCount()<purchasesale.getPurchasesaleCount()){
                return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
            }
            purchasesaleService.insert(purchasesale);

            Boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale);
            if(b==false){
                return DataResult.err().setMessage("修改货物表单信息失败");
            }
            return DataResult.successByDatas(b);


        }
        else{

            return DataResult.err().setMessage("购销存类型有误");
        }
    }





    @PostMapping("/deleteById")
    public DataResult deleteById(@RequestBody Purchasesale purchasesale){
        boolean b = purchasesaleService.deleteById(purchasesale.getPurchasesaleId());
        if(b==false) return DataResult.err();

        return DataResult.successByDatas(purchasesaleService.deleteById(purchasesale.getPurchasesaleId()));
    }

    @PostMapping("/edit")
    public DataResult edit(@RequestBody Purchasesale purchasesale){

        Merchandiseinfo merchandiseinfo= merchandiseinfoService.queryById(purchasesale.getMerchandiseId());
        Purchasesale purchasesale1= purchasesaleService.queryById(purchasesale.getPurchasesaleId());
        int abs = purchasesale.getPurchasesaleCount()-purchasesale1.getPurchasesaleCount();

        //购入
        if(purchasesale1.getPurchasesaleType().equals("购入")){
            //购入修改购入
            if(purchasesale.getPurchasesaleType().equals("购入")){

                if(abs>0){
                    purchasesale.setPurchasesaleCount(abs);
                    boolean b =  purchasesaleService.addToMerchandiseInfo(purchasesale);
                    purchasesaleService.update(purchasesale);
                    if(b==false){
                        return DataResult.err().setMessage("修改货物表单信息失败");

                    }

                    return DataResult.successByDatas(b);


                }
                else{
                    abs=-abs;
                    if(merchandiseinfo.getRepositoryCount()<abs){
                        return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
                    }
                    purchasesale.setPurchasesaleCount(abs);
                    boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale);
                    purchasesaleService.update(purchasesale);
                    if(b==false){
                        return DataResult.err().setMessage("修改货物表单信息失败");
                    }

                    return DataResult.successByDatas(b);
                }


            }
            //购入修改售出
            else{
                int oldCount = purchasesale1.getPurchasesaleCount();
                int newCount = purchasesale.getPurchasesaleCount();
                int totalCount = oldCount+newCount;
                if(merchandiseinfo.getRepositoryCount()<totalCount){
                    return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
                }

                purchasesale.setPurchasesaleCount(totalCount);
                boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale);
                purchasesaleService.update(purchasesale);
                if(b==false)return DataResult.err().setMessage("修改货物表单信息失败");
                return DataResult.successByDatas(b);


            }


        }
        //售出
        else{
            //售出修改购入
            if(purchasesale.getPurchasesaleType().equals("购入")){
                int oldCount = purchasesale1.getPurchasesaleCount();
                int newCount = purchasesale.getPurchasesaleCount();
                int totalCount = oldCount+newCount;
                purchasesale.setPurchasesaleCount(totalCount);
                boolean b =purchasesaleService.addToMerchandiseInfo(purchasesale);
                purchasesaleService.update(purchasesale);
                if(b==false) return DataResult.err().setMessage("修改货物表单信息失败");
                return DataResult.successByDatas(b);

            }

            //售出修改售出
            else{

                if(abs>0){
                    if(merchandiseinfo.getRepositoryCount()<abs){
                        return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
                    }


                    purchasesale.setPurchasesaleCount(abs);
                    boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale);
                    purchasesaleService.update(purchasesale);
                    if(b==false) return DataResult.err().setMessage("修改货物表单信息失败");
                    return DataResult.successByDatas(b);


                }
                else{
                    abs=-abs;
                    purchasesale.setPurchasesaleCount(abs);
                    boolean b = purchasesaleService.addToMerchandiseInfo(purchasesale);
                    purchasesaleService.update(purchasesale);
                    if(b==false) return DataResult.err().setMessage("修改货物表单信息失败");
                    return DataResult.successByDatas(b);
                }



            }





        }





    }

}

