package gachon.myclass.plzmyfrige.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import gachon.myclass.plzmyfrige.R;

public class RecipeView extends AppCompatActivity {
    Button button1;
    Button button2;
    ImageView imageView1;
    int step;
    int end;
    int start;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_view);
        Intent secondIntent = getIntent();
        button1 = (Button) findViewById(R.id.recipe_button1);
        button2 = (Button) findViewById(R.id.recipe_button2);
        imageView1 = (ImageView)findViewById(R.id.recipe_image);

        int p = secondIntent.getIntExtra("position", 0);
        int[] s = getResources().getIntArray(R.array.recipeStart);

        step = s[p];
        end = s[p+1]-1;
        start = s[p];

        imageView1.setImageResource(R.drawable.recipe00+step);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(step == start){
                    finish();
                }
                else{
                    step--;
                    imageView1.setImageResource(R.drawable.recipe00 +step);
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(step == end){
                    finish();
                }
                else{
                    step = step +1;
                    imageView1.setImageResource(R.drawable.recipe00 +step);
                }
            }
        });


    }
/*
    private void downloadImg(StorageReference storageRef, int step) {
        String fileName = step+".PNG";
        int r;
        File filedir = getExternalFilesDir(Environment.DIRECTORY_PICTURES + "/imege/goldenEggRice");
        final File downFile = new File(filedir,fileName);
        StorageReference downloadRef = storageRef.child("/imege/goldenEggRice/0.PNG");

        downloadRef.getFile(downFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
                Log.e("onSuccess",downFile.getPath());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                Log.e("onFailure",step+" step is fail");
            }
        });

    }
*/


} //gs://plzmf-ebad6.appspot.com/recipe/goldEggRice.txt
//gs://plzmf-ebad6.appspot.com/imege/goldenEggRice/1.PNG

