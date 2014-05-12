package com.example.myriadchallenge;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends ActionBarActivity implements View.OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.fragment_login,
	                container, false);
	        

	        return rootView;
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		private EditText username;
		private EditText password;
		private Button button;
		private String tempUsername = "";
		private String tempPassword = "";
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			
	        username = (EditText) rootView.findViewById(R.id.txtUsername);
			password = (EditText) rootView.findViewById(R.id.txtPassword);
			button = (Button) rootView.findViewById(R.id.loginbutton); 
			
	        button.setOnClickListener(new View.OnClickListener() {

	        @Override
	        public void onClick(View v) {
	        	
	        	tempUsername = username.getText().toString();
	        	tempPassword = password.getText().toString();
	        	
	        	if(tempUsername.equals("lancelot") && tempPassword.equals("arthurDoesntKnow"))
	    		{
	    			Intent intent = new Intent(getActivity(), QuestsList.class);
	    			startActivity(intent);
	    		}
	    		else
	    		{
	    			password.setError("Incorrect Login Information");
	    		}
	        }
	        }); 
			
			return rootView;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
