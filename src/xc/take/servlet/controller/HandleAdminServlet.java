package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import xc.take.domain.RoleVo;
import xc.take.service.IRoleVoService;
import xc.take.service.impl.RoleVoServiceImpl;

public class HandleAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IRoleVoService roleVoServiceImpl = new RoleVoServiceImpl();	
		
		String roleId = request.getParameter("roleId");
		RoleVo roleVo = roleVoServiceImpl.findById(Long.valueOf(roleId));
		//获取到选中的参数。
		Map<String,String> roleMap = new HashMap<String, String  >();
		Enumeration<String> parameterNames = request.getParameterNames();

		StringBuffer admin=new StringBuffer();
		while(parameterNames.hasMoreElements()){
			String element = parameterNames.nextElement();
			if(!"roleId".equals(element)){
				String value=new Gson().toJson(request.getParameterValues(element));
				roleMap.put(element, value);
			}
		}
		String pjson = new Gson().toJson(roleMap);  
		
		System.out.println(pjson);
		roleVo.setPjson(pjson);
		
		roleVoServiceImpl.modifyRoleVo(roleVo);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}
