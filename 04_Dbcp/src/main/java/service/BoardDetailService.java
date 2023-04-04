package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardDetailService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
				// 1. 요청 파라미터
				Optional<String> opt = Optional.ofNullable(request.getParameter("board_no"));
				int board_no = Integer.parseInt(opt.orElse("0"));
				
				// 2. BoardDAO의 selectBoardByNo 메소드를 호출
				BoardDTO board = BoardDAO.getInstance().selectBoardByNo(board_no);
				
				// 3. 존재하지 않는 게시글인 경우 응답 처리
				try {
					
					if(board == null){
						PrintWriter out = response.getWriter();
						out.println("<script>");
						out.println("alert('존재하지 않는 게시글입니다.')");
						out.println("history.back()");
						out.println("</script>");
						out.flush();
						out.close();
						return null;  // 컨트롤러로 null값을 반환하면 컨트롤러는 이동(redirect 또는 forward)을 하지 않는다.
						              // 서비스에서 직접 이동하는 경우에 이 방법을 사용한다.
					}
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				// 4. DB에서 가져온 게시글(BoardDTO board)을 request에 저장(상세보기화면(board/detail.jsp)으로 forward(전달)하기 위해서)
				request.setAttribute("board", board);
				
				// 5. 어디로 and 어떻게 이동
				return new ActionForward("board/detail.jsp", false);
				
			}

}
