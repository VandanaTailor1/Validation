package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ValidationActivity extends AppCompatActivity {
   Button cancel,process;
   boolean failed=false;
   EditText firstname,lastname,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation);
        cancel =findViewById(R.id.cancelButton);
        process=findViewById(R.id.proceedButton);
        firstname=findViewById(R.id.firstName);
        lastname=findViewById(R.id.lastName);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                failed=checkField();
                if(failed){
                    Intent intent=new Intent(ValidationActivity.this,ValidationActivity.class);
                    startActivity(intent);
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidationActivity.this.finish();
                System.exit(0);
            }
        });
    }
    private boolean checkField() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (firstname.length() == 0) {
            firstname.setError("Required name");
            return  false;
        }if (lastname.length() == 0) {
            lastname.setError("Required last name");
            return  false;
        }  if (email.length() == 0 || !email.getText().toString().matches(emailPattern)) {
            email.setError("email is required");
            return  false;
        }

        if (password.length() < 8) {
            password.setError("Minimum 8 words are required");
            return  false;
        }else if(password.length()==0){
            password.setError("Empty password");
        }
        return  false;
    }
}