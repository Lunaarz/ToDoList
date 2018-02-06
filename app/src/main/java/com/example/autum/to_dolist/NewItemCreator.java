package com.example.autum.to_dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewItemCreator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_creator);

        //Add Button
        Button createButton = (Button) findViewById(R.id.createButton);

        //Text box and text formatting
        EditText listNameEditText = (EditText) findViewById(R.id.listNameEditText);
        String listItem = listNameEditText.getText().toString();

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(toMainActivity);

            }
        });


    }
}
