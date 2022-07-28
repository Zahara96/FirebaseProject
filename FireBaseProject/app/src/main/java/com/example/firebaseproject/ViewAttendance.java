package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ViewAttendance extends AppCompatActivity {

    ListView list_present,list_absent;
    DatabaseReference databaseReference;
    ArrayList<String> arrayListPresent = new ArrayList<>();
    ArrayList<String> arrayListAbsent = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);

        list_present = findViewById(R.id.list_present);
        list_absent = findViewById(R.id.list_absent);

        ArrayAdapter arrayAdapterPresent =new ArrayAdapter(ViewAttendance.this, android.R.layout.simple_list_item_1,arrayListPresent);
        ArrayAdapter arrayAdapterAbsent=new ArrayAdapter(ViewAttendance.this, android.R.layout.simple_list_item_1,arrayListAbsent);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String name = snapshot.getKey();
                String status = snapshot.getValue().toString();

                if (status.equalsIgnoreCase("Present")){
                    arrayAdapterPresent.add(name);
                    arrayAdapterPresent.notifyDataSetChanged();
                }else {
                    arrayAdapterAbsent.add(name);
                    arrayAdapterAbsent.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                arrayAdapterPresent.notifyDataSetChanged();
                arrayAdapterAbsent.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         list_present.setAdapter(arrayAdapterPresent);
         list_absent.setAdapter(arrayAdapterAbsent);

    }
}