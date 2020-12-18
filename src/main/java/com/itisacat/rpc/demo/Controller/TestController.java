package com.itisacat.rpc.demo.Controller;

import com.itisacat.rpc.demo.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/v1.1")
public class TestController {
    @Autowired
    private ProductServiceImpl productService;

    @RequestMapping(value = "/exe", method = RequestMethod.GET)
    public String getRpcList() {
        productService.execute();
        return "";
    }
}
