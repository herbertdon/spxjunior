package com.ebao.spxjunior.spittr.web;

import com.ebao.spxjunior.spittr.Spitter;
import com.ebao.spxjunior.spittr.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
/**
 * Created by dondavid on 17/9/11.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

  private SpitterRepository spitterRepository;

  @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }

  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm() {
    return "registerForm";
  }

  //@Valid注解标注了Spitter对象,这个对象来自于用户提交的表单构建而成,Spring会对@Valid对象进行合法性进行校验.
  //校验的内容在POJO中标注
  //POJO中的校验注解都是JAVA validation API接口,实现是Hibernate Validation提供.
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
      @Valid Spitter spitter,
      Errors errors) {
    if (errors.hasErrors()) {
      return "registerForm";
    }

    spitterRepository.save(spitter);
    //这里不能用forward,forward服务器内跳转到showSpitterProfile请求,请求方式仍然为POST,而show只接受GET.
    return "redirect:/spitter/" + spitter.getUsername();
  }

  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(@PathVariable String username, Model model) {
    Spitter spitter = spitterRepository.findByUsername(username);
    model.addAttribute(spitter);
    return "profile";
  }
}
