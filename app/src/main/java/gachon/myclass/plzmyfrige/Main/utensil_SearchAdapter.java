package gachon.myclass.plzmyfrige.Main;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import gachon.myclass.plzmyfrige.R;

public class utensil_SearchAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;
    public SharedPreferences sharedPreferences;

    public utensil_SearchAdapter(List<String> list, Context context){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);


    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflate.inflate(R.layout.frige_listview,null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.label);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));

        final String text = list.get(position);
        Button button1 = (Button)convertView.findViewById(R.id.insert);
        Button button2 = (Button)convertView.findViewById(R.id.out);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), text + "가 추가되었습니다.", Toast.LENGTH_SHORT).show();
                sharedPreferences = context.getSharedPreferences("utensillist",context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                button1.setEnabled(false);
                button2.setEnabled(true);
//                editor.putint(text,1);
                editor.putBoolean(text,true);
                editor.commit();

            }
        });
        final String text2 = list.get(position);
//        Button button2 = (Button)convertView.findViewById(R.id.out);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), text2 + "가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                sharedPreferences = context.getSharedPreferences("utensillist",context.MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit();
//                editor.putint(text,1);
                button1.setEnabled(true);
                button2.setEnabled(false);
                editor.putBoolean(text,false);
                editor.commit();
            }
        });



        return convertView;
    }

    class ViewHolder{
        public TextView label;
    }

}

