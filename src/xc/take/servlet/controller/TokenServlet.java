package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenServlet {


	
	public static boolean tokenCheck(HttpServletRequest  request){
		String seToken = (String) request.getSession().getAttribute("token");
		String reqToken = (String) request.getParameter("token");
		
		System.out.println("进行了token的验证"+seToken);
		if(seToken==null){
			System.out.println("说明session没有了token，是重复提交");
			return false;
		}
		if(reqToken==null){
			System.out.println("说明request没有了token，是重复提交");
			return false;
		}
		if(reqToken.equals(seToken)){
			System.out.println("相等，还没有提交");
			request.getSession().removeAttribute("token");
			return true;
		}
		//
		return false;
	}

}
