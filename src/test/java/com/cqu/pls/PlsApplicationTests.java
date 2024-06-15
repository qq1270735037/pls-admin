package com.cqu.pls;

import com.cqu.pls.entity.Addressinfo;
import com.cqu.pls.entity.Certificateinfo;
import com.cqu.pls.service.AddressinfoService;
import com.cqu.pls.service.CertificateinfoService;
import com.cqu.pls.service.impl.AddressinfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PlsApplicationTests {

    @Resource
    private CertificateinfoService certificateinfoService;

    @Test
    void contextLoads() {
//        List<Certificateinfo> certificateinfos = certificateinfoService.queryAll();
//        System.out.println(certificateinfos);
    }

}
