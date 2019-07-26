package modelM;

import java.io.Serializable;

public class SerialMoBook implements Serializable {

		
  private String id;
  private String title;
  private String author;
  private String publicationYear;
  private String editors;
  private String pageNum;
  private String location;
  private String publisher;
  private String hireID;
			

public SerialMoBook(String id,String title, String author,String publicationYear,String editors,String pageNum,String location,String publisher,String hireID)
{
  this.id=id;
  this.title = title;
  this.author = author;
  this.publicationYear = publicationYear;
  this.editors = editors;
  this.pageNum = pageNum;
  this.location = location;
  this.publisher = publisher;
  this.hireID = hireID;
}

public SerialMoBook()
{
 }

public String getjBID() 
{
return id;
}
public void setjBID() {
this.id=id;
}


public String getjBTitle() {
return title;
}
public void setjBTitle(String title) {
this.title = title;
}


public String getjBAuthor() {
return author;
}
public void setjBAuthor(String author) {
this.author = author;
}



public String getjBpublicationYear() {
return publicationYear;
}
public void setjBpublicationYear(String publicationYear) {
this.publicationYear = publicationYear;
}


			
public String getjBeditors() {
return editors;
}
public void setjBeditors(String editors) {
this.editors = editors;
}

			
		

public String getjBpageNum() {
return pageNum;
}
public void setjBpageNum(String pageNum) {
this.pageNum = pageNum;
}

			
public String getjBLocation() {
return location;
}
public void setjBLocation(String location) {
this.location = location;
}

public String getjBPublisher() {
return publisher;
}
public void setjBPublisher(String publisher) {
this.publisher = publisher;
}

public String getjBhireID() {
return hireID;
}
public void setjBhireID(String hireID) {
this.hireID = hireID;
}









}
			
			

