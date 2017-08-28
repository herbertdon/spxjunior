package com.ebao.spxjunior.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dondavid on 17/8/12.
 */
@Controller
public class HomeController {
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    System.out.println("Controller received the request from the client.");
    return "home";
  }
}
