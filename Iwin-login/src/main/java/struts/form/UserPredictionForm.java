package struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserPredictionForm extends ActionForm {
private String[] winteam = new String[0];
private String[] mom = new String[0];
private String[] matchid = new String[0];
private String[] matchdate = new String[0];
private String userid = null;

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String[] getMatchdate() {
	return matchdate;
}

public void setMatchdate(String[] matchdate) {
	this.matchdate = matchdate;
}

public String[] getMatchid() {
	return matchid;
}

public void setMatchid(String[] matchid) {
	this.matchid = matchid;
}

public String[] getMom() {
	return mom;
}

public void setMom(String[] mom) {
	this.mom = mom;
}

public String[] getWinteam() {
	return winteam;
}

public void setWinteam(String[] winteam) {
	this.winteam = winteam;
}
public void reset(ActionMapping mapping, HttpServletRequest request) {
	// TODO Auto-generated method stub
	this.winteam=null;
}
}
