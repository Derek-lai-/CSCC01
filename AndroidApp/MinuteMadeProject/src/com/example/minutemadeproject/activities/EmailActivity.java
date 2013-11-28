package com.example.minutemadeproject.activities;

import com.example.minutemadeproject.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends Activity{

    private EditText toEmail = null;
    private EditText emailSubject = null;
    private EditText emailBody = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendemail);

        toEmail = (EditText) findViewById(R.id.toEmail);
        emailSubject = (EditText) findViewById(R.id.subject);
        emailBody = (EditText) findViewById(R.id.emailBody);

        Button sendButton = (Button) findViewById(R.id.send);
        Button attachButton = (Button) findViewById(R.id.attachment);
        
        attachButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                
            }
        });
        
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	String to = toEmail.getText().toString();
                String subject = emailSubject.getText().toString();
                String message = emailBody.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                // need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client"));
                finish();
            }
        });
        

    }
}
