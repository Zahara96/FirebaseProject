package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    Button markPresent, markAbsent;
    EditText name;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        markPresent = findViewById(R.id.markPresent);
        markAbsent = findViewById(R.id.markAbsent);
        name = findViewById(R.id.name);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        markPresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = name.getText().toString();
                databaseReference.child(getName).setValue("Present");
                name.setText("");
            }
        });

        markAbsent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = name.getText().toString();
                databaseReference.child(getName).setValue("Absent");
                name.setText("");
            }
        });

    }
}