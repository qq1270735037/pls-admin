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
import java.util.List;

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


    @PostMapping("/preciseQuery")
    public DataResult preciseQuery(@RequestBody Purchasesale purchasesale){
        List<Integer> integers = purchasesaleService.preciseQueryMerchandiseIdByMerchandiseName(purchasesale.getMerchandiseName());
        if(integers.size()>1){
            return DataResult.err().setMessage("该货物名对应多个货物编号,请检查货物基本信息表");
        }
        else if(integers.size()==1){
            int a = integers.get(0);
            return DataResult.successByDatas(a);

        }
        else{
            return DataResult.err().setMessage("查询不到货物编号");
        }

    }

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
        else if(!purchasesale.getMerchandiseName().equals(merchandiseinfo.getMerchandiseName())){
            return DataResult.err().setMessage("该货物编号对应的货物名称出错");
        }


        //当主表有相应货物编号
        if(purchasesale.getPurchasesaleType().equals("购入")){


           try{

               Boolean b =purchasesaleService.addToMerchandiseInfo(purchasesale);
               try {
                   purchasesaleService.insert(purchasesale);

               }catch (Exception e){
                   //回滚报错
                   purchasesaleService.reduceToMerchandiseInfo(purchasesale);
                   return DataResult.err().setMessage("插入购销信息失败,请查看填写字段是否有误");
               }


               return DataResult.successByDatas(b);

           }catch (Exception e){
               return DataResult.err().setMessage("插入购销信息失败,请查看填写字段是否有误");
           }

        }
        //判断库存是否足够
        else if(purchasesale.getPurchasesaleType().equals("售出")){
            if(merchandiseinfo.getRepositoryCount()<purchasesale.getPurchasesaleCount()){
                return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
            }

            try{
                Boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale);
                //插入主表出错回滚抛异常
                try{
                    purchasesaleService.insert(purchasesale);

                }catch (Exception e){
                    purchasesaleService.addToMerchandiseInfo(purchasesale);
                    return DataResult.err().setMessage("插入购销信息失败,请查看填写字段是否有误");

                }

                return DataResult.successByDatas(b);

            }catch (Exception e){
                return DataResult.err().setMessage("插入购销信息失败,请查看填写字段是否有误");

            }




        }
        else{

            return DataResult.err().setMessage("购销存类型有误");
        }
    }




    //删除购销信息也会修改货物主表内容
    @PostMapping("/deleteById")
    public DataResult deleteById(@RequestBody Purchasesale purchasesale){
        Purchasesale purchasesale1 = purchasesaleService.queryById(purchasesale.getPurchasesaleId());
        if(purchasesale1.getPurchasesaleType().equals("购入")){
            try{
                 //因为之前加过所以减后库存>=0
                purchasesaleService.deleteById(purchasesale.getPurchasesaleId()); //删除主表信息一般没有异常
                return DataResult.successByDatas( purchasesaleService.reduceToMerchandiseInfo(purchasesale1));
            }
            catch (Exception e)
            {
                return DataResult.err().setMessage("删除失败, 其他错误");
            }

        }
        else{
            try{
                purchasesaleService.deleteById(purchasesale.getPurchasesaleId());
                return DataResult.successByDatas(purchasesaleService.addToMerchandiseInfo(purchasesale1));
            }
            catch (Exception e){
                return DataResult.err().setMessage("删除失败, 其他错误");
            }
        }

    }

    @PostMapping("/edit")  //p是新提交的表单数据, p1是旧的表单数据, p2.count是前两者差值的绝对值, p2.merchandiseId=...=...
    public DataResult edit(@RequestBody Purchasesale purchasesale){

        Merchandiseinfo merchandiseinfo= merchandiseinfoService.queryById(purchasesale.getMerchandiseId());
        Purchasesale purchasesale1= purchasesaleService.queryById(purchasesale.getPurchasesaleId());
        int abs = purchasesale.getPurchasesaleCount()-purchasesale1.getPurchasesaleCount();

        //购入
        if(purchasesale1.getPurchasesaleType().equals("购入")){
            //购入修改购入
            if(purchasesale.getPurchasesaleType().equals("购入")){



                if(abs>0){
                    Purchasesale purchasesale2 = new Purchasesale();
                    purchasesale2.setPurchasesaleCount(abs);
                    purchasesale2.setMerchandiseId(purchasesale.getMerchandiseId());


                    try{
                        boolean b =  purchasesaleService.addToMerchandiseInfo(purchasesale2);
                        try{
                            purchasesaleService.update(purchasesale);
                        }
                        catch(Exception e){
                            purchasesaleService.reduceToMerchandiseInfo(purchasesale2); //如果插入购销表出错, 回滚事务
                            return DataResult.err().setMessage("请检查输入字段是否正确");
                        }


                        return DataResult.successByDatas(b);

                    }catch (Exception e){
                        return DataResult.err().setMessage("修改货物表单信息失败");
                    }






                }
                else{
                    abs=-abs;
                    if(merchandiseinfo.getRepositoryCount()<abs){
                        return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
                    }
                    Purchasesale purchasesale2 = new Purchasesale();
                    purchasesale2.setPurchasesaleCount(abs);
                    purchasesale2.setMerchandiseId(purchasesale.getMerchandiseId());

                    try{
                        boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale2);
                        //回滚抛异常
                        try{
                            purchasesaleService.update(purchasesale);
                        }catch (Exception e){
                            purchasesaleService.addToMerchandiseInfo(purchasesale2);
                            return DataResult.err().setMessage("请检查输入字段是否正确");
                        }

                        return DataResult.successByDatas(b);

                    }catch (Exception e){
                        return DataResult.err().setMessage("修改货物表单信息失败");
                    }




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
                Purchasesale purchasesale2 = new Purchasesale();
                purchasesale2.setPurchasesaleCount(totalCount);
                purchasesale2.setMerchandiseId(purchasesale.getMerchandiseId());

                try{
                    boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale2);
                    try{
                        purchasesaleService.update(purchasesale);

                    }catch (Exception e){
                        purchasesaleService.addToMerchandiseInfo(purchasesale2);
                        return DataResult.err().setMessage("请检查输入字段是否正确");
                    }

                    return DataResult.successByDatas(b);

                }catch (Exception e){
                    return DataResult.err().setMessage("修改货物表单信息失败");

                }





            }


        }
        //售出
        else{
            //售出修改购入
            if(purchasesale.getPurchasesaleType().equals("购入")){
                int oldCount = purchasesale1.getPurchasesaleCount();
                int newCount = purchasesale.getPurchasesaleCount();
                int totalCount = oldCount+newCount;
                Purchasesale purchasesale2 = new Purchasesale();
                purchasesale2.setPurchasesaleCount(totalCount);
                purchasesale2.setMerchandiseId(purchasesale.getMerchandiseId());


                try{
                    boolean b =purchasesaleService.addToMerchandiseInfo(purchasesale2);
                    try{
                        purchasesaleService.update(purchasesale);

                    }catch (Exception e){
                        purchasesaleService.reduceToMerchandiseInfo(purchasesale2);
                        return DataResult.err().setMessage("请检查输入字段是否正确");
                    }

                    return DataResult.successByDatas(b);

                }catch (Exception e){
                    return DataResult.err().setMessage("修改货物表单信息失败");

                }

            }

            //售出修改售出
            else{

                if(abs>0){
                    if(merchandiseinfo.getRepositoryCount()<abs){
                        return DataResult.err().setMessage("货物仓库中的"+purchasesale.getMerchandiseName()+"库存不足!");
                    }

                    Purchasesale purchasesale2 = new Purchasesale();
                    purchasesale2.setPurchasesaleCount(abs);
                    purchasesale2.setMerchandiseId(purchasesale.getMerchandiseId());

                    try{
                        boolean b = purchasesaleService.reduceToMerchandiseInfo(purchasesale2);
                        try{
                            purchasesaleService.update(purchasesale);

                        }catch (Exception e){
                            purchasesaleService.addToMerchandiseInfo(purchasesale2);
                            return DataResult.err().setMessage("请检查输入字段是否正确");
                        }
                        return DataResult.successByDatas(b);

                    }catch (Exception e){
                       return DataResult.err().setMessage("修改货物表单信息失败");

                    }





                }
                else{
                    abs=-abs;
                    Purchasesale purchasesale2 = new Purchasesale();
                    purchasesale2.setPurchasesaleCount(abs);
                    purchasesale2.setMerchandiseId(purchasesale.getMerchandiseId());

                    try {
                        boolean b = purchasesaleService.addToMerchandiseInfo(purchasesale2);
                        try{
                            purchasesaleService.update(purchasesale);

                        }catch (Exception e){
                            purchasesaleService.addToMerchandiseInfo(purchasesale2);
                            return DataResult.err().setMessage("请检查输入字段是否正确");
                        }
                        return DataResult.successByDatas(b);

                    }catch (Exception e){
                        return DataResult.err().setMessage("修改货物表单信息失败");
                    }



                }



            }





        }





    }

}

