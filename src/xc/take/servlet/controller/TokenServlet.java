package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenServlet {


	/**
	 * 返回true 则允许提交。
	 * 返回false，则已经提交过了，不可提交。
	 * */
	public static boolean tokenCheck(HttpServletRequest  request){
		String seToken = (String) request.getSession().getAttribute("token");
		String reqToken = (String) request.getParameter("token");
		
		System.out.println("进行了token的验证"+seToken+"-----"+reqToken);
		if(reqToken==null){
			System.out.println("说明request没有token，说明不是表单页面");
			return true;
		}
		if(seToken==null){
			System.out.println("说明session没有了token，是重复提交");
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
