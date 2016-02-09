package kr.netty.honeylink.api.service;

import java.io.IOException;

import kr.netty.honeylink.api.moel.Link;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class JsoupHtmlCrawlerService implements HtmlCrawlerServicec {

	private UrlValidator urlValidator;

	public JsoupHtmlCrawlerService() {
		urlValidator = new UrlValidator(new String[] { "http", "https" });
	}

	@Override
	public boolean isHttpUrl(String url) {
		return urlValidator.isValid(url);
	}

	@Override
	public Link extract(String url) {

		Link aLink = new Link(url);

		try {

			// UA가 없으면 진입을 허용하지 않는 페이지들이 있으므로 UA설정
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.97 Safari/537.36").get();

			aLink.setTitle(extractTitle(doc));
			aLink.setThumbnailUrl(extractThumUrl(doc));

		} catch (IOException e) {
			return null;
		}

		return aLink;
	}

	private String extractTitle(Document document) {

		// 1. 메타태그 og title에 값이 있으면 그 값을 사용
		Elements ogTitleElements = document.select("meta[property=og:title]");
		if (ogTitleElements.size() > 0) {
			return ogTitleElements.get(0).attr("content");
		}

		// 2. 타이틀 태그에 값을 사용
		Elements titleElements = document.select("title");
		if (titleElements.size() > 0) {
			return titleElements.get(0).text();
		}

		// 3. 첫번째 p태그의 값을 사용
		Elements pElements = document.select("p");
		if (pElements.size() > 0) {
			return pElements.get(0).text();
		}

		return "타이틀 없음";
	}

	private String extractThumUrl(Document document) {

		// 1. 메타태그 og title에 값이 있으면 그 값을 사용
		Elements ogImageElements = document.select("meta[property=og:image]");
		if (ogImageElements.size() > 0) {
			return ogImageElements.get(0).attr("content");
		}

		// 2. 타이틀 태그에 값을 사용
		Elements imgElements = document.select("img");
		if (imgElements.size() > 0) {
			return imgElements.get(0).attr("src");
		}

		return null;
	}

}
