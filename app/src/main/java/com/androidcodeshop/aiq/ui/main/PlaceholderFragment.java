package com.androidcodeshop.aiq.ui.main;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.room.MyDatabase;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String TAG = "PlaceholderFragment";
    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.question_no)
    TextView questionNo;
    Unbinder unbinder;
    @BindView(R.id.bookmark_ib)
    ImageButton bookmarkIb;
    private MyDatabase database;

    private PageViewModel pageViewModel;
    private AdView mAdView;
    private String test_device;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @SuppressLint("HardwareIds")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test_device = Settings.Secure.getString(getContext().getContentResolver(),Settings.Secure.ANDROID_ID);
        database = MyDatabase.getDatabase(getContext());
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 0;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        Log.i(TAG, "onCreate: index" + index);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView question = root.findViewById(R.id.question_label);
        final TextView answer = root.findViewById(R.id.answer_label);

        MobileAds.initialize(getContext(), "ca-app-pub-9503287726630019~6070601719");
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(test_device)
                .build();
        mAdView.loadAd(adRequest);

        Log.d(TAG, "onCreateView: "+test_device);
        pageViewModel.getQuestionAnswers().observe(this, s -> {
            question.setText(s.getQuestion());
            answer.setText(String.format(getString(R.string.answer), s.getAnswer()));
            questionNo.setText(String.valueOf(s.getQuestionNumber()));

            if (s.getBookmarked() == 1) {
                bookmarkIb.setImageResource(R.drawable.ic_bookmark_gray_24dp);
            } else {
                bookmarkIb.setImageResource(R.drawable.ic_bookmark_border_white_24dp);
            }

        });
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bookmark_ib)
    public void onViewClicked() {
        getActivity().runOnUiThread(() -> {
            if (database.aiqDao().getAllQuestionAnswers().get(Integer.valueOf(questionNo.getText().toString())).getBookmarked() == 1) {
                bookmarkIb.setImageResource(R.drawable.ic_bookmark_border_white_24dp);
                Log.d(TAG, "run: unbookmarked success " + questionNo.getText().toString());
                database.aiqDao().replaceBookmark(Integer.valueOf(questionNo.getText().toString()), 0);

            } else {
                Log.d(TAG, "run: bookmarked success " + questionNo.getText().toString());
                bookmarkIb.setImageResource(R.drawable.ic_bookmark_gray_24dp);
                database.aiqDao().replaceBookmark(Integer.valueOf(questionNo.getText().toString()), 1);
            }
        });

    }
}