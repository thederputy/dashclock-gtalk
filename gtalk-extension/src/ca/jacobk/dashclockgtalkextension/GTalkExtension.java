package ca.jacobk.dashclockgtalkextension;

import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

public class GTalkExtension extends DashClockExtension {
	private static final String TAG = "GTalkExtension";
	private static final Uri CONTENT_URI =
			Uri.parse("content://com.google.android.providers.talk/messages");

    public static final String PREF_NAME = "pref_name";
	@Override
	protected void onUpdateData(int arg0) {
		// Get preference value.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String name = sp.getString(PREF_NAME, getString(R.string.pref_name_default));

        Log.w("chirs", CONTENT_URI.getAuthority());
        
        Cursor cur = null;
        ContentResolver cr = getContentResolver();
        
        //edit to only get needed columns back .... nicknames, body only where message = unread
        cur = cr.query(CONTENT_URI, null, null, null, null);
        
        Log.w("chris", "col: " + cur.getColumnCount());
        String names[] = cur.getColumnNames();
        for(int i = 0; i < cur.getColumnCount(); i++)
        {
        	Log.w("chris", names[i]);
        }
        Log.w("chris", "row: " + cur.getCount());
        
        String r = "";

        cur.moveToFirst();
        for (int i = 0; i < 15; i++)
        {
        	r += cur.getString(i) + " ";
        }
        Log.w("message", r);
        r = "";
        
        cur.moveToNext();
        for (int i = 0; i < 15; i++)
        {
        	r += cur.getString(i) + " ";
        }
        Log.w("message", r);
        r = "";
        
        cur.moveToLast();
        for (int i = 0; i < 15; i++)
        {
        	r += cur.getString(i) + " ";
        }
        Log.w("message", r);
        r = "";
        
        
        
        // Publish the extension data update.
        publishUpdate(new GTalkData("Hello", "Hello " + name, 
        		"GTalk DashClock has begun...",
        		new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))));
        /*publishUpdate(new ExtensionData()
                .visible(true)
                .icon(R.drawable.ic_launcher)
                .status("Hello")
                .expandedTitle("Hello, " + name + "!")
                .expandedBody("Thanks for checking out this GTalk extension for DashClock.")
                .clickIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))));
                */
	}
	
	//comment to test git

}
