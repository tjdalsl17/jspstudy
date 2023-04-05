package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.PostDAO;

public class PostDeleteService implements IPostService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("post_no"));
		int post_no = Integer.parseInt(opt.orElse("0"));
		
		int deleteResult = PostDAO.getInstance().deletePost(post_no);
		
		PrintWriter out = response.getWriter();
		if(deleteResult == 1) {
			out.println("<script>");
			out.println("alert('포스트가 삭제되었습니다.')");
			out.println("location.href='" + request.getContextPath()  + "/list.post'");
			out.println("</script>");
			out.flush();
			out.close();
		} else {
			out.println("<script>");
			out.println("alert('포스트가 삭제가 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.flush();
			out.close();
		}
		
		return null;
	}

}
