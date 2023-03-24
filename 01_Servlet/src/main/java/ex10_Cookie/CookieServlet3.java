package ex10_Cookie;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieServlet3")
public class CookieServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 전체 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		
		// 전체 쿠키 확인하기
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println("쿠키이름 : " + cookie.getName() + ", 쿠키값 : " + URLDecoder.decode(cookie.getValue(), "UTF-8"));
			}
		}
			
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
