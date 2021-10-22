package com.littleCarrest.api.bigData;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.littleCarrest.common.code.Config;
import com.littleCarrest.common.http.HttpConnector;

public class RegionBigdataApi {

	public void getRegionBigdata() {
		
		String uri = "http://api.visitkorea.or.kr/openapi/service/rest/DataLabService/locgoRegnVisitrDDList";
		String queryStirng = "?ServiceKey" + Config.SERVICE_KEY.DESC 
				+ "&numOfRows=10"
				+ "&pageNo=1"
				+ "&MobileOS=ETC"
				+ "&MobileApp=littleCarrest"
				+ "&startYmd=20211013"
				+ "&endYmd=20211013"
				+ "&_type=json";
		
		HttpConnector conn = new HttpConnector();
		JsonObject datas = conn.getAsJson(uri + queryStirng).getAsJsonObject();

		for (JsonElement e : datas.getAsJsonArray("item")) {
			String signguNm = e.getAsJsonObject().get("signguNm").getAsString();//시군구명
			String day = e.getAsJsonObject().get("daywkDivNm").getAsString();	//요일
			String tourist = e.getAsJsonObject().get("touDivCd").getAsString();	//관광객 분류
			String touNum = e.getAsJsonObject().get("touNum").getAsString();	//관광객수
			String baseYmd = e.getAsJsonObject().get("baseYmd").getAsString();	//기준연원일
			
		}	
	}
	
	public static void main(String[] args) {
		new RegionBigdataApi().getRegionBigdata();
		
	}
	
	
}
