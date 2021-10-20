package com.littleCarrest.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.littleCarrest.toursite.model.dto.Toursite;
import com.littleCarrest.toursite.model.service.ToursiteService;

public class ToursiteApi {

	public void api() throws XmlPullParserException, IOException{
		Toursite toursite = new Toursite();
		ToursiteService toursiteService = new ToursiteService();
		
		String key = "	vb7VRvR6GWpXJT1EaIIcYMLIE2wH%2FSLTxeJLj2OZ%2BezJUNWB20DGIYmMKJWFy56abCDff5P21JYKLDslp%2FIKLg%3D%3D";
		int pageNum = 1;
		
		for(pageNum = 1; pageNum < 3; pageNum++) {
			String urlCode = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList"
					+ "?ServiceKey=" + key + "&pageNo=" + pageNum + "&numOfRows=10"
					+ "&MobileApp=LittleCarrest&MobileOS=ETC&arrange=A&contentTypeId=12&listYN=Y";
			
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
			String toursite_idx = null;
			String addr= null;
			String addr_spe = null;
			String name = null;
			String tel= null;
			String image = null;
			String mapx = null;
			String mapy = null;
			String booktour = null;
			String typeid = null;
			
			while(event_type != XmlPullParser.END_DOCUMENT) {
				if(event_type == XmlPullParser.START_TAG) {
					tag = xpp.getName();
				}else if(event_type == XmlPullParser.TEXT) {
						if(tag.equals("contentid")){
							toursite_idx = xpp.getText();
	                    }else if(tag.equals("addr1")){
	                    	addr = xpp.getText();
	                    }else if(tag.equals("addr2")){
	                    	addr_spe = xpp.getText();
	                    }else if(tag.equals("title")){
	                    	name = xpp.getText();
	                    }else if(tag.equals("tel")){
	                    	tel = xpp.getText();
	                    }else if(tag.equals("firstimage")){
	                    	image = xpp.getText();
	                    }else if(tag.equals("mapx")){
	                    	mapx = xpp.getText();
	                    }else if(tag.equals("mapy")){
	                    	mapy = xpp.getText();
	                    }else if(tag.equals("booktour")){
	                    	booktour = xpp.getText();
	                    }else if(tag.equals("contentid")){
	                    	typeid = xpp.getText();
	                    }else if (event_type == XmlPullParser.END_TAG) {
					tag = xpp.getName();
                    
                    if (tag.equals("item")) {
                      System.out.println("pageNum : "+ pageNum + "\n");
                      		
                      toursite.setToursiteIdx(toursite_idx);
                      toursite.setAddr(addr);
                      toursite.setAddrSpe(addr_spe);
                      toursite.setName(name);
                      toursite.setTel(tel);
                      toursite.setImage(image);
                      toursite.setMapx(mapx);
                      toursite.setMapy(mapy);
                      toursite.setBooktour(booktour);
                      toursite.setTypeid(typeid);

                      System.out.println(toursite);
                      System.out.println("============================================================================");
                                                     
                  toursiteService.insertToursite(toursite);
                      } 
                  }
                  event_type = xpp.next();
              } // while 문
			} // 전체 page for 문
     }
	}
     
      public static void main(String[] args) throws IOException, XmlPullParserException {
         
         ToursiteApi api = new ToursiteApi();
         api.api();
      }
      
		
		
	}

