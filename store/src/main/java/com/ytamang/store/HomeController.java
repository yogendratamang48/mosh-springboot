package com.ytamang.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

   @Value("${spring.application.name}")
    private String apppName;

    @RequestMapping("/")
    public String index() {
        System.out.println(apppName);
        String viewName = getViewName();
        return viewName;
    }

    private String getViewName() {
        return "index.html";
    }
}
