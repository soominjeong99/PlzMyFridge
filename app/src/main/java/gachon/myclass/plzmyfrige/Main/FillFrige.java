package gachon.myclass.plzmyfrige.Main;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import gachon.myclass.plzmyfrige.R;

import static android.content.Context.MODE_PRIVATE;

public class FillFrige extends Fragment {
    List<String> list;          // 재료 리스트 보여주기
    ListView listView;          // 검색을 보여줄 리스트변수
    EditText editSearch;        // 검색어를 입력할 Input 창
    gachon.myclass.plzmyfrige.Main.frige_SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    ArrayList<String> arraylist;
    public SharedPreferences sharedPreferences;

    @Nullable

    @Override
    public void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
    }
    @Override



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fillfrige, container, false);
        list = new ArrayList<String>();
        settingList();
        editSearch = (EditText) v.findViewById(R.id.editSearch);
        listView = (ListView) v.findViewById(R.id.listView);
        sharedPreferences = getContext().getSharedPreferences("frigelist",MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();

        for (int i=0; i< list.size();i++) {
            String str = list.get(i).toString();
            if (sharedPreferences.getBoolean(str, false) == true) {
            } else {
                editor.putBoolean(str, false);
                editor.commit();
            }
        }

        editor.commit();




        // 리스트를 생성한다


        // 검색에 사용할 데이터을 미리 저장한다.



        arraylist = new ArrayList<String>();
        arraylist.addAll(list);


        adapter = new gachon.myclass.plzmyfrige.Main.frige_SearchAdapter(list, getActivity());

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);


        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);

            }
        });

        return v;

    }

    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();

    }
    private void settingList() {
        list.add("간장");
        list.add("갈치");
        list.add("계란");
        list.add("고추");
        list.add("고추장");
        list.add("고춧가루");
        list.add("다진마늘");
        list.add("닭가슴살");
        list.add("당근");
        list.add("대파");
        list.add("돼지고기");
        list.add("맛술");
        list.add("무");
        list.add("물엿");
        list.add("밀가루");
        list.add("밥");
        list.add("배추");
        list.add("부추");
        list.add("새우");
        list.add("식용유");
        list.add("액젓");
        list.add("양파");
        list.add("참기름");
        list.add("카레 가루");
        Collections.sort(list);
    }


}



