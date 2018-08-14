package com.tanzania.hemmy.mysystemdemographforme.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tanzania.hemmy.mysystemdemographforme.R;

public class UsersActivity extends AppCompatActivity{
    EditText  username, password;
    Button save;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        save = (Button)findViewById(R.id.button_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
