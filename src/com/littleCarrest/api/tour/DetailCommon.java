package com.littleCarrest.api.tour;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.littleCarrest.toursite.model.dto.ToursiteSub;
import com.littleCarrest.toursite.model.service.ToursiteService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;

public class DetailCommon {
	
    public static void main(String[] args) throws IOException, Exception {
    	
		ToursiteSub toursite = new ToursiteSub();
		ToursiteService toursiteService = new ToursiteService();	
		List<String> contentIdList = toursiteService.selectContentId();
		
		
        StringBuilder urlBuilder = new StringBuilder("http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=st2qPe5R3zFH%2B5e0zSdhNE2RIu6nT94woDEgFmQUCLbMArl9ZJgEhrToJJ3FwJbhxvFuJf%2FeZ%2Ba270VCMjxcZA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재 페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("MobileOS","UTF-8") + "=" + URLEncoder.encode("ETC", "UTF-8")); /*IOS(아이폰),AND(안드로이드),WIN(원도우폰),ETC*/
        urlBuilder.append("&" + URLEncoder.encode("MobileApp","UTF-8") + "=" + URLEncoder.encode("AppTest", "UTF-8")); /*서비스명=어플명*/
        urlBuilder.append("&" + URLEncoder.encode("contentId","UTF-8") + "=" + URLEncoder.encode("126501", "UTF-8")); /*콘텐츠ID 126508 경복궁*/
        urlBuilder.append("&" + URLEncoder.encode("contentTypeId","UTF-8") + "=" + URLEncoder.encode("12", "UTF-8")); /*관광타입(관광지, 숙박 등) ID*/
        urlBuilder.append("&" + URLEncoder.encode("defaultYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*기본정보 조회여부*/
        urlBuilder.append("&" + URLEncoder.encode("overviewYN","UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*콘텐츠 개요 조회여부*/
        
        URL url = new URL(urlBuilder.toString());
        	// xmlParser test
     		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
     		factory.setNamespaceAware(true);
     		XmlPullParser xpp = factory.newPullParser();
     		BufferedInputStream bs = new BufferedInputStream(url.openStream());
     		xpp.setInput(bs, "utf-8");
     		     		
     		int event_type = xpp.getEventType();
     		
     		String tag = null;
     		String contentId = null;
     		String overview= null;
     		String homepage= null;
     		
     		while(event_type != XmlPullParser.END_DOCUMENT) {
     			if(event_type == XmlPullParser.START_TAG) {
     				tag = xpp.getName();
     			}else if(event_type == XmlPullParser.TEXT) {
     					if(tag.equals("contentid")){
     						contentId = xpp.getText();
                         }else if(tag.equals("homepage")){
                        	 homepage = xpp.getText();
                         }else if(tag.equals("overview")){
                         	overview = xpp.getText();
                         }
                 }else if (event_type == XmlPullParser.END_TAG) {
     				tag = xpp.getName();
                     
                     if (tag.equals("item")) {
                       toursite.setContentId(contentId);
                       toursite.setOverview(overview);
                       toursite.setHomepage(homepage);

                       System.out.println(toursite);
                       System.out.println("============================================================================");
                                                      
                       //toursiteService.insertToursiteSub(toursite);
                       } 
                 }
                   event_type = xpp.next();
            } // while 문
    }
}
