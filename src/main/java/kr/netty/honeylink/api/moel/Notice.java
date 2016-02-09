package kr.netty.honeylink.api.moel;

public class Notice {

	public static final String TYPE_ONCE = "once";
	public static final String TYPE_FORCE = "force";
	public static final String TYPE_SHUTDOWN = "shutdown";
	public static final String TYPE_NORMAL = "normal";
	public static final String TYPE_UNDER = "under";
	public static final String TYPE_NONE = "none";

	private Long sequence;
	/**
	 * once : 한번만 보이는 공지<br>
	 * force : 한번보아도 강제로 무조건 보는 공지<br>
	 * shutdown : 서버에 작업 및 이상이 있는 경우 사용를 아예 못하도록 하기 위한 공지<br>
	 * normal : 사용자가 확인을 누르면 다음부터 보이지 않는 공지<br>
	 * under : lastVersion보다 낮은 버전의 앱에서만 보이는 공지<br>
	 * none : 무공지
	 */
	private String type; // once,force,shutdown,normal,under
	private String content;
	private String url;
	private String lastVersionName;

	public Notice() {
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLastVersionName() {
		return lastVersionName;
	}

	public void setLastVersionName(String lastVersionName) {
		this.lastVersionName = lastVersionName;
	}

}
