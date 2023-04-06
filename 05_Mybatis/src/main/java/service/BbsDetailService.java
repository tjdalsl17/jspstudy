package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.BbsDTO;
import repository.BbsDAO;

public class BbsDetailService implements IBbsService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) { // bbsNo값이 파라미터로 넘어옴
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("bbsNo")); // 전달 o
		int bbsNo = Integer.parseInt(opt.orElse("0")); // 전달 x
		
		BbsDTO bbs = BbsDAO.getInstance().selectBbsByNo(bbsNo);
		
		if(bbs == null) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('존재하지 않는 BBS입니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("bbs", bbs);
		return new ActionForward("bbs/detail.jsp", false);
	}

}
