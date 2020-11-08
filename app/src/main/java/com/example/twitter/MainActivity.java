package com.example.twitter;

import
        androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.parse.Parse;
import com.parse.ParseInstallation;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );
        ParseInstallation.getCurrentInstallation().saveInBackground();

        findViewById(R.id.buSignIn).setOnClickListener(MainActivity.this);
        findViewById(R.id.buSignUp).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buSignIn:
                transitionToAnOtherActivity(SignInActivity.class);
                break;
            case R.id.buSignUp:
                transitionToAnOtherActivity(SignUpActivity.class);
        }
    }
    private void transitionToAnOtherActivity(Class anOtherActivity){
    startActivity(new Intent(MainActivity.this,anOtherActivity));
    }
}