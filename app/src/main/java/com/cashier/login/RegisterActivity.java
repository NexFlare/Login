package com.cashier.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DataBaseHelper dbHelper;
    EditText userName,password,name;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName=findViewById(R.id.username);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        register=findViewById(R.id.register);
        dbHelper=new DataBaseHelper(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dbHelper.checkUser(userName.getText().toString())){
                    Toast.makeText(RegisterActivity.this,"User Already Exist",Toast.LENGTH_SHORT);
                }
                else {
                    dbHelper.addUser(new User(name.getText().toString(),userName.getText().toString(),password.getText().toString()));
                    Toast.makeText(RegisterActivity.this,"User Added",Toast.LENGTH_SHORT);
                    finish();
                }
            }
        });
    }
}
