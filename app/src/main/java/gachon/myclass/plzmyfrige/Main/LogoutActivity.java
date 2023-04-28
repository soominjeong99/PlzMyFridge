package gachon.myclass.plzmyfrige.Main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import gachon.myclass.plzmyfrige.R;

public class LogoutActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private FirebaseAuth firebaseAuth;

    Button memberWithdrawal, logOut;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        memberWithdrawal = (Button) findViewById(R.id.memberWithdrawal);
        logOut = (Button) findViewById(R.id.logOut);
        progressDialog = new ProgressDialog(this); //conncect Function

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();

        memberWithdrawal.setOnClickListener(this);
        logOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //로그아웃
        logOut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getApplicationContext(), "Logout.", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        //탈퇴하기
        memberWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.getCurrentUser().delete();
                Toast.makeText(getApplicationContext(), "Your account has been deleted.", Toast.LENGTH_LONG).show();
                finish();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });


    }
}

