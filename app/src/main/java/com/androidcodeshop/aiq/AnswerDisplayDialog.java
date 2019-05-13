package com.androidcodeshop.aiq;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import electrophile.mutils.fragments.FullScreenBottomSheetDialogFragment;

public class AnswerDisplayDialog extends FullScreenBottomSheetDialogFragment {
    AnswerDisplayDialog answerDisplayDialog = null;

    public AnswerDisplayDialog() {
        super();
    }

    public AnswerDisplayDialog getInstance(int page) {

        answerDisplayDialog = new AnswerDisplayDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("page", page);
        setArguments(bundle);
        return answerDisplayDialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        TextView ques = view.findViewById(R.id.question_label);
        ques.setText(Questions.getInstance().get(getArguments().getInt("page")).getQuestion());
        TextView ans = view.findViewById(R.id.answer_label);
        ans.setText(Questions.getInstance().get(getArguments().getInt("page")).getAnswer());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button doneButton = view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(v -> dismiss());

    }


}
