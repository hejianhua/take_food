package xc.take.servlet.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodeFilter implements Filter {

	@Override
	public void destroy() {
	System.out.println("过滤器销毁了");
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain Chain) throws IOException, ServletException {
		HttpServletRequest  request= (HttpServletRequest) req;
		HttpServletResponse  response =  (HttpServletResponse) res;
		
		String uri = request.getRequestURI();
		String[] strings = uri.split("/");
		System.out.println(strings[strings.length-1]);
		
		
		
/*		StringBuffer url = request.getRequestURL();
		
		System.out.println(uri);
		System.out.println(url);
		
		/take_food/ShowBillVoServlet
		http://localhost:8080/take_food/ShowBillVoServlet
		
		*
		*/
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//System.out.println("执行过滤器");
		EncodeRequest encodeRequest = new EncodeRequest(request);
		
		
		Chain.doFilter(encodeRequest, response);
		if(true){
			return;
		}
		System.out.println("后面的还执行吗？");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器初始化");
		
	}

}


//这个类用装饰者模式，增强request

class EncodeRequest  extends HttpServletRequestWrapper{

	private  HttpServletRequest  request;
	
	public EncodeRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
	}
	
	//编写需要增强的方法
	public String getParameter(String name){
		try {
			//获取参数值
			String value = request.getParameter(name);
			
			//记得null的处理
			if(value==null){
				return null;
			}
			
			if(request.getMethod().equalsIgnoreCase("get")){
				 value = new String(value.getBytes("ISO-8859-1"),"utf-8");
				 return value; 
			}else{
				return value;
			}
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	
	
}





