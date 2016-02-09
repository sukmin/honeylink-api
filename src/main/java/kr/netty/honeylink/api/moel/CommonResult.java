package kr.netty.honeylink.api.moel;

import kr.netty.honeylink.api.service.LinkService;

public class CommonResult {

	private String code;
	private String message;
	
	public CommonResult(){
	}
	
	public CommonResult(LinkService.Result result){
		this.code = result.getCode();
		this.message = result.getMessage();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
