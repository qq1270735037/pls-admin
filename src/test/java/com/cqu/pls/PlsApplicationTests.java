package com.cqu.pls;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.service.AddressinfoService;
import com.cqu.pls.service.impl.AddressinfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PlsApplicationTests {

    @Resource
    private AddressinfoService addressinfoService;

    @Test
    void contextLoads() {
        Addressinfo addressinfo = addressinfoService.queryById(1);
        System.out.println(addressinfo);
    }

}
