package scrapers;

import java.io.IOException;

import org.jsoup.nodes.Element;

public class Scraper {

	public String getStringByClass(Element el, String className, int index) throws IOException {
		String str;
		try {
			str = el.getElementsByClass(className).get(index).text();
		} catch (Exception e) {
			System.out.println("null in " + className);
			str = "null";
		}
		return str;
	}
	
	public String substringNum(String text, int startIndex, int endIndex) throws IOException {
    	return text.substring(startIndex, endIndex);
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
	
	public String addTwoNumbersInString(String n, String m) {
		int i = Integer.parseInt(n);
		int j = Integer.parseInt(m);
		int k = i+j;
		String sum= ""+k;
		return sum;
	}
}
