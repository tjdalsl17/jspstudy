package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PostVO;
import repository.PostDAO;

public class PostSaveService implements IPostService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostVO post = PostVO.builder()
						.writer(request.getParameter("writer"))
						.title(request.getParameter("title"))
						.content(request.getParameter("content"))
						.ip(request.getRemoteAddr())
						.build();
		int saveResult = PostDAO.getInstance().savePost(post);
		PrintWriter out = response.getWriter();
		if(saveResult == 1) {
			out.println("<script>");
			out.println("alert('포스트가 작성되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/list.post'");  // 삽입 후 redirect와 동일한 코드
			out.println("</script>");
			out.flush();
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('포스트 작성이 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.flush();
			out.close();
		}
		return null;
	}

}
