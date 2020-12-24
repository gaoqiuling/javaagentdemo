package com.itisacat.retry.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/v1.1")
public class TestController {
    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "/retry", method = RequestMethod.GET)
    public String getDailyCCtalkQrCode() throws IllegalAccessException {
        retryService.service();
        return "";
    }

}
