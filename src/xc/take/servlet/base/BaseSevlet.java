package xc.take.servlet.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public  class BaseSevlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//从请求中拿到全类名
			String handler = request.getParameter("handler");
			try {
				
				//获取真正处理类Class对象
				Class<? extends BaseSevlet> clazz= (Class<? extends BaseSevlet>) Class.forName(handler);
				//获取真正处理对象
				BaseSevlet s = clazz.newInstance();
				//获取方法
				Method method = clazz.getMethod("requestHandler",HttpServletRequest.class,HttpServletResponse.class);
				//执行业务逻辑
				method.invoke(s, request,response);
			
				
			} catch (Exception e) {
				// 
				e.printStackTrace();
			}
			
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}
	
	public Object requestHandler(HttpServletRequest request, HttpServletResponse response){
			
		
		return null;
	}

}
