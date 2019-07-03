package com.johndoeo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *@ClassName:TestController
 *@Descreption: TODO
 *@Author: JohnDoeo
 *@Date: 2019/7/3 10:26
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return "弄哈了 es";
    }
}
