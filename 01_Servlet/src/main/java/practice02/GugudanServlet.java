package practice02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanServlet")

public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터
		String strDan = request.getParameter("dan");
		String strNum = request.getParameter("num");
		String strResult = request.getParameter("result");
		
		// 공백 및 null 처리 후 숫자로 변환하기
		int dan = 0, num = 0, result = 0;
		if(strDan != null && strDan.isEmpty() == false) {
			dan = Integer.parseInt(strDan);
		}
		if(strNum != null && strNum.isEmpty() == false) {
			num = Integer.parseInt(strNum);
		}
		if(strResult != null && strResult.isEmpty() == false) {
			result = Integer.parseInt(strResult);
		}
		
		// 응답 타입
		response.setContentType("text/html; charset=UTF-8");
		
		// 출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 응답하기
		out.println("<script>");
		if(dan * num == result) {
			out.println("alert('정답입니다.')");
		} else {
			out.println("alert('오답입니다.')");
		}
		// out.println("history.back()");  이전 화면으로 이동하기
		// out.println("location.href='/01_Servlet/practice02/client1.html'");  // client1.html로 이동하기
		out.println("location.href='/01_Servlet/practice02/client2.html'");  // client2.html로 이동하기
		out.println("</script>");
		out.flush();
		out.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}