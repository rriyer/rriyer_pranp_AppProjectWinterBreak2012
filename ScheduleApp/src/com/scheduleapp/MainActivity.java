package com.scheduleapp;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.util.Log;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.widget.*;
import android.view.*;
import android.view.View.*;
import com.parse.*;
public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Parse.initialize(this, "vItvRJsLWYhzWhxkbuh2KKpZNhRhxt47PpgFGVTR", "bQp1KR79ejBDspaQPd3j8swx4CEGUseEDGf0gZuT");

		
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		defaultACL.setPublicReadAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);
		
        Button signUp = (Button)findViewById(R.id.button2);
        Button logIn = (Button)findViewById(R.id.button1);
        logIn.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		TextView username = (TextView)findViewById(R.id.editText1);
 				String name = username.getText().toString();
 				TextView password = (TextView)findViewById(R.id.editText2);
 				String pass = password.getText().toString();
 				 Log.i("logging in", "The login button was hit");
 				//signIn(name,pass);
        	}
        });
        signUp.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				TextView username = (TextView)findViewById(R.id.editText1);
				String name = username.getText().toString();
				TextView password = (TextView)findViewById(R.id.editText2);
				String pass = password.getText().toString();
				Log.i("signing up", "the signup button was hit");
				createAccount(name,pass);
			}
		});
    }
    // 
    public void createAccount(String username, String password){
		ParseUser user = new ParseUser();
		user.setUsername(username);
		user.setPassword(password);
		user.signUpInBackground(new SignUpCallback(){
			public void done (ParseException e){
				if(e == null){
					Log.i("create account", "youre account was successfullly created");
				}
				else{
					Log.i("create account", "You could not sign in for some reason");
				}
			}
		});
	}
    public void signIn(String username, String password){
		ParseUser.logInInBackground(username,password, new LogInCallback() {
			  public void done(ParseUser user, ParseException e) {
			    if (user != null) {
			    	Log.i("login", "\n\n\n\n\n\n\nSign in was successful");
			    	//Intent request = new Intent(ParseStarterProjectActivity.this,PostActivity.class);
			    	//startActivity(request);
			    } else {
			     Log.i("login", "user could not be successfully logged in");
			    }
			  }
			});
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}//test another change
