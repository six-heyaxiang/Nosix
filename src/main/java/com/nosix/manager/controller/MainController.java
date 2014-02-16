package com.nosix.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Moji on 14-2-16.
 */
@Controller
@RequestMapping("main")
public class MainController {
    @RequestMapping("")
    public String main(){
        return "views/main";
    }

}
