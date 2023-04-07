package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Member;
import repository.MemberDAO;

public class MemberAddService implements IMemberService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 요청 파라미터를 DB로 보낼 Member 객체로 만들기
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setGender(request.getParameter("gender"));
		member.setAddress(request.getParameter("address"));
		
		// execute() 메소드에 throws Exception 처리가 되어 있어서 try - catch를 할 필요가 없으나
		// 회원 추가를 실패할 경우 ajax() 메소드로 실패 메시지를 전달하기 위해서 try-catch를 사용한다.
		/*
		  	try {
		  		
		  		응답 -> ajax()의 success
		  	
		  	} catch(Exception e) {
		  	
		  		응답 -> ajax()의 error
		  	}
		 */
		
		try {
			// Member member 객체 DB에 추가
			int insertResult = MemberDAO.getInstance().insertMember(member);
			
			// 응답 데이터 형식 (JSON)
			response.setContentType("application/json; charset=UTF-8");
			
			// 응답 데이터 만들기
			/*
			 {
			 	"insertResult" : 1
			 */
			JSONObject obj = new JSONObject();
			obj.put("insertResult", insertResult);
			
			// 응답 (try문의 응답이므로 ajax의 success로 전달된다.)
			PrintWriter out = response.getWriter();
			out.println(obj.toString());
			out.flush();
			out.close();

		} catch(Exception e) {
			
			// 응답 데이터 형식 (일반 텍스트) -> 예외 사유를 텍스트로 전달하기 위해서
			response.setContentType("text/plain; charset=UTF-8");
			
			// 응답 코드 만들기
			response.setStatus(500);
			
			// 응답 데이터 만들기
			String msg = "신규 등록에 실패했습니다.\n입력 데이터를 확인하세요.";
			
			// 응답 (catch문의 응답이므로 ajax의 error로 전달된다.)
			PrintWriter out = response.getWriter();
			out.println(msg);
			out.flush();
			out.close();
		}
	}
}
