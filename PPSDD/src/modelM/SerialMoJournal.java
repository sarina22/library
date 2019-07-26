package modelM;

import java.io.Serializable;

public class SerialMoJournal implements Serializable {
private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String author;
	private String publicationYear;
	private String volumeNum;
	private String pageNum;
	private String hiredId;

	
	public SerialMoJournal(String id,String title, String author,String publicationYear,String volumeNum,String pageNum, String hiredId) {
	this.id=id;
	this.title = title;
	this.author = author;
	this.publicationYear = publicationYear;
	this.volumeNum = volumeNum;
	this.pageNum = pageNum;
	this.hiredId = hiredId;
	}

public SerialMoJournal() {
}
public String getJEID() {
	return id;
}
public void setjEID() {
	this.id=id;
}
public String getJJTitle() {
	return title;
}
public void setjJTitle(String title) {
	this.title = title;
}
public String getJAuthor() {
	return author;
}
public void setJAuthor(String author) {
	this.author = author;
}
public String getJpublicationYear() {
	return publicationYear;
}
public void setjJpublicationYear(String publicationYear) {
	this.publicationYear = publicationYear;
}
public String getJvolumeNum() {
	return volumeNum;
}
public void setJvolumeNum(String volumeNum) {
	this.volumeNum = volumeNum;
}
public String getJpageNum() {
	return pageNum;
}
public void setjJpageNum(String pageNum) {
	this.pageNum = pageNum;
}
public String getJHiredId() {
	return hiredId;
}
public void setJHiredId(String hiredId) {
	this.hiredId=hiredId;
}
}
