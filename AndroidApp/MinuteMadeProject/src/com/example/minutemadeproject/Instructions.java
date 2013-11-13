package com.example.minutemadeproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Instructions extends Activity {
	String position;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instructions);
		EditText content = (EditText) findViewById(R.id.contentEdit);
		EditText topic = (EditText) findViewById(R.id.topicEdit);
		Intent intent = getIntent();
		String[] message = intent.getStringArrayExtra("lesson");
		position = message[2];
		//CharSequence a = "gg";
		content.setText(message[1]);
		topic.setText(message[0]);
		setupActionBar();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.instructions, menu);
		return true;
	}
	
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}
	
	public void save(View V){
		Intent intent = new Intent();
		EditText content = (EditText) findViewById(R.id.contentEdit);
		EditText topic = (EditText) findViewById(R.id.topicEdit);
		String[] toSend = {topic.getText().toString(), content.getText().toString(), position};
		intent.putExtra("lesson", toSend);
	    setResult(10, intent);
		finish();
	}
	
	public void remove(View V){
		Intent intent = new Intent();
		EditText content = (EditText) findViewById(R.id.contentEdit);
		EditText topic = (EditText) findViewById(R.id.topicEdit);
		String[] toSend = {topic.getText().toString(), content.getText().toString(), position};
		intent.putExtra("lesson", toSend);
	    setResult(11, intent);
		finish();
	}

}
