package ex06_forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ForwardServlet1")
public class ForwardServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 포워드 이전(첫 번째 요청) 파라미터 확인
		String model = request.getParameter("model");
		System.out.println("ForwardServlet : " + model);
		
		// 포워드(전달)
		request.getRequestDispatcher("/ForwardServlet2").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
