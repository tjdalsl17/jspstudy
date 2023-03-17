package ex03_parameter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String model = request.getParameter("model");
		String strPrice = request.getParameter("price");
		
		// <form> 태그에 포함된 입력 요소들이 name 속성을 가지고 있다면, null 처리를 할 수 없다. 빈 문자열("")로 처리해야 한다.
		int price = 0;
		if(strPrice.isEmpty() == false) {	// 빈 문자열 점검
			price = Integer.parseInt(strPrice);
		}
		
		response.getWriter().append("model: " + model).append(",price: " + price);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청이 들어옴");
		doGet(request, response);
	}

}
