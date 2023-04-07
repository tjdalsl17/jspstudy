package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberRemoveService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// 요청 파라미터
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
				
		// DB에서 memberNo값을 가진 회원 정보 받아오기
		int removeResult = MemberDAO.getInstance().deleteMember(memberNo);
				
		// 응답 데이터 형식 (JSON)
		response.setContentType("application/json; charset=UTF-8");
		
		JSONObject obj = new JSONObject();
		obj.put("removeResult", removeResult);
		
		// 응답
		PrintWriter out = response.getWriter();
		out.println(obj.toString());
		out.flush();
		out.close();
	}
}
