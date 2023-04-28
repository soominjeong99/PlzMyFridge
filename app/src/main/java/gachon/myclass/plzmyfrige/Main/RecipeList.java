package gachon.myclass.plzmyfrige.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gachon.myclass.plzmyfrige.R;


public class RecipeList extends AppCompatActivity {
    ListView exampleList;
    String[] dataSample;
    int[] R_cate;
    int[] recipein;
    int cate;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list);
        int nn=0;
        textView = findViewById(R.id.test_recipe_text);
        dataSample = getResources().getStringArray(R.array.recipe_list);
        recipein = getResources().getIntArray(R.array.recipeToTenInt);
        R_cate = getResources().getIntArray(R.array.recipeCate);
        SharedPreferences shef = this.getSharedPreferences("frigelist", this.MODE_PRIVATE);
        Map<String,?> map = shef.getAll();
        Set<String> keys = map.keySet();
        List textc = new ArrayList(keys);
        Collections.sort(textc);
        Set<String> frigeset = new HashSet<>(textc) ;
        String val4="";
        for (int i=0;i<textc.size();i++) {
            if (map.get(textc.get(i).toString()).toString() == "true") {
                val4 +="1";
            }else{
                val4 +="0";
            }
        }
//        usten 십진법으로 변환
        int usten = 0;
        for (int i=0;i<textc.size();i++) {
            if (map.get(textc.get(i).toString()).toString() == "true") {
                usten +=Math.pow(2,i);
            }
        }
        Intent secondIntent = getIntent();
        cate = secondIntent.getIntExtra("category",0);

        for(int n=0;n<dataSample.length;n++){
            if((recipein[n] & usten )== recipein[n]){
                if(R_cate[n]==cate) {
                    nn++;
                }
                else if(cate == 0){
                    nn++;
                }
            }
        }
        String[] data = new String[nn];
        int[] dataPosition = new int[nn];
        nn=0;
        for(int n=0;n<dataSample.length;n++){
            if((recipein[n] & usten )== recipein[n]){
                if(R_cate[n]==cate) {
                    //Log.e("listTrue", "" + dataSample[n] + " true");
                    data[nn] = dataSample[n];
                    dataPosition[nn] = n;
                    nn++;
                }
                else if(cate == 0 ){
                    data[nn] = dataSample[n];
                    dataPosition[nn] = n;
                    nn++;
                }
            }
        }
        boolean a = ((recipein[0] & usten )== recipein[0]);
        int k = (recipein[0] & usten );

        if(data.length == 0){
            textView.setText("식재료가 부족해요");
        }
        else
            textView.setText(""+data.length);

        exampleList = findViewById(R.id.listView);
        RecipeListAdapter buttonListAdapter = new RecipeListAdapter(this, data,dataPosition);
        exampleList.setAdapter(buttonListAdapter);
    }


}

