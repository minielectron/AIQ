package com.androidcodeshop.aiq.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.activities.MainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static android.content.ContentValues.TAG;

public class AnswerDisplayDialogFragment extends FullScreenBottomSheetDialogFragment {

    public AnswerDisplayDialogFragment() {
        super();
    }

    private static int page = 0;

    public static AnswerDisplayDialogFragment getInstance(int page) {
        AnswerDisplayDialogFragment answerDisplayDialogFragment = new AnswerDisplayDialogFragment();
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
        ques.setText(MainActivity.questionAnswerModelArrayList.get(page).getQuestion());
        TextView ans = view.findViewById(R.id.answer_label);
        ans.setText(MainActivity.questionAnswerModelArrayList.get(page).getAnswer());
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
