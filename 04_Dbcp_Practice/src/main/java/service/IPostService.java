package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IPostService {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
