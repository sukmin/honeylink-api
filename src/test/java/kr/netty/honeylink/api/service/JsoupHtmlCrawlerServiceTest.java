package kr.netty.honeylink.api.service;

import static org.junit.Assert.*;
import kr.netty.honeylink.api.moel.Link;

import org.junit.Test;

public class JsoupHtmlCrawlerServiceTest {

	@Test
	public void isHttpUrl_HTTP프로토콜의_경우() throws Exception {
		// given
		JsoupHtmlCrawlerService service = new JsoupHtmlCrawlerService();
		String aUrl = "http://www.naver.com";

		// when
		boolean actual = service.isHttpUrl(aUrl);

		// then
		assertTrue(actual);
	}

	@Test
	public void isHttpUrl_HTTPS프로토콜의_경우() throws Exception {
		// given
		JsoupHtmlCrawlerService service = new JsoupHtmlCrawlerService();
		String aUrl = "https://pay.naver.com";

		// when
		boolean actual = service.isHttpUrl(aUrl);

		// then
		assertTrue(actual);
	}

	@Test
	public void isHttpUrl_잘못된_주소의_경우() throws Exception {
		// given
		JsoupHtmlCrawlerService service = new JsoupHtmlCrawlerService();
		String aUrl = "http://pay.http://naver.com";

		// when
		boolean actual = service.isHttpUrl(aUrl);

		// then
		assertFalse(actual);
	}

	@Test
	public void isHttpUrl_FTP스킴의_경우() throws Exception {
		// given
		JsoupHtmlCrawlerService service = new JsoupHtmlCrawlerService();
		String aUrl = "ftp://naver.com";

		// when
		boolean actual = service.isHttpUrl(aUrl);

		// then
		assertFalse(actual);
	}
	
	@Test
	public void extract_추출테스트() throws Exception {
		// given
		JsoupHtmlCrawlerService service = new JsoupHtmlCrawlerService();
		String aUrl = "http://campaign.naver.com/webtoon";
		
		// when
		Link aLink = service.extract(aUrl);
		
		// then
		System.out.println(aLink.getTitle());
		System.out.println(aLink.getThumbnailUrl());
	}

}
