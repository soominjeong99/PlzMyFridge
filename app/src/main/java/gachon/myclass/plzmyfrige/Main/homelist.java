package gachon.myclass.plzmyfrige.Main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import gachon.myclass.plzmyfrige.R;

public class homelist extends Fragment {
    TextView frigelist;
    TextView utensillist;
    Button clearbtn;

    @Nullable

    @Override
    public void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
    }

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.homelist, container, false);
        SharedPreferences shef = this.getActivity().getSharedPreferences("frigelist", getContext().MODE_PRIVATE);
        SharedPreferences uhef = this.getActivity().getSharedPreferences("utensillist", getContext().MODE_PRIVATE);
//        클리어 버튼
        clearbtn = (Button) v.findViewById(R.id.clearbtn);
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = shef.edit();
                SharedPreferences.Editor edit2 = uhef.edit();
                edit2.clear();
                edit2.commit();
                edit.clear();
                edit.commit();
                Toast.makeText(v.getContext(),   "내 바구니를 전부 비웠습니다.", Toast.LENGTH_SHORT).show();

            }

        });
//        sharedpreference 불러오기
        int i =2;
//        Boolean sweetpotato = shef.getBoolean(i,false);
//        homelist = (TextView) v.findViewById(R.id.homelistview);
//        homelist.setText(sweetpotato.toString());
        frigelist = (TextView) v.findViewById(R.id.frigelistview);
        utensillist = (TextView) v.findViewById(R.id.utensillistview);
        Map<String,?> map = shef.getAll();
        Map<String,?> map2 = uhef.getAll();



//        Collection<String> key = map.keySet();
//        Collection<String> value = map.values();
//        homelist.setText(key.toString() + value.toString());

//        True인 것만 받기
        String val ="";
        Set<String> keys = map.keySet();
        for (String KEY : keys) {
            if (map.get(KEY).toString() == "true") {
                val += KEY + " (이)가 가방안에 있습니다. " + "\n";
            }
        }
        String val2 ="";
        Set<String> keys2 = map2.keySet();
        for (String KEY2 : keys2) {
            if (map2.get(KEY2).toString() == "true") {
                val2 += KEY2 + " (이)가 가방안에 있습니다. " + "\n";
            }
        }

//        전부다받기
//        String val ="";
//        Set<String> keys = map.keySet();
//        for (String KEY : keys) {
//                val += KEY + " : " + map.get(KEY) + "\n";
//            }
        frigelist.setText(val);
        utensillist.setText(val2);

//        homelist.setText(map.keySet().toString());
//        가지고 있는 냉장고 재료 이진법으로 가져오기
        String val3="";
        for (String KEY : keys) {
            if (map.get(KEY).toString() == "true") {
                val3 +="1";
            }else{
                val3 +="0";
            }
        }

//        정렬후 val4에 이진수 string으로 표현
        List textc = new ArrayList(keys);
        Collections.sort(textc);
        Set<String> frigeset = new HashSet<>(textc) ;
        String val4="";
        for (i=0;i<textc.size();i++) {
            if (map.get(textc.get(i).toString()).toString() == "true") {
                val4 +="1";
            }else{
                val4 +="0";
            }
        }
//        만든 이진수 string을 split
        String[] ten = val4.split("");

//        usten 십진법으로 변환
        int usten = 0;
        for (i=0;i<textc.size();i++) {
            if (map.get(textc.get(i).toString()).toString() == "true") {
                usten +=Math.pow(2,i);
            }
        }

//      nww 거꾸로 뒤집기
        StringBuffer sb = new StringBuffer(val4);
        String reversed = sb.reverse().toString();
        frigelist.setText(val+"2진수 : "+reversed+"\n"+"10진수 : "+ Integer.toString(usten));
//        frigelist.setText(val3);




        return v;

    }
}


