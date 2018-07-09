package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Bill;

public interface Tbldao {
	
	public List<Bill> queryAll(@Param("billno")String billno);
	
	public int addbill(@Param("b")Bill b);
	
	public Long seldate(@Param("date")String date);
	
	public String selsp(@Param("sp")String sp);
	
	public int uosp(@Param("sp")String sp,@Param("mo")Integer mo);
	
	public int addsp(@Param("sp")String sp,@Param("mo")Integer mo);
}
