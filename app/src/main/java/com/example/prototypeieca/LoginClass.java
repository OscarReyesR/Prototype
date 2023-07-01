package com.example.prototypeieca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class LoginClass extends AppCompatActivity {
    private EditText txtUserName,txtPasswd;
    private String userName=null,passwd=null;
    private Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        txtUserName=findViewById(R.id.txtInputUserName);
        txtPasswd=findViewById(R.id.txtInputPasswd);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=txtUserName.getText().toString();
                passwd=txtPasswd.getText().toString();
                logIn();
            }
        });
    }

    private void logIn(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }//end function logIn
}
