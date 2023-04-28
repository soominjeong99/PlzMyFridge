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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import gachon.myclass.plzmyfrige.R;

import static android.content.Context.MODE_PRIVATE;

public class FillUtensil extends Fragment {
    List<String> list;          // 재료 리스트 보여주기
    ListView listView;          // 검색을 보여줄 리스트변수
    EditText editSearch;        // 검색어를 입력할 Input 창
    gachon.myclass.plzmyfrige.Main.utensil_SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    ArrayList<String> arraylist;
    public SharedPreferences sharedPreferences;

    @Nullable

    @Override
    public void onCreate(Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        list = new ArrayList<String>();
        settingList();
        sharedPreferences = getContext().getSharedPreferences("utensillist",MODE_PRIVATE);
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





    }

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fillutensil, container, false);

        editSearch = (EditText) v.findViewById(R.id.editSearch);
        listView = (ListView) v.findViewById(R.id.listView);







        // 리스트를 생성한다.


        // 검색에 사용할 데이터을  저장



        arraylist = new ArrayList<String>();
        arraylist.addAll(list);


        adapter = new gachon.myclass.plzmyfrige.Main.utensil_SearchAdapter(list, getActivity());

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
        list.add("후라이팬");
        list.add("뒤집개");
        list.add("집게");
        list.add("가위");
        list.add("식칼");
        list.add("웍");
        list.add("찜기");
        list.add("전자레인지");
        list.add("오븐");
        list.add("석쇠");
        list.add("가스레인지");
        list.add("거품");
        list.add("도마");
        list.add("에어프라이어");
        list.add("키친타올");
        list.add("국자");
        list.add("감자칼");
        list.add("냄비");
        list.add("밀대");
        list.add("채반");
        list.add("bowl");
        list.add("pan");
        list.add("고무장갑");
        list.add("비닐장갑");
        list.add("앞치마");
        list.add("소스통");
        list.add("거름");
        Collections.sort(list);
    }

}



