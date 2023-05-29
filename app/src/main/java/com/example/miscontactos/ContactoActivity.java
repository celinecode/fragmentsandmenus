package com.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Properties;
import android.net.Uri;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;


public class ContactoActivity extends AppCompatActivity {

    private EditText nameEditText, emailEditText, messageEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        messageEditText = findViewById(R.id.message_edit_text);
        nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String subject = nameEditText.getText().toString();
                String message = messageEditText.getText().toString();
                SendMail sm = new SendMail(this, email, subject, message);
                sm.execute();

            }
        });


    }
}