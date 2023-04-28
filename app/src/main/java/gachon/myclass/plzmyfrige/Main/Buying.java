package gachon.myclass.plzmyfrige.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gachon.myclass.plzmyfrige.R;

public class Buying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buying);

        ImageButton onlineMall = findViewById(R.id.onlineMallButton);
        ImageButton nearMall = findViewById(R.id.nearMallButton);
        /*
            public void onClick (View view)
            {
                switch (view.getId()) {
                    case R.id.onlineMall:
                        //온라인몰 버튼을 눌렀을 때의 처리
                        Intent intent = new Intent(getApplicationContext(), OnlineMall.class);
                        startActivity(intent);
                        break;

                    case R.id.nearMall:
                        //주변몰 버튼을 눌렀을 때의 처리
                        Intent intent1 = new Intent(getApplicationContext(), NearMall.class);
                        startActivity(intent1);
                        break;

                    case R.id.returnPage:
                        //돌아가기 버튼을 눌렀을 때의 처리
                        Toast.makeText(getApplicationContext(), "돌아가기버튼이 눌렸어요", Toast.LENGTH_LONG).show();
                        finish();
                        break;
                }
                */

        //온라인 몰로 이동
        onlineMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OnlineMall.class);
                startActivity(intent);

            }
        });

        //주변마트로 이동
        nearMall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NearMall.class);
                startActivity(intent);

            }
        });


    }
}

