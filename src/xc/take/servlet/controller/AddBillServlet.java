package xc.take.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.domain.BillVo;
import xc.take.service.BillVoServiceImpl;
import xc.take.service.IBillVoService;

public class AddBillServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		IBillVoService billVoServiceImpl = new BillVoServiceImpl();
		BillVo billVo = new BillVo();
		String u_id = request.getParameter("u_id");
		String f_id = request.getParameter("f_id");
		String m_id = request.getParameter("m_id");
		String number = request.getParameter("number");
		String totalMoney = request.getParameter("totalMoney");
		BigDecimal totalMoney1 = new BigDecimal(totalMoney);
		
		//set数据
		billVo.setCreateTimestamp(System.currentTimeMillis());
		billVo.setNumber(number);
		billVo.setF_id(Long.valueOf(f_id));
		billVo.setM_id(Long.valueOf(m_id));
		billVo.setStatus(Short.valueOf("1"));
		billVo.setU_id(Long.valueOf(u_id));
		billVo.setTotalMoney(totalMoney1);
		
		
		
		billVoServiceImpl.saveBillVo(billVo);
		
		response.sendRedirect(request.getContextPath()+"/menu.jsp");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
		
	}

}
