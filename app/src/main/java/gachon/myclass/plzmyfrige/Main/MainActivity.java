package gachon.myclass.plzmyfrige.Main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import gachon.myclass.plzmyfrige.DTO.User;
import gachon.myclass.plzmyfrige.R;
import gachon.myclass.plzmyfrige.Main.RecipeRoute;


public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button1 = findViewById(R.id.goRecipe);
        ImageButton button2 = findViewById(R.id.main_frige);
        ImageButton button3 = findViewById(R.id.main_buying);
        //ImageButton button4 = findViewById(R.id.main_logout);


        //상단 이미지 에니메이션 부분
        int images[] = {R.drawable.cook1, R.drawable.cook2,R.drawable.cook3};
        v_flipper = findViewById(R.id.v_flipper);

        //for loop
        for(int i=0;i<images.length;i++)
        {
            flipperImages(images[i]);
        }



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecipeRoute.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), // 현재 화면의 제어권자
                        MyFrige.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),
                        Buying.class);
                startActivity(intent);

            }
        });

//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),
//                        LogoutActivity.class);
//                startActivity(intent);
//
//            }
//        });


    }
    public void flipperImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000); //4 sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);

    }

}