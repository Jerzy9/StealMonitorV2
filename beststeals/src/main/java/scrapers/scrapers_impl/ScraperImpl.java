package scrapers.scrapers_impl;

import java.io.IOException;

import org.apache.tomcat.InstanceManager;
import org.jsoup.nodes.Element;

import scrapers.Scraper;

public class ScraperImpl implements Scraper{

	public String getStringByClass(Element el, String className, int index) throws IOException {
		String str;
		//ten blok try/catch jest do usuniêcia, jak tylko zaczniemy korzystañ z nowego systemu
		try {
			str = el.getElementsByClass(className).get(index).text();
		} catch (Exception e) {
			System.out.println("null in " + className);
			str = "null";
		}
		return str;
	}
	
	public String getLinkFromAHref(Element el, int index) throws IOException {
		String relHref;
		Element link = el.select("a").get(index);
		relHref = link.attr("href");
		return relHref;
	}
	
	public String getStringImageByClass(Element el, String className, int index) throws IOException {
		Element imgElement = el.getElementsByClass(className).get(index);
		String imgString = imgElement.absUrl("src");
		return imgString;
	}
	
	public String getImageStringByTag(Element el, int index) throws IOException {
		String str;
		Element image = el.getElementsByTag("img").get(index);
    	str = image.absUrl("src");
		return str;
	}
	
	public String addTwoNumbersInString(String n, String m) throws Exception{
		int i = Integer.parseInt(n);
		int j = Integer.parseInt(m);
		int k = i+j;
		String sum= ""+k;
		return sum;
	}
	
	public String substringNum(String text, int startIndex, int endIndex) throws Exception {
    	return text.substring(startIndex, endIndex);
    }
	
}
