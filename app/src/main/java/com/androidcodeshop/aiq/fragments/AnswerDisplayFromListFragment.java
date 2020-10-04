package com.androidcodeshop.aiq.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AnswerDisplayFromListFragment extends FullScreenBottomSheetDialogFragment {

    private final QuestionAnswerModel question;

    public AnswerDisplayFromListFragment(final QuestionAnswerModel question) {
        super();
        this.question = question;
    }


    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        setRetainInstance(true);
        final View view = inflater.inflate(R.layout.answer_display, container, false);
        final TextView ques = view.findViewById(R.id.question_label);
        ques.setText(question.getQuestion());
        final TextView ans = view.findViewById(R.id.answer_label);
        ans.setText(question.getAnswer());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MobileAds.initialize(getContext());
        final AdView mAdView = view.findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        final Button doneButton = view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(v -> dismiss());

    }


}
