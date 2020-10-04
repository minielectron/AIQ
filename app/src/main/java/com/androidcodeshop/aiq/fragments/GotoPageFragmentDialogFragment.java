package com.androidcodeshop.aiq.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidcodeshop.aiq.activities.MainActivity;
import com.androidcodeshop.aiq.utils.Questions;
import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.utils.Utils;

public class GotoPageFragmentDialogFragment extends DialogFragment {
    private OnGotoFragmentLister fragmentLister;
    public GotoPageFragmentDialogFragment() {
        super();
    }

    @Override
    public void onAttach(@NonNull final Context context) {
        super.onAttach(context);
        fragmentLister = (OnGotoFragmentLister) context;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.goto_layout,container,false);
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText number = view.findViewById(R.id.page_number_et);
        number.setHint("page(1-"+ MainActivity.questionAnswerModelArrayList.size()+")");
        final Button button = view.findViewById(R.id.goto_btn);
        final Button lastButton = view.findViewById(R.id.last_btn);
        button.setOnClickListener(v -> {
            if(TextUtils.isEmpty(number.getText())) {
                Toast.makeText(getContext(), "Plese enter a page number", Toast.LENGTH_SHORT).show();
            } else {
                fragmentLister.gotoPage(Integer.valueOf(number.getText().toString()));
            }
            Utils.hideKeyboard(getActivity());
        });
        lastButton.setOnClickListener(v -> {
            fragmentLister.gotoPage(MainActivity.questionAnswerModelArrayList.size());
            Utils.hideKeyboard(getActivity());
        });
    }

    public interface OnGotoFragmentLister{
        void gotoPage(int n);
    }

}
