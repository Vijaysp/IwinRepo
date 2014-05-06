package struts.form;

import org.apache.struts.action.ActionForm;

public class AdminForm extends ActionForm {
private String chosenMatchID;

public String getChosenMatchID() {
	return chosenMatchID;
}

public void setChosenMatchID(String chosenMatchID) {
	this.chosenMatchID = chosenMatchID;
}

}
