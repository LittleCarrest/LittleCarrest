package com.littleCarrest.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.littleCarrest.camping.model.dto.CampingSearch;
import com.littleCarrest.camping.model.service.CampingService;

public class CampingApi {

	public void api() throws XmlPullParserException, IOException{
		CampingSearch campingsearch = new CampingSearch();
		CampingService campingService = new CampingService();
		
		String key = "vb7VRvR6GWpXJT1EaIIcYMLIE2wH%2FSLTxeJLj2OZ%2BezJUNWB20DGIYmMKJWFy56abCDff5P21JYKLDslp%2FIKLg%3D%3D";
		int pageNum = 1;
		
		for(pageNum = 1; pageNum < 10; pageNum++) {
			String urlCode = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList"
					+ "?ServiceKey=" + key + "&pageNo=" + pageNum + "&numOfRows=10"
					+ "&MobileOS=ETC&MobileApp=LittleCarrest";
			
			StringBuilder urlBuilder = new StringBuilder(urlCode); //URL
			URL url = new URL(urlBuilder.toString());
			
			// xmlParser test
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			BufferedInputStream bs = new BufferedInputStream(url.openStream());
			xpp.setInput(bs, "utf-8");
			
			int event_type = xpp.getEventType();
			
			String tag = null;
			String cp_idx = null;
			String cp_name= null;
			String line_intro = null;
			String intro = null;
			String status= null;
			String addr = null;
			String addr_spe = null;
			String mapx = null;
			String mapy = null;
			String tel = null;
			String homepage = null;
			String location = null;
			
			while(event_type != XmlPullParser.END_DOCUMENT) {
				if(event_type == XmlPullParser.START_TAG) {
					tag = xpp.getName();
				}else if(event_type == XmlPullParser.TEXT) {
						if(tag.equals("contentId")){
							cp_idx = xpp.getText();
	                    }else if(tag.equals("facltNm")){
	                    	cp_name = xpp.getText();
	                    }else if(tag.equals("lineIntro")){
	                    	line_intro = xpp.getText();
	                    }else if(tag.equals("intro")){
	                    	intro = xpp.getText();
	                    }else if(tag.equals("manageSttus")){
	                    	status = xpp.getText();
	                    }else if(tag.equals("addr1")){
	                    	addr = xpp.getText();
	                    }else if(tag.equals("addr2")){
	                    	addr_spe = xpp.getText();
	                    }else if(tag.equals("mapx")){
	                    	mapx = xpp.getText();
	                    }else if(tag.equals("mapy")){
	                    	mapy = xpp.getText();
	                    }else if(tag.equals("tel")){
	                    	tel = xpp.getText();
	                    }else if(tag.equals("homepage")){
	                    	homepage = xpp.getText();
	                    }else if(tag.equals("lctCl")){
	                    	location = xpp.getText();
	                    }
	               }else if (event_type == XmlPullParser.END_TAG) {
					tag = xpp.getName();
                    
                    if (tag.equals("item")) {
                      System.out.println("pageNum : "+ pageNum + "\n");
                      		
                      campingsearch.setCpIdx(cp_idx);
                      campingsearch.setCpName(cp_name);
                      campingsearch.setLineIntro(line_intro);
                      campingsearch.setIntro(intro);
                      campingsearch.setStatus(status);
                      campingsearch.setAddr(addr);
                      campingsearch.setAddrSpe(addr_spe);
                      campingsearch.setMapx(mapx);
                      campingsearch.setMapy(mapy);
                      campingsearch.setTel(tel);
                      campingsearch.setHomepage(homepage);
                      campingsearch.setLocation(location);

                      System.out.println(campingsearch);
                      System.out.println("============================================================================");
                      
                  campingService.insertCamping(campingsearch);
                      } 
                  }
                  event_type = xpp.next();
              } // while 문
			} // 전체 page for 문
     }
	
     
      public static void main(String[] args) throws IOException, XmlPullParserException {
         
         CampingApi api = new CampingApi();
         api.api();
      }
      
		
		
	}

