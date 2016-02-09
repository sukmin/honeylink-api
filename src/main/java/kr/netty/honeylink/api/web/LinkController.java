package kr.netty.honeylink.api.web;

import java.util.Date;
import java.util.List;

import kr.netty.honeylink.api.moel.CommonResult;
import kr.netty.honeylink.api.moel.Link;
import kr.netty.honeylink.api.moel.LinkInfo;
import kr.netty.honeylink.api.service.LinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {
	
	private static final CommonResult nullResult = new CommonResult();
	
	@Autowired
	private LinkService linkService;

	@RequestMapping(value="/links",method={RequestMethod.GET})
	public List<Link> getLinks(){
		return linkService.findAll();
	}
	
	@RequestMapping(value="/links",method={RequestMethod.POST})
	public CommonResult postLinks(String url){
		Link aLink = new Link(url);
		return new CommonResult(linkService.putLink(aLink));
	}
	
	@RequestMapping(value="/links/count",method={RequestMethod.POST})
	public CommonResult putLinksCount(Long sequence){
		linkService.plugCount(sequence);
		return LinkController.nullResult;
	}
	
}
