package scrapers;

import java.io.IOException;

import org.jsoup.nodes.Element;

public interface Scraper {

	public String getStringByClass(Element el, String className, int index) throws IOException;
	public String substringNum(String text, int startIndex, int endIndex) throws Exception;
	public String getLinkFromAHref(Element el, int index) throws IOException;
	public String getStringImageByClass(Element el, String className, int index) throws IOException;
	public String addTwoNumbersInString(String n, String m) throws Exception; 
	
	
}
