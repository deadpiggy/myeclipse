package com.hyh.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hyh.pojo.Toy;
import com.hyh.service.ToyService;

public class ToyTest {

	ToyService toyService;
	
	@Test
	public void find() {
		List<Toy> toys = toyService.find();
		for( Toy toy : toys ) {
			System.out.println( toy.getId() + " " + toy.getName() + toy.getCreateDate() );
		}
	}
	
	@Test
	public void findParam() {
		String name = null;
		name = "小";
		Date beginDate = null;
		Date endDate = null;
		List<Toy> toys = toyService.find(name, beginDate, endDate);
		for( Toy toy : toys ) {
			System.out.println( toy.getId() + " " + toy.getName() + toy.getCreateDate() );
		}
	}
	
	@Test
	public void delete() {
		int count = toyService.delete(18);
		if( count > 0 ) {
			System.out.println( "删除成功...." );
		}else {
			System.out.println( "删除失败....." );
		}
	}
	
	@Test
	public void modify() {
		Toy toy = toyService.find( 19 );
		System.out.println( toy.getName() + toy.getCreateDate() );
		toy.setCreateDate(new Date());
		int count = toyService.modify(toy);
		if( count > 0 ) {
			System.out.println( "修改成功...." );
		}else {
			System.out.println( "修改失败....." );
		}
	}
	
	@Test
	public void add() {
		Toy toy = new Toy();
		toy.setName( "黑皇杖" );
		toy.setPrice( 3795d );
		toy.setCreateDate(new Date());
		int count = toyService.add(toy);
		if( count > 0 ) {
			System.out.println( "添加成功...." );
		}else {
			System.out.println( "添加失败....." );
		}
	}
	
	@Before
	public void init() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext( "applicationContext.xml" );
		toyService = ctx.getBean( "toyService", ToyService.class );
	}
	
}
