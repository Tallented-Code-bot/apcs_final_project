package com.calvin.bank_server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {
    @RequestMapping("/test")
    @ResponseBody
    public String index(){
        return "index";
    }
}
