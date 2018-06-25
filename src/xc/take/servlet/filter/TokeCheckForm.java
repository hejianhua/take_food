package xc.take.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.servlet.controller.TokenServlet;

public class TokeCheckForm  implements  Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
   /**
    * 此过滤器是为了处理表单重复提交的。
    * 思路：
    * 	1、我已经自定义了token标签，此标签会生成一个唯一的标识token。自定义标签会在jsp页面加载的时候执行。
    * 	2.在自定义标签时，我已经把此token放入了session域中。
    * 	3. 当表单提交的时候，此token标识会跟随request来到过滤器。
    * 	4.若request带来的标识为空，则说明不是表单页面。
    * 	6.request带来的标识不为空， 在过滤器中进行判断，此token标识是否与session域中的标识一致，若一致可以提交，而且把session中的token删除。
    * 	6.若request带来的标识与session的不一致，则重复提交。若session域中没有标识，则重复提交。
    * 
    * 
    * */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain doChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response =  (HttpServletResponse) res;
		
		boolean check = TokenServlet.tokenCheck(request);
			if(check){
				doChain.doFilter(request, response);
			}else{
				response.getWriter().write("大兄弟，你提交表单多次了");
			}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
		
}
