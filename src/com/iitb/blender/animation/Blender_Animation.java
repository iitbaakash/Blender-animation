package com.iitb.blender.animation;




import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;


public class Blender_Animation extends Activity{
	WebView browser;
	public void onCreate(Bundle save)
	{
		super.onCreate(save);
		setContentView(R.layout.htmlcontent);
		
		browser = (WebView)findViewById(R.id.webview);
		
		if (new File("/mnt/extsd/Instructions/educational.html").exists())
		{
			browser.loadUrl("file:\\mnt\\extsd\\Instructions\\blender.html");
		}
		else if (new File("/mnt/sdcard/Instructions/educational.html").exists())
			{
				browser.loadUrl("file:\\mnt\\sdcard\\Instructions\\blender.html");
	
			}
		else
		{
			browser.loadUrl("file:///android_asset/blender.html");	
		}
		
	
	}
	
	
	public void Proceed(View v)
	{
		Intent intent = new Intent(Blender_Animation.this, MainActivity.class);
		
			startActivity(intent);
	}

}
