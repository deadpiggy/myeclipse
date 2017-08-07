package com.hyh.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hyh.dao.ToyMapper;
import com.hyh.pojo.Toy;

@Repository("toyService")
public class ToyService {

	@Resource(name = "toyMapper")
	private ToyMapper toyMapper;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
	public int add(Toy toy) {
		return toyMapper.add(toy);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int modify(Toy toy) {
		return toyMapper.modify(toy);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int delete( Integer id ) {
		return toyMapper.delete(id);
	}

	public Toy find( Integer id ) {
		return toyMapper.findById(id);
	}
	
	public List<Toy> find() {
		return this.toyMapper.find();
	}

	public List<Toy> find(String name, Date beginDate, Date endDate) {
		return this.toyMapper.findParam(name, beginDate, endDate);
	}

	public List<Toy> find(Integer page, Integer rows, String name, Double price, Date beginDate, Date endDate) {
		return this.toyMapper.findPager(page, rows, name, price, beginDate, endDate);
	}

}
