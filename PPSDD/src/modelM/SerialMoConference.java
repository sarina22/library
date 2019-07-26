package modelM;

import java.io.Serializable;

public class SerialMoConference implements Serializable{

	// serializable attributes
  private String id;
  private String title;
  private String author;
  private String publicationYear;
  private String editors;
  private String pageNum;
  private String location;
  private String hiredId;
		



public SerialMoConference(String id,String title, String author,String publicationYear,String editors,String pageNum,String location,String hiredId) {
  this.id=id;
  this.title = title;
  this.author = author;
  this.publicationYear = publicationYear;
  this.editors = editors;
  this.pageNum = pageNum;
  this.location = location;
  this.hiredId = hiredId;
}

public SerialMoConference() {
}
public String getjCID() {
	return id;
}
public void setjCID() {
	this.id=id;
}
public String getjCTitle() {
	return title;
}
public void setjCTitle(String title) {
	this.title = title;
}
public String getjCAuthor() {
	return author;
}
public void setjCAuthor(String author) {
	this.author = author;
}
public String getjCpublicationYear() {
	return publicationYear;
}
public void setjCpublicationYear(String publicationYear) {
	this.publicationYear = publicationYear;
}
public String getjCeditors() {
	return editors;
}
public void setjCeditors(String editors) {
	this.editors = editors;
}
public String getjCpageNum() {
	return pageNum;
}
public void setjCpageNum(String pageNum) {
	this.pageNum = pageNum;
}
public String getjCLocation() {
	return location;
}
public void setjCLocation(String location) {
	this.location = location;
}

public String getjChiredId() {
	return hiredId;
}
public void setjChiredId(String hiredId) {
	this.hiredId = hiredId;
}




}
		
		
