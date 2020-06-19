package com.tyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;

/**
 * @author: tangych
 * created on 2020/06/19
 **/
@Controller
public class HelloController {

  @PostConstruct
  void init(){
    System.out.println(11);
  }
  @RequestMapping("/hello")
  public String hello(){
    return "hello";
  }

  @RequestMapping("/login")
  public String login(@RequestParam("name") String name,@RequestParam("password") String password,
      ModelMap modelMap){
    modelMap.addAttribute("name",name);
    modelMap.addAttribute("password",password);
    return "index";
  }

}
