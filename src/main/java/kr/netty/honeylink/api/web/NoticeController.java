package kr.netty.honeylink.api.web;

import kr.netty.honeylink.api.moel.Notice;
import kr.netty.honeylink.api.service.NoticeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/notice", method=RequestMethod.GET)
	public Notice notice(){
		return noticeService.findLastOne();
	}
	
}
