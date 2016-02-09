package kr.netty.honeylink.api.repository;

import java.util.List;

import kr.netty.honeylink.api.moel.Link;

public interface LinkRepository {

	public void saveLink(Link link);
	public List<Link> findAll();
	public int updatePlusCount(Long sequence);
	
}
