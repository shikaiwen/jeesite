/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.dtest.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.dtest.entity.MyTestData;
import com.thinkgem.jeesite.modules.dtest.service.TestDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 策划死Controller
 * @author Kevin
 * @version 2018-04-12
 */
@Controller("kTestDataController")
@RequestMapping(value = "${adminPath}/dtest/myTestData")
public class TestDataController extends BaseController {

	@Autowired
	private TestDataService testDataService;
	
	@ModelAttribute
	public MyTestData get(@RequestParam(required=false) String id) {
		MyTestData entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testDataService.get(id);
		}
		if (entity == null){
			entity = new MyTestData();
		}
		return entity;
	}
	
	@RequiresPermissions("dtest:myTestData:view")
	@RequestMapping(value = {"list", ""})
	public String list(MyTestData myTestData, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MyTestData> page = testDataService.findPage(new Page<MyTestData>(request, response), myTestData);
		model.addAttribute("page", page);
		return "modules/dtest/myTestDataList";
	}

	@RequiresPermissions("dtest:myTestData:view")
	@RequestMapping(value = "form")
	public String form(MyTestData myTestData, Model model) {
		model.addAttribute("myTestDataForm", myTestData);
		return "modules/dtest/myTestDataForm";
	}

	@RequiresPermissions("dtest:myTestData:edit")
	@RequestMapping(value = "save")
	public String save(MyTestData myTestData, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, myTestData)){
			return form(myTestData, model);
		}
		testDataService.save(myTestData);
		addMessage(redirectAttributes, "保存策划死成功");
		return "redirect:"+Global.getAdminPath()+"/dtest/myTestData/?repage";
	}
	
	@RequiresPermissions("dtest:myTestData:edit")
	@RequestMapping(value = "delete")
	public String delete(MyTestData myTestData, RedirectAttributes redirectAttributes) {
		testDataService.delete(myTestData);
		addMessage(redirectAttributes, "删除策划死成功");
		return "redirect:"+Global.getAdminPath()+"/dtest/myTestData/?repage";
	}

}