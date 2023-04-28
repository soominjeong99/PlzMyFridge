package gachon.myclass.plzmyfrige.Main;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import gachon.myclass.plzmyfrige.R;

public class Cartpage extends Fragment {
    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItem;

    EditText editText1;
    Button addButton,deleteButton;

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cartpage, container,false);


        editText1 = view.findViewById(R.id.editText1);
        addButton = view.findViewById(R.id.addButton);
        deleteButton = view.findViewById(R.id.deleteButton);
        listItem = new ArrayList<String>();
        //클릭 시 아이템 추가
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count;
                count = adapter.getCount();
                listItem.add(editText1.getText().toString()+ (count + 1));
                adapter.notifyDataSetChanged();
                editText1.setText("");
            }

        });
        //클릭 시 아이템 삭제
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray checkedItems = list.getCheckedItemPositions();
                int count = adapter.getCount();

                for(int i =count-1;i>=0;i--){
                    if(checkedItems.get(i)){
                        listItem.remove(i);
                    }
                }
                //상태 초기화
                list.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, listItem);
        list = view.findViewById(R.id.listView1);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);

        return view;
    }


}

