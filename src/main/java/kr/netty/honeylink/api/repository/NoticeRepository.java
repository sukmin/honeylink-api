package kr.netty.honeylink.api.repository;

import kr.netty.honeylink.api.moel.Notice;

public interface NoticeRepository {
	
	public Notice findLastOne();

}
