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

import electrophile.mutils.fragments.FullScreenBottomSheetDialogFragment;

public class AnswerDisplayFromListFragment extends FullScreenBottomSheetDialogFragment {

    private QuestionAnswerModel question;

    public AnswerDisplayFromListFragment(QuestionAnswerModel question) {
        super();
        this.question = question;
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
        ques.setText(question.getQuestion());
        TextView ans = view.findViewById(R.id.answer_label);
        ans.setText(question.getAnswer());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MobileAds.initialize(getContext(), getString(R.string.ad_app_id));
        AdView mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
        Button doneButton = view.findViewById(R.id.doneButton);
        doneButton.setOnClickListener(v -> dismiss());

    }


}
