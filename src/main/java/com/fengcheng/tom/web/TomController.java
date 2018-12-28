package com.fengcheng.tom.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import com.fengcheng.tom.entity.God;


@Controller
public class TomController {

	@Resource(name="thymeleafViewResolver")
	private ThymeleafViewResolver thymeleafViewResolver;
	
	@Value("${tom.port}")
	private String port;
	
	@RequestMapping("/")
	public String mulu() {
		System.out.println("跳转到		目录......");
		System.out.println(port);
		
		  //添加全局静态变量
        if (thymeleafViewResolver != null) {
               Map<String, Object> vars = new HashMap<>();
               vars.put("address", port);
               thymeleafViewResolver.setStaticVariables(vars);
           }
		
		return "index";
	}
	
	@RequestMapping("login")
	public String login() {
		System.out.println("登录验证		......");
		return "login";
	}
	
	
	
	@RequestMapping("t1")
	//传值可以用Model或者ModelMap
	public String thymeleaf1(Model model) {
		
		System.out.println("thymeleaf	基本操作1......");
		
		ArrayList<Object> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			God god = new God();
			god.setScore((int) (Math.random()*100+i));
			if (i%2==0) {
				god.setMale(1);
			}else {
				god.setMale(2);
			}
				
			list.add(god);
			model.addAttribute("test", list);
		}
		
		return "thymeleaf1";
	}
	
	@RequestMapping("t2")
	public String listView(ModelMap map) {
		 List<String> list=new ArrayList<String>();
	        list.add("1s");
	        list.add("2s");
	        list.add("3s");
	     map.put("list",list);
	     map.put("title","qwertyuiop");
	     map.put("tt","ok");
	     map.put("subId",4);
	     map.put("createDate",new Date());
		 map.put("msgutext","<b>1111</b>");
		System.out.println("thymeleaf	基本操作2......");
		
		ArrayList<Object> list2 = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			God god = new God();
			god.setMale(i);
			god.setScore(2*i);
			list2.add(god);
		}
		 map.put("subchannels",list2);
		return "thymeleaf2";
	}
	
}
