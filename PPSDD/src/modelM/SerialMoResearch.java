package modelM;

import java.io.Serializable;
import java.util.ArrayList;




public class SerialMoResearch implements Serializable {
	//private static final long serialVersionUID = 1L;
private String slResearid;
private String slResearname;
private String slResearaddress;
private String slResearphone;
private String slResearemail;
private String slResearusername;
private char[] slResearpassword;


//ArrayList<SerialMoResearch> darayMainD = new ArrayList<SerialMoResearch>(100);
public SerialMoResearch(String slResearid,String slResearname, String slResearaddress,
		String slResearphone,String slResearemail,String slResearusername,char[] slResearpassword) {
this.slResearid=slResearid;
this.slResearname = slResearname;
this.slResearaddress = slResearaddress;
this.slResearphone = slResearphone;
this.slResearemail = slResearemail;
this.slResearusername = slResearusername;
this.slResearpassword = slResearpassword;

}

public SerialMoResearch() {
	//for the default constructor
}



public String getSEID() {
	return slResearid;
}
public void setjTRID() {
	this.slResearid=slResearid;
}


public String getSEName() {
return slResearname;
}
public void setjTRName(String slResearname) {
this.slResearname = slResearname;
}


public String getSEAddress() {
return slResearaddress;
}
public void setjTRAddress(String slResearaddress) {
this.slResearaddress = slResearaddress;
}



public String getSEPhone() {
return slResearphone;
}
public void setjTRPhone(String slResearphone) {
this.slResearphone = slResearphone;
}




public String getSEEmail() {
return slResearemail;
}
public void setjTREmail(String slResearemail) {
this.slResearemail = slResearemail;
}


public String getSEUsername() {
return slResearusername;
}
public void setjTRUsername(String slResearusername) {
this.slResearusername = slResearusername;
}


public char[] getSEPassword() {
return slResearpassword;
}

}