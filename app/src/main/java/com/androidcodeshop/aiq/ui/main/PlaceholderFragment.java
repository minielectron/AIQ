package com.androidcodeshop.aiq.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.androidcodeshop.aiq.activities.MainActivity;
import com.androidcodeshop.aiq.interfaces.ShowSnackBar;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.androidcodeshop.aiq.room.MyDatabase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    private Unbinder unbinder;
    @BindView(R.id.bookmark_ib)
    ImageButton bookmarkIb;

    private PageViewModel pageViewModel;
    private ShowSnackBar showSnackBar;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    public PlaceholderFragment() {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        showSnackBar = (MainActivity) context;
    }

    static PlaceholderFragment newInstance(final int index) {
        final PlaceholderFragment fragment = new PlaceholderFragment();
        final Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @SuppressLint("HardwareIds")
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 0;
        if (null != getArguments()) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        Log.i(TAG, "onCreate: index" + index);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        if (null != firebaseAuth.getCurrentUser()) {
            firebaseUser = firebaseAuth.getCurrentUser();
            databaseReference = firebaseDatabase.getReference().child("users").child(firebaseUser.getUid()).child(getContext().getString(R.string.bookmarked_ques));
        }
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView question = root.findViewById(R.id.question_label);
        final TextView answer = root.findViewById(R.id.answer_label);

        MobileAds.initialize(getContext());
        final AdView mAdView = root.findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        pageViewModel.getQuestionAnswers().observe(getViewLifecycleOwner(), page -> {
            question.setText(page.getQuestion());
            answer.setText(String.format(getString(R.string.answer), page.getAnswer()));
            questionNo.setText(String.valueOf(page.getQuestionNumber()));
            bookmarkIb.setImageResource(R.drawable.ic_bookmark_border_white_24dp);
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
        if (null == FirebaseAuth.getInstance().getCurrentUser()) {
            Toast.makeText(getContext(), "Login to bookmark!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            // reinitialize because oncreate is called once
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseAuth = FirebaseAuth.getInstance();
            firebaseUser = firebaseAuth.getCurrentUser();
            databaseReference = firebaseDatabase.getReference().child("users").child(firebaseUser.getUid()).child(getContext().getString(R.string.bookmarked_ques));
        }

        final int quesNum = Integer.valueOf(questionNo.getText().toString());
        final QuestionAnswerModel currentQuestion = MainActivity.questionAnswerModelArrayList.get(quesNum - 1);
        databaseReference.child(String.valueOf(quesNum)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                if (null != dataSnapshot.getValue()) {
                    currentQuestion.setBookmarked((dataSnapshot.getValue(QuestionAnswerModel.class).getBookmarked() + 1) % 2);
                    if (1 == currentQuestion.getBookmarked()) {
                        showSnackBar.showSnack("Added in Bookmark");
                    } else {
                        showSnackBar.showSnack("Removed From Bookmark");
                    }
                } else {
                    showSnackBar.showSnack("Added in Bookmark");
                    currentQuestion.setBookmarked(1);
                }
                databaseReference.child(String.valueOf(quesNum)).setValue(currentQuestion);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}