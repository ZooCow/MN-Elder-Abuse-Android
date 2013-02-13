package com.application.mnelderdependentabuse.Classes;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class VideoXMLParser {

	public  VideoItem[] Parse(String InputXML) {
		// the list of items we are building
		final List<VideoItem> returnList = new ArrayList<VideoItem>(); 
		
	    try {
	    //create the SAX parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
	 
		//inner anonymous class that handles certain events
		DefaultHandler handler = new DefaultHandler() {
	 
		//flags to tell which XML node we come across
		boolean titleFlag = false;
		boolean urlFlag = false;
		//values to hold the node value
		String title;
		String url;
		
		
		//called when the stream hits the opening element
		public void startElement(String uri, String localName,String qName, 
	                Attributes attributes) throws SAXException {
			
			//set the flag based on what the node is
			if (qName.equalsIgnoreCase("TITLE")) {
				titleFlag = true;
			}
	 
			if (qName.equalsIgnoreCase("URL")) {
				urlFlag = true;
			}
	 
		}
	   //called when stream hits the end of an element
		public void endElement(String uri, String localName,
			String qName) throws SAXException {
			//When we hit the end of an element, we need both the holders filled so we can add to the list
			if(url != null && title != null)
			{
				returnList.add(new VideoItem(title,url));
				url = null;
				title = null;
				
			}
	 
		}
		//this is called when we hit the inside of a node
		public void characters(char ch[], int start, int length) throws SAXException {
			
			//fill the holders based on which flag was set then reset the flag
			if (titleFlag) {
				title = new String(ch, start, length);
				titleFlag = false;
			}
	 
			if (urlFlag) {
				url = new String(ch, start, length);
				urlFlag = false;
			}
		}
	 
		};
		

	     StringReader reader  = new StringReader(InputXML);
	     InputSource source = new InputSource(reader);
	     
	      saxParser.parse(source, handler);
	 
	     } catch (Exception e) {
	       e.printStackTrace();
	     }
	 
	    return  returnList.toArray(new VideoItem[returnList.size()]);
	   }
	
	
}
