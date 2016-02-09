package kr.netty.honeylink.api.moel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Link {

	private Long sequence;
	private String url;
	private String title;
	private String thumbnailUrl;
	private Integer readCount;
	private Date registrationDate;

	@JsonIgnore
	private Long registrationMemberSequence;
	@JsonIgnore
	private String isDelete;

	public Link() {
	}

	public Link(String url) {
		this.url = url;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public Long getRegistrationMemberSequence() {
		return registrationMemberSequence;
	}

	public void setRegistrationMemberSequence(Long registrationMemberSequence) {
		this.registrationMemberSequence = registrationMemberSequence;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

}
