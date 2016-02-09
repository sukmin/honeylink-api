package kr.netty.honeylink.api.service;

import kr.netty.honeylink.api.moel.Link;

public interface HtmlCrawlerServicec {
	
	public boolean isHttpUrl(String url);
	public Link extract(String url);

}
