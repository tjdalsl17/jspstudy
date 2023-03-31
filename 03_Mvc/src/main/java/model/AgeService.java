package model;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeService {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strBirthyear = request.getParameter("birthyear");
		int birthyear = Integer.parseInt(strBirthyear);
		int nowyear = Calendar.getInstance().get(Calendar.YEAR);
		
		request.setAttribute("age", nowyear - birthyear);
		return "view/output.jsp";
		
	}

}
