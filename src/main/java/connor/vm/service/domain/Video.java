package connor.vm.service.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "video")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "videoId")
	private int videoId;
	@XmlElement(name = "categoryId")
	private int categoryId;
	@XmlElement(name = "videoName")
	private String videoName;
	@XmlElement(name = "likeCount")
	private int likeCount;
	@XmlElement(name = "dislikeCount")
	private int dislikeCount;

	public Video() {
		// TODO Auto-generated constructor stub
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
