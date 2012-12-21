package com.scheduleapp;


import com.parse.*;

import com.parse.ParseUser;

import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// Add your initialization code here
		Parse.initialize(this, "vItvRJsLWYhzWhxkbuh2KKpZNhRhxt47PpgFGVTR", "bQp1KR79ejBDspaQPd3j8swx4CEGUseEDGf0gZuT");

		
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
	}

}
