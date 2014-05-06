package struts.form;

import org.apache.struts.action.ActionForm;

public class PlayerForm extends ActionForm {
private String name;
private String team;
private String category;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getTeam() {
	return team;
}
public void setTeam(String team) {
	this.team = team;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

}
