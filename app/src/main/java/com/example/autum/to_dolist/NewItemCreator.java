package com.example.autum.to_dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class NewItemCreator extends AppCompatActivity {
    private static final String TAG = "NewItemCreator";
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    EditText editTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_item_creator);


        database = FirebaseDatabase.getInstance();
        Button createButton = (Button) findViewById(R.id.createButton);

        //Text box and text formatting
        //EditText listNameEditText = (EditText) findViewById(R.id.listNameEditText);
        //String listItem = listNameEditText.getText().toString();

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                //end database test commands
                addButtonClicked(editTask);
                startActivity(toMainActivity);
            }
        });

    }

    public void addButtonClicked(){
        editTask = (EditText) findViewById(R.id.listNameEditText);
        String name = editTask.getText().toString();
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);

        myRef = database.getInstance().getReference().child("Tasks");
        DatabaseReference newTask = myRef.push();
        newTask.child("name").setValue(name);
        newTask.child("time").setValue(dateString);
        Log.d(TAG, "addButtonClicked: Data sent");

    }
}
