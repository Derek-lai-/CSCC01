package com.example.minutemadeproject.activities;

import java.util.List;


import com.example.minutemadeproject.R;
import com.example.minutemadeproject.helpers.InstructorHelper;
import com.example.minutemadeproject.models.Instructor;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends Activity {
    Button btnSignIn, btnSignUp;
    InstructorHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        db = new InstructorHelper(getApplicationContext());

        // Get The Reference Of Buttons
        btnSignIn = (Button) findViewById(R.id.buttonSignIN);
        btnSignUp = (Button) findViewById(R.id.buttonSignUP);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /// Create Intent for SignUpActivity and start the Activity
                Intent intentSignUP = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intentSignUP);
            }
        });
    }

    // Methods to handleClick Event of Sign In Button
    public void signIn(View V) {
        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the References of views
        final EditText editTextUserName = (EditText) dialog.findViewById(R.id.editTextUserNameToLogin);
        final EditText editTextPassword = (EditText) dialog.findViewById(R.id.editTextPasswordToLogin);
        Button btnSignIn = (Button) dialog.findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();
                final List<Instructor> instructors = db.getAll();
                String storedPassword = "";
                // fetch the Password form database for respective user name
                for(Instructor i: instructors){
                    if(i.getUsername().equals(userName))
                        storedPassword = i.getPassword();
                }

                // check if the Stored password matches with  Password entered by user
                if (password.equals(storedPassword)) {
                    Toast.makeText(HomeActivity.this, "Thank you for logging in " + userName, Toast.LENGTH_LONG).show();
                    dialog.dismiss();

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("CURRENT_USER", userName);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), MainmenuActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(HomeActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        //loginDataBaseAdapter.close();
    }
}
