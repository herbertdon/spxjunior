package com.ebao.spxjunior.spittr.web;

import com.ebao.spxjunior.spittr.data.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dondavid on 17/8/30.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
		private SpittleRepository spittleRepository;

		@Autowired
		public SpittleController(SpittleRepository spittleRepository) {
				this.spittleRepository = spittleRepository;
		}

		@RequestMapping(method = RequestMethod.GET)
		public String spittles(Model model) {
				/**
				 * As Model is a map, if we add attribute without the key, the key will be auto assigned.
				 * Here the value is a type of "List<Spittle>", so the key is set as "spittleList".
				 */
				model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//				model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));

				return "spittles";
		}

		/**
		 * This is another way to write controller, set the model and return the view.
		 * as we use "/spittles" to call this method, so the "spittles" without "/" is the view name.
		 * and the key in Model should be "spittleList".
		 */
		/*@RequestMapping(method = RequestMethod.GET)
		public List<Spittle> spittles(){
				return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
		}*/
}
