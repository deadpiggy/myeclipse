package com.hyh.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hyh.pojo.Toy;

@Repository("toyMapper")
public interface ToyMapper {

//	@Select("select id, name, price, create_date createDate from toy where id=#{id}")
	Toy findById( @Param("id")Integer id );
	
//	@Select("select * from toy")
	List<Toy> find();
	
	List<Toy> findPager(@Param("page") Integer page, @Param("rows") Integer rows, @Param("name") String name,
			@Param("price") Double price, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

	List<Toy> findParam(@Param("name") String name, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

	int getTotal(@Param("name") String name, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

	@Insert("insert into toy( name, price, create_date ) values( #{name}, #{price}, #{createDate} )")
	int add(Toy toy);

	@Update("update toy set name=#{name}, price=#{price}, create_date=#{createDate} where id=#{id}")
	int modify(Toy toy);

	@Delete("delete from toy where id=#{id}")
	int delete(int id);
}
