package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IMemberService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
