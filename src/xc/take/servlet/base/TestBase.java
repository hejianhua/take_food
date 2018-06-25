package xc.take.servlet.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestBase  extends  BaseSevlet{

	
	@Override
	public Object requestHandler(HttpServletRequest request,HttpServletResponse response) {
		
		
		System.out.println("一些业务逻辑处理，并且跳转");
		
		
		
		return null; //根据业务返回值
	}
	
	
}
