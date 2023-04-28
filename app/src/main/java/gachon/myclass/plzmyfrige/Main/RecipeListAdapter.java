package gachon.myclass.plzmyfrige.Main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gachon.myclass.plzmyfrige.R;
public class RecipeListAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    String[] data;
    int[] pos;
    public RecipeListAdapter(Context context, String[] data,int[] dataPosition){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
        this.pos = dataPosition;
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.recipe_list_view, null);
        TextView textView = view.findViewById(R.id.recipe_name_view);
        textView.setText(data[position]);
        Button button = view.findViewById(R.id.resipe_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, // 현재 화면의 제어권자
                        RecipeView.class);
                intent.putExtra("position",pos[position]);
                context.startActivity(intent);
            }
        });

        return view;
    }


}
