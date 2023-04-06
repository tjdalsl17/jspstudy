package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BbsAddService;
import service.BbsDetailService;
import service.BbsEditService;
import service.BbsListService;
import service.BbsModifyService;
import service.BbsRemoveService;
import service.IBbsService;

@WebServlet("*.do")		/*	/list.do 	/detail.do	/write.do 	/add.do		/edit.do 	/modify.do 	/remove.do 	*/
public class BbsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		IBbsService service = null;
		ActionForward af = null;
		
		switch(urlMapping) {
		case "/list.do": // index.jsp에서 요청하면 BbsListService 실행
			service = new BbsListService();
			break;
		case "/detail.do":
			service = new BbsDetailService();
			break;
		case "/write.do":
			af = new ActionForward("bbs/write.jsp", false); // 단순 jsp 이동 ->forward (삽입, 수정, 삭제일 경우빼고)
			break;
		case "/add.do":
			service = new BbsAddService();	
			break;
		case "/edit.do":
			service = new BbsEditService();
			break;
		case "/modify.do":
			service = new BbsModifyService();
			break;
		case "/remove.do":
			service = new BbsRemoveService();
			break;
		}
		
		if(service != null) {
			af = service.execute(request, response);
		}
		
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getPath());
			} else {
				request.getRequestDispatcher(af.getPath()).forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
