package com.iitb.blender.animation;



import java.io.File;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.support.v4.app.NavUtils;

public class Help extends Activity {
	WebView helppage;
    @SuppressLint("SetJavaScriptEnabled")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        
        helppage = (WebView) findViewById(R.id.helpwebView);
        helppage.getSettings().setJavaScriptEnabled(true);
        //helppage.loadUrl("file:///android_asset/help.html");
if (new File("/mnt/extsd/Instructions/oscar.html").exists())
    		
		{    
	 helppage.loadUrl("file:///mnt/extsd/Instructions/oscar.html");
		}
        
        else if(new File("/mnt/sdcard/Instructions/oscar.html").exists())
        {
        	 helppage.loadUrl("file:///mnt/sdcard/Instructions/oscar.html");
        }
        
        else
        {
        	helppage.loadUrl("file:///android_asset/oscar.html");
        }         
      
        
    }

   

    
}
