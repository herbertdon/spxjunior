package com.ebao.spxjunior.spittr.web;

import com.ebao.spxjunior.spittr.Spittle;
import com.ebao.spxjunior.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dondavid on 17/8/30.
 */
@Controller @RequestMapping("/spittles")
public class SpittleController {
  private SpittleRepository spittleRepository;
  private static final String MAX_LONG_AS_STRING = "9223372036854775807";

  @Autowired public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

/*  @RequestMapping(method = RequestMethod.GET)
  public String spittles(Model model) {
    *//**
     * As Model is a map, if we add attribute without the key, the key will be auto assigned.
     * Here the value is a type of "List<Spittle>", so the key is set as "spittleList".
     *//*
    model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
    //				model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));

    return "spittles";
  }*/

  /**
   * This is another way to write controller, set the model and return the view.
   * as we use "/spittles" to call this method, so the "spittles" without "/" is the view name.
   * and the key in Model should be "spittleList".
   */
    /*@RequestMapping(method = RequestMethod.GET)
		public List<Spittle> spittles(){
				return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		}*/

  /**
   * the view is set to "spittles" which is base on the request path "/spittles".
   * @param max
   * @param count
   * @return
   */
  @RequestMapping(method = RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
      @RequestParam(value = "count", defaultValue = "20") int count) {
    return spittleRepository.findSpittles(max, count);//view = "spittles"
  }

  /**
   * 这里是路径方式的参数,更加面向资源,上述的参数方式更像是基于RPC的请求
   * 另外,PathVariable,如果请求的路径参数和java的参数都一样,都是spittleId,后面的Value可以省略,不过这里
   * 仍然写了
   * @param spittleId
   * @param model
   * @return
   */
  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
  public String spittle(
      @PathVariable("spittleId") long spittleId,
      Model model) {
    model.addAttribute(spittleRepository.findOne(spittleId));//key="spittle"
    return "spittle";
  }

}
