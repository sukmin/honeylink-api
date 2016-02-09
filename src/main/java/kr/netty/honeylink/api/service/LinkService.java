package kr.netty.honeylink.api.service;

import java.util.List;

import kr.netty.honeylink.api.moel.Link;

public interface LinkService {

	public List<Link> findAll();
	public Result putLink(Link link);
	public boolean plugCount(Long sequence);
	
	public enum Result {
		
		SUCEESS("l001","link 성공");
		
		private String code;
		private String message;

		private Result(String code, String message) {
			this.code = code;
			this.message = message;
		}

		public String getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}
	}
	
}
