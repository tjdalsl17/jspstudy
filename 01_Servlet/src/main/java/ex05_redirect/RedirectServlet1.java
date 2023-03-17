package ex05_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RedirectServlet1")
public class RedirectServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 리다이렉트 이전(첫 번째 요청)의 파라미터 확인
		// 첫 번째 요청 : 01_Servlet/RedirectServlet1?model=TV
		String model = request.getParameter("model");
		System.out.println("RedirectServlet1 : " + model);
		
		// redirect를 이용해서 다른 서블릿(다른 서버 경로)으로 이동하기
		response.sendRedirect("/01_Servlet/RedirectServlet2");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
