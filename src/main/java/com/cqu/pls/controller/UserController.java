package com.cqu.pls.controller;

import com.cqu.pls.entity.*;
import com.cqu.pls.service.*;
import com.cqu.pls.utils.result.DataResult;
import com.cqu.pls.vo.TransportationAndCar;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-24 14:34:05
 */
@RestController
@RequestMapping("user")
public class UserController {





    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
    @Resource
    private PurchasesaleService purchasesaleService;
    @Resource
    private CarchangeService carchangeService;
    @Resource
    private TransportationinfoService transportationinfoService;
    @Resource
    private AdvertisementinfoService advertisementinfoService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @GetMapping
//    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
//        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
//    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */

    @GetMapping("/getSalesValue")
    public DataResult getSalesValue(){

        //货物销售额
        List<Purchasesale> purchasesaleList = purchasesaleService.queryAll();
        int totalSales1 = 0;
        for (Purchasesale purchasesale:
             purchasesaleList) {
            if(purchasesale.getPurchasesaleType().equals("售出")){
                totalSales1+= purchasesale.getPurchasesalePrice()*purchasesale.getPurchasesaleCount();

            }

        }
        //汽车无价格,丢弃
//        Carchange carchange1 = new Carchange();
//        List<Carchange> carchangeList = carchangeService.getByOperation(carchange1);
//        for (Carchange carchange:
//             carchangeList) {
//            if(carchange.getOperation()==0){
//            }
//
//        }

        //
        int totalSales2=0;
        TransportationAndCar transportationAndCar1 = new TransportationAndCar();
        List<TransportationAndCar> transportationAndCars1List = transportationinfoService.queryBycondition(transportationAndCar1);
        for (TransportationAndCar transportationAndCar:
             transportationAndCars1List) {
            totalSales2+= Integer.parseInt(transportationAndCar.getTransportationMoney());
        }

        int totalSale3=0;


        Advertisementinfo advertisementinfo1 = new Advertisementinfo();
        List<Advertisementinfo> advertisementinfoList = advertisementinfoService.queryAll(advertisementinfo1);
        for (Advertisementinfo advertisementinfo:
             advertisementinfoList) {
            totalSale3+=  Integer.parseInt(advertisementinfo.getAdMoney()) ;

        }

        int totalMoney = totalSales1+totalSales2+totalSale3;
        return DataResult.successByDatas(totalMoney);



    }





    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }



    @PostMapping("total")
    public DataResult total() {
        return DataResult.successByDatas(this.userService.queryTotal());
    }
}

