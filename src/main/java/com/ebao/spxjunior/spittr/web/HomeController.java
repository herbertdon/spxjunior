package com.ebao.spxjunior.spittr.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dondavid on 17/8/12.
 */
@Controller
public class HomeController {
  private static Logger logger = Logger.getLogger(HomeController.class);
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
//    System.out.println("Controller received the request from the client.");
    logger.debug("debug- Controller received the request from the client.");
    logger.info("info");
    logger.error("error");
    logger.trace("trace");
    return "home";
  }
}
