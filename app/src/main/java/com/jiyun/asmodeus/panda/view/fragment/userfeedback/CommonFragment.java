package com.jiyun.asmodeus.panda.view.fragment.userfeedback;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.asmodeus.panda.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment {


    private CheckBox myquestion_cb1;
    private CheckBox myquestion_cb2;
    private CheckBox myquestion_cb3;
    private CheckBox myquestion_cb4;
    private CheckBox myquestion_cb5;
    private CheckBox myquestion_cb6;
    private EditText myquestion_content;
    private EditText myquestion_contact;
    private TextView myquestion_submit_btn;

    public CommonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        myquestion_cb1 = (CheckBox) view.findViewById(R.id.myquestion_cb1);
        myquestion_cb2 = (CheckBox) view.findViewById(R.id.myquestion_cb2);
        myquestion_cb3 = (CheckBox) view.findViewById(R.id.myquestion_cb3);
        myquestion_cb4 = (CheckBox) view.findViewById(R.id.myquestion_cb4);
        myquestion_cb5 = (CheckBox) view.findViewById(R.id.myquestion_cb5);
        myquestion_cb6 = (CheckBox) view.findViewById(R.id.myquestion_cb6);
        myquestion_content = (EditText) view.findViewById(R.id.myquestion_content);
        myquestion_contact = (EditText) view.findViewById(R.id.myquestion_contact);
        myquestion_submit_btn = (TextView) view.findViewById(R.id.myquestion_submit_btn);
        myquestion_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
                Toast.makeText(getContext(), "提交成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void submit() {
        // validate
        String content = myquestion_content.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(getContext(), "请留下您的宝贵意见", Toast.LENGTH_SHORT).show();
            return;
        }

        String contact = myquestion_contact.getText().toString().trim();
        if (TextUtils.isEmpty(contact)) {
            Toast.makeText(getContext(), "请输入您的邮箱，方便我们及时给您回复", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!myquestion_cb1.isChecked()&&!myquestion_cb2.isChecked()&&!myquestion_cb3.isChecked()&&!myquestion_cb4.isChecked()&&!myquestion_cb5.isChecked()&&!myquestion_cb6.isChecked()) {
            Toast.makeText(getContext(), "请勾选相关问题", Toast.LENGTH_SHORT).show();
        }


    }
}
