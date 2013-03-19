package com.iitb.blender.animation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	String Path;
	ListView lv;
	  int i = 0;
	     @Override
  public void onCreate(Bundle savedInstanceState) {
  //	ArrayList<String> CourseList=null;
  	//  String[] course=new String[9];
  	  List<String> folder;
  
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      if (new File("/mnt/extsd/blender animation/").exists()||new File("/mnt/sdcard/blender animation/").exists())
  	{
  			if (new File("/mnt/extsd/blender animation/").exists())
  			{	
  		
  				Path="/mnt/extsd/blender animation/";
  		 
  			}	
  			else
  			{
  				Path="/mnt/sdcard/blender animation/";
  			}
  		   
      
      
      folder = getListOfFiles(Path);
      System.out.println(""+folder);
      
 
     lv=(ListView)findViewById(R.id.listView1);
     ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.folderrow,R.id.title, folder);
     lv.setAdapter(arrayAdapter);
     
 	lv.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			TextView tv = (TextView) view.findViewById(R.id.title);
			
			String v_path = Path+tv.getText().toString();
						
			Intent intent = new Intent(MainActivity.this, Videoview.class);
			intent.putExtra("videofilename", v_path);// sending video file
														// path in next activity
			startActivity(intent);
			
		}
	});
  	}
      else{
    	  AlertDialog.Builder builder = new AlertDialog.Builder(this);
      	builder.setIcon(R.drawable.blender_animation_icon);
      	builder.setTitle("Blender animations are not present in the tablet!!!");
      	builder.setMessage(	"Please check whether animations are present at any one of the"+"\n"
      	+"following locations"+"\n"+"\n"+"1. go to mnt/sdcard/blender animation"
      			+"\n"+"2. go to mnt/extsd/blender animation")
      	
      	       .setCancelable(false)
      	       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
      	           public void onClick(DialogInterface dialog, int id) {
      	        	
      	        	  MainActivity.this.finish();
      	        	
      	           }
      	       });
      	AlertDialog alert = builder.create();   
      	alert.show();
  	
      }
	     }

	     

		 @Override
		    public boolean onCreateOptionsMenu(Menu menu) {
		        getMenuInflater().inflate(R.menu.activity_main, menu);
		        return true;
		    }

		
		  @Override
		    public boolean onOptionsItemSelected(MenuItem item)
		    {
		 
		        switch (item.getItemId())
		        {
		        case R.id.help:
		            
		        	Intent helpweb = new Intent(MainActivity.this,Help.class);
		        	startActivity(helpweb);
		        	return true;
		        	
		        
		 
		        
		        default:
		            return super.onOptionsItemSelected(item);
		        }
		    } 
		 
	     
    private List<String> getListOfFiles(String path) {
			// TODO Auto-generated method stub
    	
    	File files = new File(path);
		List<String> list = new ArrayList<String>();
		 for (File f : files.listFiles()) {
	          
			
					list.add(f.getName());
				i++;
				
			
	                // make something with the name
	        }
		 System.out.println("list order"+list);
			return list;
		}

	
    
}
