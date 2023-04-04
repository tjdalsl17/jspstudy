package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IPostService;
import service.PostListService;
import service.PostSaveService;


@WebServlet("*.post")	// (매핑값 임의로 지정) /list.post 	/detail.post 	/save.post	 /change.post	/edit.post	/delete.post
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청, 응답 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// urlMapping
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		// 서비스 타입 선언
		IPostService service = null;
		
		// forward 경로
		String path = null;
		
		// urlMapping에 따른 서비스 선택(생성)
		switch(urlMapping) {
		case "/list.post":
			service = new PostListService();
			break;
		case "/save.post":
			service = new PostSaveService();
			break;
		case "/write.post":
			path = "post/write.jsp";
			break;
		}
		
		// 선택된 서비스 실행
		if(service != null) {
			try {
				// redirect가 필요한 서비스(삽입,수정,삭제)는 서비스 내에서 직접 redirect하고(location.href를 이용) path에 null을 반환한다.
				path = service.execute(request, response);				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 이동할 경로(path)로 forward
		if(path != null) {
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
