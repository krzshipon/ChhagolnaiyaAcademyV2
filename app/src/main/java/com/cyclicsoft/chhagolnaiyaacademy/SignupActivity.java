package com.cyclicsoft.chhagolnaiyaacademy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cyclicsoft.chhagolnaiyaacademy.model.Student;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private EditText mETName, mETFathersName, mETMothersName, mETEmail, mEtPass, mETPhone, mEtPAddress, mEtNID, mEtSSC, mEtUniversity, mEtProfess, mEtPrAdd;
    private TextView btnSignIn, btnSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView toolbarText = findViewById(R.id.toolbar_text);
        ImageButton menuButton = findViewById(R.id.button_menu);
        ImageView searchButton = findViewById(R.id.button_search);
        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbarText!=null && toolbar!=null) {
            toolbarText.setText(getTitle());
            menuButton.setVisibility(View.GONE);
            searchButton.setVisibility(View.GONE);
            setSupportActionBar(toolbar);
        }

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();

        btnSignIn = findViewById(R.id.tv_button_register_cancel);
        btnSignUp = findViewById(R.id.tv_button_register_save);
        //Fields
        mETName = findViewById(R.id.profile_name_fragment_register);
        mETFathersName = findViewById(R.id.fathers_name_fragment_register);
        mETMothersName = findViewById(R.id.mothers_name_fragment_register);
        mETEmail = findViewById(R.id.user_email_fragment_register);
        mEtPass = findViewById(R.id.user_password_fragment_register);
        mEtNID = findViewById(R.id.user_nid_fragment_register);
        mETPhone = findViewById(R.id.user_phone_fragment_register);
        mEtPAddress = findViewById(R.id.present_address_fragment_register);
        mEtSSC = findViewById(R.id.ssc_batch_fragment_register);
        mEtUniversity = findViewById(R.id.user_university_fragment_register);
        mEtPrAdd = findViewById(R.id.present_address_fragment_register);
        mEtProfess = findViewById(R.id.user_profession_fragment_register);
        progressBar = findViewById(R.id.progressBar);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mETEmail.getText().toString().trim();
                String password = mEtPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                final String sName = mETName.getText().toString().trim();
                final String sFather = mETFathersName.getText().toString().trim();
                final String sMother = mETMothersName.getText().toString().trim();
                final String sEmail = mETEmail.getText().toString().trim();
                final String sPhone = mETPhone.getText().toString().trim();
                final String sPAddress = mEtPAddress.getText().toString().trim();
                final String sNID = mEtNID.getText().toString().trim();
                final String sSSCBatch = mEtSSC.getText().toString().trim();
                final String sUniversity = mEtUniversity.getText().toString().trim();
                final String sProfessions = mEtProfess.getText().toString().trim();
                final String sPrAddress = mEtPrAdd.getText().toString().trim();

                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Student student = new Student(auth.getCurrentUser().getUid());
                                    student.setsName(sName);
                                    student.setsFather(sFather);
                                    student.setsMother(sMother);
                                    student.setsEmail(sEmail);
                                    student.setsPhone(sPhone);
                                    student.setsPAddress(sPAddress);
                                    student.setsNID(sNID);
                                    student.setsSSCBatch(sSSCBatch);
                                    student.setsUniversity(sUniversity);
                                    student.setsProfessions(sProfessions);
                                    student.setsPrAddress(sPrAddress);

                                    database.child("Users").child(auth.getCurrentUser().getUid()).setValue(student);
                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}