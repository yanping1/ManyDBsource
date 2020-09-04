package com.yanping.manydb.manydb;

import com.yanping.manydb.manydb.base.service.DepartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManydbApplicationTests {

    @Autowired
    private DepartService departService;

    @Test
    void contextLoads() {
    }

}
