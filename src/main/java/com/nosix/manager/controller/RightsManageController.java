package com.nosix.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Moji on 14-2-16.
 */
@Controller
@RequestMapping(value = "rights")
public class RightsManageController {

    @RequestMapping("")
    public String rightsManageMain(){
        return "/views/rights/rights.jsp";
    }
}
