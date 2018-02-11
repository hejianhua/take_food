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

public class AllotAdmin implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain dochain) throws IOException, ServletException {
		//从初始化参数中，获取到是否有权限
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) res;
		
		
		
		
		//获取到用户的角色，从而获得用户所有的权限。
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
