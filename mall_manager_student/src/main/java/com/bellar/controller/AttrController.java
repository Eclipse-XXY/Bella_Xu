package com.bellar.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.bellar.bean.MODEL_OBJECT_T_MALL_ATTR;
import com.bellar.bean.OBJECT_T_MALL_ATTR;
import com.bellar.service.AttrService;
@Controller
public class AttrController {
	@Autowired
	AttrService AttrServiceImpl;

	@RequestMapping("/get_attr_by_class2")

	public String get_attr_by_class2(int class_2_id, String class_2_name, Map<String, Object> map) {
		List<OBJECT_T_MALL_ATTR> list_attr = AttrServiceImpl.get_attr_by_class_2_id(class_2_id);
		map.put("list_attr", list_attr);
		map.put("class_2_name", class_2_name);
		map.put("class_2_id", class_2_id);
		return "manager_attr_list_inner";
	}

	// 因为list_value的对象好写但是list_attr没有set方法所以需要在写一个类MODEL_OBJECT_T_MALL_ATTR
	@RequestMapping("/save_attr")

	public ModelAndView save_attr(int class_2_id, String class_2_name, MODEL_OBJECT_T_MALL_ATTR listObject,
			ModelMap map) {
    	AttrServiceImpl.add_attr(listObject,class_2_id);
//			ModelAndView modelAndView = new ModelAndView("redirect:goto_add_attr.do");
//			modelAndView.addObject("class_2_id", class_2_id);
//			modelAndView.addObject("class_2_name", class_2_name);
//			modelAndView.addObject("success", "添加成功");
			
			ModelAndView modelAndView = new ModelAndView("redirect:/index.do");
			modelAndView.addObject("success", "恭喜");
			modelAndView.addObject("url", "goto_add_attr.do");
			modelAndView.addObject("title", "分类属性信息");
			return modelAndView;	
	}

	@RequestMapping("/goto_add_attr")

	public String goto_add_attr(String success, int class_2_id, String class_2_name, ModelMap map) {
		map.put("class_2_id", class_2_id);
		map.put("class_2_name", class_2_name);
		map.put("success", success);
		
		return "manager_attr_add";
	}
//	@RequestMapping("/goto_add_attr")
//
//	public ModelAndView goto_add_attr(String success, int class_2_id, String class_2_name) {
//		ModelAndView modelAndView = new ModelAndView("redirect:index.do");
//	
//	    modelAndView.addObject("url", "goto_add_attr.do");
//		modelAndView.addObject("title", "spu信息");
//		modelAndView.addObject("class_2_id", class_2_id);
//		modelAndView.addObject("class_2_name", class_2_name);
//		modelAndView.addObject("success", "添加成功");
//		return modelAndView;
//	
//	}
	@RequestMapping("get_attr_by_class_2_json")
	@ResponseBody
	public List<OBJECT_T_MALL_ATTR> get_attr_by_class_2_json(int class_2_id, String class_2_name) {
		List<OBJECT_T_MALL_ATTR> list_attr = AttrServiceImpl.get_attr_by_class_2_id(class_2_id);
		return list_attr;
	}
}
