package gachon.myclass.plzmyfrige;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gachon.myclass.plzmyfrige.Main.RecipeList;

public class RecipeRoute  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_route);

        Button buttonB = findViewById(R.id.goBack);
        Button buttonM = findViewById(R.id.meat);
        Button buttonS = findViewById(R.id.seaFood);
        Button buttonV = findViewById(R.id.vegetable);

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "돌아가기버튼이 눌렸어요", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(getApplicationContext(),
                       "고기고기고기", Toast.LENGTH_LONG).show();
                //finish();
                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                startActivity(intent);
            }
        });
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "해물해물해물", Toast.LENGTH_LONG).show();
                //finish();
            }
        });
        buttonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "야채채소야채", Toast.LENGTH_LONG).show();
                //finish();
            }
        });

    }


}