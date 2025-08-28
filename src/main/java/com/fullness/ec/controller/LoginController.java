package com.fullness.ec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/admin")
public class LoginController {
     @GetMapping("/login")
  public String login() {
    return "/admin/login";
  }
  
  @GetMapping("/admin")
  public String menu() {
    return "/admin/admin";
  }
}

