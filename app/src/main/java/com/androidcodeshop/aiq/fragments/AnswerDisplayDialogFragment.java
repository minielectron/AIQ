package com.androidcodeshop.aiq.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidcodeshop.aiq.utils.Questions;
import com.androidcodeshop.aiq.R;

import electrophile.mutils.fragments.FullScreenBottomSheetDialogFragment;

import static android.content.ContentValues.TAG;

public class AnswerDisplayDialogFragment extends FullScreenBottomSheetDialogFragment {
    private static AnswerDisplayDialogFragment answerDisplayDialogFragment = null;

    public AnswerDisplayDialogFragment() {
        super();
    }

    private static int page = 0;

    public static AnswerDisplayDialogFragment getInstance(int page) {
        answerDisplayDialogFragment = new AnswerDisplayDialogFragment();
        AnswerDisplayDialogFragment.page = page;
        return answerDisplayDialogFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.answer_display, container, false);
        Log.i(TAG, "onCreateView: page " + page);
        TextView ques = view.findViewById(R.id.question_label);
        ques.setText(Questions.getInstance().get(page).getQuestion());
        TextView ans = view.findViewById(R.id.answer_label);
        ans.setText(Questions.getInstance().get(page).getAnswer());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button doneButton = view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(v -> dismiss());

    }


}
