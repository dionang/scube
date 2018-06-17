package setup;

import action.Form;





/**
 *  This class contains helper methods to conform double into specific format
 *
 *@author     PKTAN
*/

public class ActionForm extends Form{
	private String actionName;
	private String actionType;
	private boolean released=false;
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public boolean isReleased() {
		return released;
	}
	public void setReleased(boolean released) {
		this.released = released;
	}
}
