package ex09_binding;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/BindingServlet1")
public class BindingServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 서블릿은 받는 역할 -> request 사용
		  	1. stateless
		  		1) 상태 없음
		  		2) 웹 페이지간의 이동은 stateless한 이동이다.
		  		3) 현재 페이지에는 이전 페이지의 정보가 없다.
		  	
		  	2. binding
		  		1) 값을 저장할 수 있는 영역에 속성(Attribute)의 형태로 값을 저장하는 것을 말한다.
		  		2) 저장 영역은 서버가 제공한다.
		  		3) 3개 영역
		  			(1) HttpServletRequest	: 하나의 요청 내에서 값을 저장할 수 있다. (1회용)
		  			(2) HttpSession			: 웹 브라우저 종료 전까지 값을 저장할 수 있다.
		  			(3) ServletContext		: 컨텍스트(프로젝트, 애플리케이션) 종류 전까지 값을 저장할 수 있다.
		  		4) 속성(Attribute) 관련 메소드
		  			(1) getAttribute('속성')		: 값 가져오기 (캐스팅이 필요할 수 있다.)
		  			(2) setAttribute('속성', 값)	: 값 저장하기 (object 타입으로 저장한다.)
		  			(3) removeAttribute('속성')		: 값 제거하기
		  			
		  			
		 */
		
		// HttpServletRequest에 저장하기
		request.setAttribute("a", 100);
		
		// HttpSession에 저장하기
		HttpSession session = request.getSession();
		session.setAttribute("a", 200);
		
		// ServletContext에 저장하기
		ServletContext ctx = request.getServletContext();
		ctx.setAttribute("a", 300);
		
		// 페이지 이동하기
		
		// 1. HttpServletRequest의 전달이 없는 이동 : redirect, <a href="">, location.href=""
		// response.sendRedirect("/01_Servlet/BindingServlet2");
		
		// 2. HttpServletRequest의 전달이 있는 이동 : forward(내부이동)
		request.getRequestDispatcher("/BindingServlet2").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
