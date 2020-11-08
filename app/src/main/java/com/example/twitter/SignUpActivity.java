package com.example.twitter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    private EditText edtSignUpEmail,edtSignUpUsername,edtSignUpPassword;
    private Button buSignUpAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtSignUpEmail=findViewById(R.id.edtSignUpEmail);
        edtSignUpUsername=findViewById(R.id.edtSignUpUsername);
        edtSignUpPassword=findViewById(R.id.edtSignUpPassword);
        buSignUpAct=findViewById(R.id.buSignUpAct);
        buSignUpAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser appUser=new ParseUser();
                appUser.setEmail(edtSignUpEmail.getText()+"");
                appUser.setUsername(edtSignUpUsername.getText()+"");
                appUser.setPassword(edtSignUpPassword.getText()+"");
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(SignUpActivity.this, "Signed Up!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}