package com.androidcodeshop.aiq.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.ShowSnackBar;
import com.androidcodeshop.aiq.activities.BookmarkedListActivity;
import com.androidcodeshop.aiq.activities.MainActivity;
import com.androidcodeshop.aiq.room.MyDatabase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.Executors;

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
    private ShowSnackBar showSnackBar;
    public PlaceholderFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        showSnackBar = (MainActivity)context;
    }

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
        test_device = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
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

        MobileAds.initialize(getContext(), "ca-app-pub-9503287726630019~3895030365");
        mAdView = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(test_device)
                .build();
        mAdView.loadAd(adRequest);

        Log.d(TAG, "onCreateView: " + test_device);
        pageViewModel.getQuestionAnswers().observe(this, page -> {
            question.setText(page.getQuestion());
            answer.setText(String.format(getString(R.string.answer), page.getAnswer()));
            questionNo.setText(String.valueOf(page.getQuestionNumber()));

            if (database.aiqDao().getAllQuestionAnswers().get(page.getQuestionNumber()-1).getBookmarked() == 1) {
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
    void onViewClicked() {
        int quesNum = Integer.valueOf(questionNo.getText().toString());
        Log.d(TAG, "run: unbookmarked success " + quesNum);
        bookmarkIb.setVisibility(View.GONE);
        showSnackBar.showSnack();
        Executors.newSingleThreadExecutor().execute(() -> database.aiqDao().replaceBookmark(quesNum, (database.aiqDao().getAllQuestionAnswers().get(quesNum-1).getBookmarked()+1)%2));
    }
}