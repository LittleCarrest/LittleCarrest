package com.littleCarrest.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.littleCarrest.festival.model.dto.FestivalDto;
import com.littleCarrest.festival.model.service.FestivalService;

public class FestivalApi {

	public void api() throws XmlPullParserException, IOException{
		FestivalDto event = new FestivalDto();
		FestivalService festivalService = new FestivalService();
		
		String key = "	vb7VRvR6GWpXJT1EaIIcYMLIE2wH%2FSLTxeJLj2OZ%2BezJUNWB20DGIYmMKJWFy56abCDff5P21JYKLDslp%2FIKLg%3D%3D";
		int pageNum = 1;
		
		for(pageNum = 1; pageNum < 10; pageNum++) {
			String urlCode = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival"
					+ "?ServiceKey=" + key + "&numOfRows=10"+ "&pageNo=" + pageNum 
					+ "&MobileOS=ETC&MobileApp=LittleCarrest&arrange=A&listYN=Y";
			
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
			String festival_idx = null;
			String name= null;
			String startdate = null;
			String enddate = null;
			String tel= null;
			String mapx = null;
			String mapy = null;
			String image = null;
			String address = null;
			
			while(event_type != XmlPullParser.END_DOCUMENT) {
				if(event_type == XmlPullParser.START_TAG) {
					tag = xpp.getName();
				}else if(event_type == XmlPullParser.TEXT) {
						if(tag.equals("contentid")){
							festival_idx = xpp.getText();
	                    }else if(tag.equals("title")){
	                    	name = xpp.getText();
	                    }else if(tag.equals("eventstartdate")){
	                    	startdate = xpp.getText();
	                    }else if(tag.equals("eventenddate")){
	                    	enddate = xpp.getText();
	                    }else if(tag.equals("tel")){
	                    	tel = xpp.getText();
	                    }else if(tag.equals("mapx")){
	                    	mapx = xpp.getText();
	                    }else if(tag.equals("mapy")){
	                    	mapy = xpp.getText();
	                    }else if(tag.equals("firstimage")){
	                    	image = xpp.getText();
	                    }else if(tag.equals("addr1")){
	                    	address = xpp.getText();
	                    }
						}else if (event_type == XmlPullParser.END_TAG) {
					tag = xpp.getName();
                    
                    
                    if (tag.equals("item")) {
                      System.out.println("pageNum : "+ pageNum + "\n");
                      		
                      event.setFestivalIdx(festival_idx);
                      event.setName(name);
                      event.setStartDate(startdate);
                      event.setEndDate(enddate);
                      event.setTel(tel);
                      event.setMapx(mapx);
                      event.setMapy(mapy);
                      event.setImage(image);
                      event.setAddress(address);

                      System.out.println(event);
                      System.out.println("============================================================================");
                                                     
                      festivalService.insertFestival(event);
                      } 
                  }
                  event_type = xpp.next();
              } // while 문
          } // 전체 page for 문
     }
     
      public static void main(String[] args) throws IOException, XmlPullParserException {
         
         FestivalApi api = new FestivalApi();
         api.api();
      }
      
		
		
	}

