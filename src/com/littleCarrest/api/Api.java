package com.littleCarrest.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.littleCarrest.seach.model.dto.CampingSearch;
import com.littleCarrest.seach.service.SearchService;

public class Api {

	public void api() throws XmlPullParserException, IOException{
		CampingSearch camping = new CampingSearch();
		SearchService searchservice = new SearchService();
		
		String key = "	vb7VRvR6GWpXJT1EaIIcYMLIE2wH%2FSLTxeJLj2OZ%2BezJUNWB20DGIYmMKJWFy56abCDff5P21JYKLDslp%2FIKLg%3D%3D";
		int pageNum = 1;
		
		for(pageNum = 1; pageNum < 275; pageNum++) {
			String urlCode = "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList"
					+ "?ServiceKey=" + key + "&pageNo=" + pageNum + "&numOfRows=10&MobileOS=ETC&MobileApp=LittleCarrest";
			
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
//	                    	if(xpp.getText()!=null) {
//	                    		line_intro = xpp.getText();
//	                    	}else {
//	                    		line_intro = "null";
//	                    	}
	                    }else if(tag.equals("intro")){
	                    	intro = xpp.getText();
//	                    	if(xpp.getText()!=null) {
//	                    		intro = xpp.getText();
//	                    	}else {
//	                    		intro = "null";
//	                    	}
//	                        intro.replaceAll("&apos;", "");
	                    }else if(tag.equals("manageSttus")){
	                    	status = xpp.getText();
	                    }else if(tag.equals("addr1")){
	                    	addr = xpp.getText();
	                    }else if(tag.equals("addr2")){
	                    	addr_spe = xpp.getText();
	                    }else if(tag.equals("mapX")){
	                    	mapx = xpp.getText();
	                    }else if(tag.equals("mapY")){
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
                      		
                      	  camping.setCpIdx(cp_idx);
                          camping.setCpName(cp_name);
                          camping.setLineIntro(line_intro);
                          camping.setIntro(intro);
                          camping.setStatus(status);
                          camping.setAddr(addr);
                          camping.setAddrSpe(addr_spe);
                          camping.setMapx(mapx);
                          camping.setMapy(mapy);
                          camping.setTel(tel);
                          camping.setHomepage(homepage);
                          camping.setLocation(location);

                          System.out.println(camping);
                          System.out.println("============================================================================");
                                                     
                          searchservice.insertCamping(camping);
                      } 
                  }
                  event_type = xpp.next();
              } // while 문
          } // 전체 page for 문
     }
     
      public static void main(String[] args) throws IOException, XmlPullParserException {
         
         Api api = new Api();
         api.api();
      }
      
		
		
	}

