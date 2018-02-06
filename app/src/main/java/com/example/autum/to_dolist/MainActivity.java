package com.example.autum.to_dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Task List View
        ListView allListsListView = (ListView) findViewById(R.id.allListsListView);

        //Add Button
        Button createNewItemButton = (Button) findViewById(R.id.createNewItemButton);
        createNewItemButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                //On Click, goes to CreateNewItem Page
                Intent listCreatorScreen = new Intent(getApplicationContext(), NewItemCreator.class);
                startActivity(listCreatorScreen);

            }
        });

        //Collect task data from NewItemCreation Screen
//        if (getIntent().hasExtra("task")) {
//
//        }
    }
}
