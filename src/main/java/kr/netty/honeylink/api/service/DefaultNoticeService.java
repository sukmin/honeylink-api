package kr.netty.honeylink.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.netty.honeylink.api.moel.Notice;
import kr.netty.honeylink.api.repository.NoticeRepository;

@Service
public class DefaultNoticeService implements NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public Notice findLastOne() {
		return noticeRepository.findLastOne();
	}

}
