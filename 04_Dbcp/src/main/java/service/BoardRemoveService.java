package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDAO;

public class BoardRemoveService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			if(request.getMethod().equalsIgnoreCase("get")) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 요청입니다.')");
				out.println("histroy.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;	// 컨트롤러로 null값을 반환하면 컨트롤러는 이동(redirect 또는 forward)를 하지 않는다.
								// 서비스에서 직접 이동하는 경우에 이 방법을 사용한다.
				
				
				
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 1. 요청 파라미터
		Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
		int board_no = Integer.parseInt(opt.orElse("0"));
		
		// 2. BoardDAO의 deleteBoard 메소드 호출
		int removeResult = BoardDAO.getInstance().deleteBoard(board_no);
		System.out.println(removeResult == 1 ? "삭제성공" : "삭제실패");
		
		// 3. 어디로 and 어떻게 이동
		return new ActionForward(request.getContextPath() + "/getAllBoardList.do", true);
	}

}
