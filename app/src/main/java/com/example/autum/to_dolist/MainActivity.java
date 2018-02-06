package com.example.autum.to_dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //showData(dataSnapshot);
                populateListView(dataSnapshot);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //Button & OnClickListener
        Button createNewItemButton = (Button) findViewById(R.id.createNewItemButton);
        createNewItemButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                //On Click, goes to CreateNewItem Page
                Intent listCreatorScreen =
                        new Intent(getApplicationContext(), NewItemCreator.class);
                startActivity(listCreatorScreen);

            }
        });

        //ListView OnItemClickListener
        ListView mainListView = (ListView) findViewById(R.id.mainListView);
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

    }

    private void populateListView(DataSnapshot dataSnapshot) {
        //Create Array of Values to feed to list
        //ArrayList<String> myItems = {"red", "orange", "yellow"};
        //myItems.toArray();
        String[] myItems = {"red", "orange", "yellow"};
        //Build Adapter


        int i = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            i++;
        }
        String[] myItemsFromFirebase = new String[i];
        int j = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            myItemsFromFirebase[j] = ds.child("name").getValue().toString();
            j++;
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.list_view_main, myItemsFromFirebase);
        // HERE DO THIS Make an Array of strings here to add to display
        //Configure List View
        ListView mainListView = (ListView) findViewById(R.id.mainListView);
        mainListView.setAdapter(adapter);
    }
}
