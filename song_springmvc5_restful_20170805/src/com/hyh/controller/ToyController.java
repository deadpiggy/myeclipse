package com.hyh.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hyh.pojo.Toy;
import com.hyh.service.ToyService;
import com.hyh.util.JsonDateValueProcessor;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

@Controller
public class ToyController {

	@Resource(name = "toyService")
	private ToyService toyService;

	// spa : Single Page Application 单页应用程序

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	// 根据 id 查询 接口需要 /toy/id
	@RequestMapping(value = "toy/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody 
	String findById(@PathVariable("id") Integer id) {
		System.out.println( "进入 toy/id 接口....." );
		Toy toy = toyService.find(id);
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSON json = JSONSerializer.toJSON(toy, jc);
		System.out.println( json.toString() );
		return json.toString();
	}

	// 通过接口访问 /toy
	@RequestMapping(value = "toy", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public @ResponseBody String list(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "beginDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date beginDate,
			@RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		List<Toy> toys = toyService.find(name, beginDate, endDate);
		JsonConfig jc = new JsonConfig();
		jc.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		JSON json = JSONSerializer.toJSON(toys, jc);
		System.out.println(json.toString());
		return json.toString();
	}

}