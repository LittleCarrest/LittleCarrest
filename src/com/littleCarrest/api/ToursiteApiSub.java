package com.littleCarrest.api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.littleCarrest.toursite.model.dto.ToursiteSub;
import com.littleCarrest.toursite.model.service.ToursiteService;

public class ToursiteApiSub {

	//12관광지 처음 콘텐트번호 125266 마지막번호 2761294
	public void api() throws XmlPullParserException, IOException{
		ToursiteSub toursite = new ToursiteSub();
		ToursiteService toursiteService = new ToursiteService();
		
		String key = "vb7VRvR6GWpXJT1EaIIcYMLIE2wH%2FSLTxeJLj2OZ%2BezJUNWB20DGIYmMKJWFy56abCDff5P21JYKLDslp%2FIKLg%3D%3D";	
		int contentid = 297984;		
		
		String urlCode = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon"
				+ "?ServiceKey=" + key 
				+ "&MobileOS=ETC" 
				+ "&MobileApp=LittleCarrest" 
				+ "&contentId=" + contentid
				+ "&contentTypeId=12&defaultYN=Y&overviewYN=Y";
		
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
		String contentId = null;
		String overview= null;
		
		while(event_type != XmlPullParser.END_DOCUMENT) {
			if(event_type == XmlPullParser.START_TAG) {
				tag = xpp.getName();
			}else if(event_type == XmlPullParser.TEXT) {
					if(tag.equals("contentid")){
						contentId = xpp.getText();
                    }else if(tag.equals("overview")){
                    	overview = xpp.getText();
                    }
            }else if (event_type == XmlPullParser.END_TAG) {
				tag = xpp.getName();
                
                if (tag.equals("item")) {
//                    System.out.println("pageNum : "+ pageNum + "\n");
                  		
                  toursite.setContentId(contentId);
                  toursite.setOverview(overview);

                  System.out.println(toursite);
                  System.out.println("============================================================================");
                                                 
                  //toursiteService.insertToursiteSub(toursite);
                  } 
              }
              event_type = xpp.next();
          } // while 문
     };
     
      public static void main(String[] args) throws IOException, XmlPullParserException {
         
         ToursiteApiSub api = new ToursiteApiSub();
         api.api();
         
      };
      
		
		
	}

