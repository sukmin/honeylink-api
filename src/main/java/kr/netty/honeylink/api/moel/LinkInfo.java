package kr.netty.honeylink.api.moel;

import java.util.List;

public class LinkInfo {

	private Long totalCount;
	private List<Link> links;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
