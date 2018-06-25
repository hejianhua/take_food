package xc.take.servlet.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.Resource;
import xc.take.domain.RoleVo;
import xc.take.domain.UserVo;
import xc.take.service.IResourceService;
import xc.take.service.IRoleVoService;
import xc.take.service.IUserService;
import xc.take.service.impl.ResourceServiceImpl;
import xc.take.service.impl.RoleVoServiceImpl;
import xc.take.service.impl.UserServiceImpl;

public class AllotAdmin implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain dochain) throws IOException, ServletException {
		IUserService userServiceImpl = new UserServiceImpl();
		IRoleVoService roleVoServiceImpl=new RoleVoServiceImpl();
		IResourceService resourceServiceImpl=new ResourceServiceImpl();
		

		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) res;
		
		//从请求中获取url
		String uri = request.getRequestURI();
		String str = uri.split("/")[2];
		
		//查看此资源是否在数据库中
		Resource resource = resourceServiceImpl.findByUri(str);
		if(resource==null){
			
			dochain.doFilter(request, response);
		}else{
		
		//首先获取到当前的用户
		UserVo userVo = (UserVo) request.getSession().getAttribute("curUserVo");
		
		//获取到用户的角色，从而获得用户所有的权限。
		List<RoleVo> roleList = roleVoServiceImpl.findByUId(userVo.getId());
		
		boolean flag=false;
		//根据角色id获得权限。
		for (RoleVo roleVo : roleList) {
			List<Resource> resourceList = resourceServiceImpl.findByRoleId(roleVo.getId());
			for (Resource resour : resourceList) {
					if(str.equals(resour.getUrl())){
						System.out.println("角色有权限");
						flag=true;
					}
			}
		}
		if(flag){
			dochain.doFilter(request, response);
			
		}else{
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
