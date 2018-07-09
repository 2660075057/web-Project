package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Bill;
import biz.Tblbiz;

@Controller
@RequestMapping("/tb")
public class Tblaction {
	
	@Autowired
	private Tblbiz biz;

	public Tblbiz getBiz() {
		return biz;
	}

	public void setBiz(Tblbiz biz) {
		this.biz = biz;
	}

	@RequestMapping("queryAll")
	@ResponseBody
	public Map<String, Object> queryAll(String billno) {
		Map< String, Object> map = new HashMap<String, Object>();
		try {
			List<Bill>list = biz.queryAll(billno);
		map.put("date", list);
		return map;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
		
	}
	@RequestMapping("addbill")
	@ResponseBody
	public Map<String, Object> addbill(@RequestBody Bill b) {
		Map< String, Object> map = new HashMap<String, Object>();
		try {
			int i= biz.addbill(b);
			if (i>0) {
				map.put("code", 200);
				return map;
			}
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
		
	}
	
	@RequestMapping("seldate")
	@ResponseBody
	public Map<String, Object> seldate(String date) {
		Map< String, Object> map = new HashMap<String, Object>();
		try {
			String id= biz.seldate(date);
			
				map.put("id", id);
				return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
		
	}
	
	
}
