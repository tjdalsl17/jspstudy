package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BoardDTO;
import repository.BoardDAO;

public class BoardListService implements IBoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 1. BoardDAO 객체 준비
		BoardDAO dao = BoardDAO.getInstance();
		
		// 2. BoardDAO의 selectBoardList 메소드 호출
		List<BoardDTO> boardList = dao.selectBoardList();
		
		// 3. DB로부터 가져온 게시글 목록 boardList를 request에 저장 (forward 하기 위해서)
		request.setAttribute("boardList", boardList);
		request.setAttribute("boardListCount", boardList.size());
		
		// 4. 어디로 and 어떻게 이동
		ActionForward af = new ActionForward("board/list.jsp", false);	// board 폴더 아래 list.jsp로 forward (request 전달)하시오.
		return af;
		
		
		
	}

}
