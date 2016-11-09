package com.moilion.circle.r044.controller;

import com.moilion.circle.r044.interceptor.cdn.CdnFunction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author trydofor
 * @since 2016-11-09
 */
@Controller
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    public String index(HttpServletRequest request){

        CdnFunction cdn = (CdnFunction)request.getAttribute("cdn");
        String img = cdn.url("image/150x60-moilioncircle.png");
        return "moilion-logo:<img src="+img+" />";
    }
}
