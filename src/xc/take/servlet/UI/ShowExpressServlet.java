package xc.take.servlet.UI;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xc.take.util.Express;
import xc.take.util.ReaderExpressJson;

public class ShowExpressServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//ShowExpressServlet.class.getResourceAsStream("text2.json");
		
		
		Map<String, List<Express>> map = ReaderExpressJson.getAll();
		
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
