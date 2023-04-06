package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BbsDAO;

public class BbsRemoveService implements IBbsService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getMethod().equalsIgnoreCase("get")) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 요청입니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String strBbsNo = request.getParameter("bbsNo");
		int bbsNo = Integer.parseInt(strBbsNo.isEmpty() ? "0" : strBbsNo);
		
		int deleteResult = BbsDAO.getInstance().deleteBbs(bbsNo);
		
		if(deleteResult == 1) {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('BBS가 삭제되었습니다.')");
				out.println("location.href='" + request.getContextPath() + "/list.do'");
				out.println("</script>");
				out.flush();
				out.close();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return new ActionForward(request.getContextPath() + "/list.do", true);
	}

}
