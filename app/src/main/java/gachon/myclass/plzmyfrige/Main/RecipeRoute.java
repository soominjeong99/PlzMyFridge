package gachon.myclass.plzmyfrige.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import gachon.myclass.plzmyfrige.R;

public class RecipeRoute extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_route);

        Button buttonB = findViewById(R.id.goBack);
        Button buttonM = findViewById(R.id.meat);
        Button buttonS = findViewById(R.id.seaFood);
        Button buttonV = findViewById(R.id.vegetable);
        Button buttonA = findViewById(R.id.resipeAll);

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
               //Toast.makeText(getApplicationContext(),"고기고기고기", Toast.LENGTH_LONG).show();
                //finish();
                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                intent.putExtra("category",1);
                startActivity(intent);
            }
        });
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"해물해물해물", Toast.LENGTH_LONG).show();
                //finish();
                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                intent.putExtra("category",2);
                startActivity(intent);
            }
        });
        buttonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"야채채소야채", Toast.LENGTH_LONG).show();
                //finish();
                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                intent.putExtra("category",3);
                startActivity(intent);
            }
        });
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"모든레시피", Toast.LENGTH_LONG).show();
                //finish();
                Intent intent = new Intent(getApplicationContext(), RecipeList.class);
                intent.putExtra("category",0);
                startActivity(intent);
            }
        });

    }


}