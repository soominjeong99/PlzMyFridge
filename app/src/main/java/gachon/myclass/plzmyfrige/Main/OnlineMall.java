package gachon.myclass.plzmyfrige.Main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import gachon.myclass.plzmyfrige.R;

//온라인몰
public class OnlineMall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onlinemall);

        ImageButton btn_emart = (ImageButton) findViewById(R.id.emartButton);
        ImageButton btn_lottemart = (ImageButton) findViewById(R.id.lottemartButton);
        ImageButton btn_homeplus = (ImageButton) findViewById(R.id.homeplusButton);
        ImageButton btn_cj = (ImageButton) findViewById(R.id.cjButton);
        ImageButton btn_hanaromart = (ImageButton) findViewById(R.id.hanaromartButton);
        ImageButton btn_costco = (ImageButton) findViewById(R.id.costcoButton);


        //이마트 몰로 이동
        btn_emart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.emart.ssg.com/"));
                startActivity(intent);
                finish();
            }
        });

        //롯데마트 몰로 이동
        btn_lottemart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://lottemart.lotteon.com/"));
                startActivity(intent);
                finish();
            }
        });

        //홈플러스 몰로 이동
        btn_homeplus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://front.homeplus.co.kr/"));
                startActivity(intent);
                finish();
            }
        });

        //cj더마켓 몰로 이동
        btn_cj.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://m.cjthemarket.com/"));
                startActivity(intent);
                finish();
            }
        });

        //하나로마트 몰로 이동
        btn_hanaromart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.nonghyupmall.com/"));
                startActivity(intent);
                finish();
            }
        });

        //코스트코 몰로 이동
        btn_costco.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.costco.co.kr/"));
                startActivity(intent);
                finish();
            }
        });
    }

}