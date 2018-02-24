package xc.take.servlet.UI;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lol.redScarf.base.logistics.aicha.LogisticsComsUtils;
import lol.redScarf.base.logistics.kuaidi100.KuaiDi100ReaderExpressJson;
import lol.redScarf.base.logistics.kuaidi100.util.KuaiDi100Express;
import xc.take.util.Express;
import xc.take.util.ReaderExpressJson;

public class ShowExpressServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ShowExpressServlet.class.getResourceAsStream("text2.json");
		
		
		//Map<String, List<Express>> map = ReaderExpressJson.getAll();
	
/*		List<Map<String,Object>> coms = LogisticsComsUtils.getAllLogisticsComs();
		System.out.println(coms);*/
		
		
		Map<String, List<KuaiDi100Express>> map = KuaiDi100ReaderExpressJson.getAll();
		System.out.println(map);
		
		request.setAttribute("map", map);
		
		/*for (String aa : map.keySet()) {
			System.out.println(aa);
			for (Express express : map.get(aa)) {
				System.out.println(express.getName());
			}
			System.out.println("----------------");
		}*/
		
		
		request.getRequestDispatcher("/WEB-INF/showExpress.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doGet(request, response);
	}

}
