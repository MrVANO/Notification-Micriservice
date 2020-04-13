package com.notification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestConnectionController {
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String testConnection() {
        return "It's worked!";
    }
}