package com.androidcodeshop.aiq.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.androidcodeshop.aiq.Questions;
import com.androidcodeshop.aiq.R;

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

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 0;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        Log.i(TAG, "onCreate: index" + index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView question = root.findViewById(R.id.question_label);
        final TextView answer = root.findViewById(R.id.answer_label);
        pageViewModel.getQuestionAnswers().observe(this, s -> {
            assert s != null;
            question.setText(s.getQuestion());
            answer.setText(String.format("Answer : %s", s.getAnswer()));
            questionNo.setText(String.valueOf(s.getQuestionNumber()));

            if (s.isBookmarked()) {
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
        if (Questions.getInstance().get(Integer.valueOf(questionNo.getText().toString())).isBookmarked()) {
            bookmarkIb.setImageResource(R.drawable.ic_bookmark_border_white_24dp);
            Toast.makeText(getContext(), "Un-Bookmarked", Toast.LENGTH_SHORT).show();
            Questions.getInstance().get(Integer.valueOf(questionNo.getText().toString())).setBookmarked(false);

        } else {
            Toast.makeText(getActivity(), questionNo.getText() + "-Bookmarked Successfully", Toast.LENGTH_SHORT).show();
            bookmarkIb.setImageResource(R.drawable.ic_bookmark_gray_24dp);
            Questions.getInstance().get(Integer.valueOf(questionNo.getText().toString())).setBookmarked(true);
        }
    }
}