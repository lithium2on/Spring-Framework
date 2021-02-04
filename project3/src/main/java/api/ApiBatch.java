/* https://uriu.tistory.com/233 참고하여 작성 */

package api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import api.DataDAO;
import api.DataVO;

public class ApiBatch {

	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nList.item(0);
		if (nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException,
			NamingException, ClassNotFoundException, SQLException {

//       List<GovDataDTO> list = new ArrayList<GovDataDTO>(); // "&pageNo=100&numOfRows=100" 갯수와 로우 100까지는 테스트 10000은 404에러 
		String str = ""; // return을 위해서
		String parsingUrl = "";// Parsing할 URL

	
		

		StringBuilder urlBuilder = new StringBuilder(
				"http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcSilvTrade"); /*
																															 * URL
																															 */
		urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8")
				+ "=J3XtXoWcwufNoUTH%2FrbsHf%2BnusorrZ2SpTACQpunz%2BMJRqVq52gdUOUVcOs%2BkAcQtGm5vP9IYfsm8GgLMhia3Q%3D%3D"); /*
																															 * Service
																															 * Key
																															 */
		urlBuilder.append(
				"&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode("41171", "UTF-8")); /* 각 지역별 코드 */
		urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
				+ URLEncoder.encode("202101", "UTF-8")); /* 월 단위 신고자료 */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());

		parsingUrl = url.toString();
		System.out.println(parsingUrl);

		// 페이지에 접근해줄 Document객체 생성
		// doc객체를 통해 파싱할 url의 요소를 읽어들인다.
		// doc.getDocumentElement().getNodeName()을 출력하면 위 xml의 최상위 태그를 가져온다.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(parsingUrl);

		// root tag
		doc.getDocumentElement().normalize();
		System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result //파싱할 데이터
													
		DataDAO dao22=DataDAO.getInstance();
		dao22.deleteBoard();
		// tag에 접근하는데 리스트 수 확인
		NodeList nList = doc.getElementsByTagName("item");
		System.out.println("파싱할 리스트 수 : " + nList.getLength());// 파링할 리스트 수
		for (int i = 0; i < nList.getLength(); i++) {
			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				DataVO bVo = new DataVO();

//       bVo.setApartmentname(getTagValue("아파트", eElement));

				String APARTMENTNAME = getTagValue("단지", eElement);
				String AMOUNT = getTagValue("거래금액", eElement);
//       String OWNERSHIP = getTagValue("아파트", eElement);
				String DEALYEAR = getTagValue("년", eElement);
				String DEALMONTH = getTagValue("월", eElement);
				String DEALDAY = getTagValue("일", eElement);
				String DONG = getTagValue("법정동", eElement);
				String SIGUNGU = getTagValue("시군구", eElement);
				String AREAUSE = getTagValue("전용면적", eElement);
				String JIBUN = getTagValue("지번", eElement);
				String REGIONALCODE = getTagValue("지역코드", eElement);
				String FLOOR = getTagValue("층", eElement);

				DataDAO bDao = DataDAO.getInstance();

				bDao.write(APARTMENTNAME, AMOUNT, DEALYEAR, DEALMONTH, DEALDAY, DONG, SIGUNGU, AREAUSE, JIBUN,
						REGIONALCODE, FLOOR);

			}
		}
		return;
	}
}