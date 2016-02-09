package kr.netty.honeylink.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.netty.honeylink.api.moel.Link;
import kr.netty.honeylink.api.moel.LinkInfo;
import kr.netty.honeylink.api.repository.LinkRepository;

@Service
public class DefaultLinkService implements LinkService {
	
	@Autowired
	@Qualifier("jsoupHtmlCrawlerService")
	private HtmlCrawlerServicec htmlCrawlerServicec;
	
	@Autowired
	private LinkRepository linkRepository;

	@Override
	public List<Link> findAll() {
		return linkRepository.findAll();
	}

	@Override
	public Result putLink(Link link) {
		return null;
	}

	@Override
	public boolean plugCount(Long sequence) {
		return linkRepository.updatePlusCount(sequence) == 1;
	}

}
