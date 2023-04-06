package model;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class MyAgeService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
			
			String strBirthyear = request.getParameter("birthyear");
			int birthyear = Integer.parseInt(strBirthyear);
			int nowyear = Calendar.getInstance().get(Calendar.YEAR);
			
			request.setAttribute("age", nowyear - birthyear);
			
			// 어디로 어떻게 갈 것인가?
			ActionForward actionForward = new ActionForward();
			actionForward.setPath("view/output.jsp");
			actionForward.setRedirect(false);  // forward
			return actionForward;
	}

}
