package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.BoardAddService;
import service.BoardDetailService;
import service.BoardListService;
import service.BoardModifyService;
import service.BoardRemoveService;
import service.IBoardService;


@WebServlet("*.do")	// getAllBoardList.do 		getBoardByNo.do		writeBoard.do 	addBoard.do		modifyBoard.do		removeBoard.do
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청과 응답의 인코딩
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// URLMapping 확인
		String requestURI = request.getRequestURI();						/* 		/04_Dbcp/getAllBoardList.do */
		String contextPath = request.getContextPath();						/*		/04_Dbcp					*/
		String urlMapping = requestURI.substring(contextPath.length());		/*		/getAllBoardList.do			*/
		
		// 모든 서비스의 공통 타입 선언
		IBoardService service = null;
		
		// ActionForward 선언
		ActionForward af = null;
		
		// URLMapping에 따른 서비스 생성
		switch(urlMapping) {
		case "/getAllBoardList.do":
			service = new BoardListService();
			break;
		case "/getBoardByNo.do":
			service = new BoardDetailService();
			break;
		case "/addBoard.do":
			service = new BoardAddService();
			break;
		case "/modifyBoard.do":
			service = new BoardModifyService();
			break;
		case "/removeBoard.do":
			service = new BoardRemoveService();
			break;
		case "/writeBoard.do":
			af = new ActionForward("board/write.jsp", false);	// board 폴더 아래 write.jsp로 forward한다. (단순 이동의 경우 forward한다.)
		}
		
		// 서비스 실행
		if(service != null) {
			af = service.execute(request, response);	// 해당 서비스 실행(af에 저장)
		} 
		
		// 응답view로 이동
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
