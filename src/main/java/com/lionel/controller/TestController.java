package com.lionel.controller;

import com.lionel.bean.commons.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description 测试控制层
 * @Author guhongxing
 * @Date 2018/12/21 15:56
 **/
@RestController("/test")
public class TestController {


    @GetMapping("/hello")
    public ResultDTO helloWord() {
        return new ResultDTO();
    }
}
