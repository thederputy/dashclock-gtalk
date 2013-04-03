package ca.jacobk.dashclockgtalkextension;

import android.content.Intent;

//Data holding class thing for information in to Extensions
public class GTalkData extends com.google.android.apps.dashclock.api.ExtensionData {

	//replace with real icon
	private static final int ICON_ID = R.drawable.ic_launcher;
	
	//constructor for extension message with 1 new gtalk message
	public GTalkData(String status, String expandedTitle,
			String expandedBody, Intent clickIntent) {
		this.icon(ICON_ID);
		this.status(status);
		this.expandedTitle(expandedTitle);
		this.expandedBody(expandedBody);
		//gtalk message
		//this.clickIntent(clickIntent);
		this.visible(true);
	}
	
	//constructor for extension message with multiple new gtalk messages
	/*public GTalkData(String status, String expandedTitle,
			String expandedBody, Intent clickIntent) {
		
	}*/
	
	
	//expanded
}
