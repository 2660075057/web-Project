package biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Tbldao;
import pojo.Bill;
import pojo.Detail;

@Service
public class Tblbiz {
	@Autowired
	private Tbldao dao;
	
	
	public Tbldao getDao() {
		return dao;
	}


	public void setDao(Tbldao dao) {
		this.dao = dao;
	}


	public List<Bill> queryAll(String billno) {
		return dao.queryAll(billno);
		
	}
	
	public int addbill(Bill b) {
		String ss1 = dao.selsp(b.getSuppliername());
		List<Integer> sb = new ArrayList<Integer>();
		for (Detail t : b.getDetails()) {
			Integer ss=Integer.parseInt(t.getGoodsnum());
			Integer sa=Integer.parseInt(t.getGoodsprice());
			int bb=ss*sa;
			sb.add(bb);
			System.out.println(bb);
		}
		int mo=0;
		if (sb.size()!=0) {
			
			for (Integer u : sb) {
				mo+=u;
				System.out.println(mo);
			}
		}
		if (ss1==null) {
			
			dao.addsp(b.getSuppliername(),mo);
		}
		if (ss1!=null) {
			dao.addsp(b.getSuppliername(), mo);
		}
		
		
		return dao.addbill(b);
	}
	
	public String seldate(String date) {
		Long ss = dao.seldate(date);
		String id;
		if (ss!=null) {
			id=String.valueOf(ss+1);
		}else{
			id=date+"0001";
		}
		return id;
		
	}
	
}
