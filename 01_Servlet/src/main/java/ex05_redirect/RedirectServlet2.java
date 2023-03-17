package ex05_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RedirectServlet2")
public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 두 번째 요청: 01_Servlet/RedirectServlet2
		// 리다이렉트 이후(두 번째 요청) 파라미터 확인
		String model = request.getParameter("model");	// 두 번째 요청에 파라미터 model이 없기 때문에 null 값이 저장된다.
		System.out.println("RedirectServlet2: " + model);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
