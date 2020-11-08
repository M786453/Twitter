package com.example.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SignInActivity extends AppCompatActivity {
    private EditText edtSignInUsername,edtSignInPassword;
    private Button buSignInAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtSignInUsername=findViewById(R.id.edtSignInUsername);
        edtSignInPassword=findViewById(R.id.edtSignInPassword);
        buSignInAct=findViewById(R.id.buSignInAct);
        buSignInAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(edtSignInUsername.getText() + "", edtSignInPassword.getText() + "", new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!=null && e==null){
                            Toast.makeText(SignInActivity.this, "Logged In!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}