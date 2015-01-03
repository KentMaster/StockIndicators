package com.zhou.controller;

import com.zhou.model.StockInfo;
import com.zhou.repository.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;

@Controller
public class GreetingController {

    //    @Autowired String string;
//    @Autowired
//    StockInfoRepository mongoDBStockInfoRepository;
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

//    @RequestMapping("/greetings")
//    public String greetings(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", string);
//        return "greeting";
//    }

    @RequestMapping("/save")
    public String save(Model model) {
        model.addAttribute("name", "Saved");
//        mongoDBStockInfoRepository.save(new StockInfo("", 50.0, 20.0, 20.0, 5000, BigInteger.ONE, 20.0));
        return "greeting";
    }

}
