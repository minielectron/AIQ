package com.androidcodeshop.aiq.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidcodeshop.aiq.utils.Questions;
import com.androidcodeshop.aiq.R;

public class GotoPageFragmentDialogFragment extends DialogFragment {
    OnGotoFragmentLister fragmentLister;
    public GotoPageFragmentDialogFragment() {
        super();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentLister = (OnGotoFragmentLister) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goto_layout,container,false);
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText number = view.findViewById(R.id.page_number_et);
        number.setHint("page(1-"+ Questions.getNumberOfQuestion()+")");
        Button button = view.findViewById(R.id.goto_btn);
        Button lastButton = view.findViewById(R.id.last_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(number.getText()))
                    Toast.makeText(getContext(), "Plese enter a page number", Toast.LENGTH_SHORT).show();
                else fragmentLister.gotoPage(Integer.valueOf(number.getText().toString()));
            }
        });
        lastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentLister.gotoPage(Questions.getNumberOfQuestion());
            }
        });
    }

    public interface OnGotoFragmentLister{
        void gotoPage(int n);
    }

}
