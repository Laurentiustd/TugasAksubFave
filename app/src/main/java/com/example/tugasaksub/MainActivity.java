package com.example.tugasaksub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText fullname,username, email, dob, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegis = findViewById(R.id.btnRegis);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        password = findViewById(R.id.password);
//        TextView dpUsername = findViewById(R.id.display_username);
//        TextView dpEmail = findViewById(R.id.display_email);

        SharedPreferences sharedPref =  PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        SharedPreferences.Editor editor = sharedPref.edit();



//        btnRegis.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                Toast.makeText(getApplicationContext(),"Moving To Login Page", Toast.LENGTH_SHORT).show();
//                startActivity(intent);
//            }
//        });
        btnRegis.setOnClickListener(v->{
            String newFullname = fullname.getText().toString();
            String newUsername = username.getText().toString();
            String newEmail = email.getText().toString();
            String newDob = dob.getText().toString();
            String newPassword = password.getText().toString();
            if(!newFullname.equals("") && !newEmail.equals("") && !newPassword.equals("") && !newUsername.equals("") && !newDob.equals("")){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // set title, message, tombol
                builder
                        .setTitle("Alert!!")
                        .setMessage("Are You Sure All The Data is Correct?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                editor.putString("dpUsername", newUsername);
                                editor.putString("dpEmail", newEmail);
                                editor.apply();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                Toast.makeText(getApplicationContext(),"Moving To Login Page", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}