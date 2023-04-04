package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.PostDAO;

public class PostListService implements IPostService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("posts", PostDAO.getInstance().getAllPosts());
		return "post/list.jsp";
	}

}
