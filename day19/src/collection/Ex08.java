package collection;

import java.io.IOException;
import java.util.HashMap;

public class Ex08 {
	public static void main(String[] args) throws Exception {
		String url = "https://search.naver.com/search.naver";
		url += "?";
		
		HashMap<String, String> param = new HashMap<>();
		param.put("query", "아이유 이종석");			// 본인이 검색하고 싶은 검색어
		param.put("where", "image");	// 비워두면 통합검색, news, image 등 카테고리
		
		param.put("query", param.get("query").replace(" ", "%20"));	// 띄어쓰기 가능 (ex. 부산 날씨)
		
		for(String key : param.keySet()) {
			String value = param.get(key);
			url += key + "=" + value + "&";
		}
		Runtime rt = Runtime.getRuntime();
		String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
		rt.exec(chromePath + " " + url);
		
		
	}
}
