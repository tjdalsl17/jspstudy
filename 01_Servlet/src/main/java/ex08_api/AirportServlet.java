package ex08_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AirportServlet")
public class AirportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 요청 파라미터
		String schDate = request.getParameter("schDate");
		String schDeptCityCode = request.getParameter("schDeptCityCode");
		String schArrvCityCode = request.getParameter("schArrvCityCode");
		
		// 서비스키(디코딩)
		String serviceKey = "DYL8tbccBRtrNFiAqGKYBrQhg6wGylfT9Wrego1m0wpWCnxqXO+RaK70l46I87yLFAfGh2rhJAurUn5eR8VATA==";
		
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList"; // 서비스 URL
		apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
		apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8");
		apiURL += "&schDate=" + URLEncoder.encode(schDate, "UTF-8");
		apiURL += "&schDeptCityCode=" + URLEncoder.encode(schDeptCityCode, "UTF-8");
		apiURL += "&schArrvCityCode=" + URLEncoder.encode(schArrvCityCode, "UTF-8");
		
		// URL
		URL url = new URL(apiURL);
		
		// HttpURLConnection
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		// 요청 메서드
		con.setRequestMethod("GET");
		
		// Content-Type
		con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
		
		// 입력 스트림 생성
		BufferedReader reader = null;
		if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		// API 응답 결과 받아오기
		StringBuilder sb = new StringBuilder();
		String line = null;
		while((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		
		// 사용한 자원 반납
		reader.close();
		con.disconnect();
		
		// API 응답 결과를 ajax으로 보내기
		response.setContentType("application/xml; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
