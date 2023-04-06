package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BbsDAO;

public class BbsListService implements IBbsService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("bbsList", BbsDAO.getInstance().selectAllBbsList());
		return new ActionForward("bbs/list.jsp", false); // forward
	}

}
