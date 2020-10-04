package com.androidcodeshop.aiq.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<QuestionAnswerModel> questionAnswerModels;

    public SectionsPagerAdapter(final Context context, final FragmentManager fm, final ArrayList<QuestionAnswerModel> questionAnswerModelArrayList) {
        super(fm);
        this.questionAnswerModels = questionAnswerModelArrayList;
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return PlaceholderFragment.newInstance(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        return "Question : " + (position + 1);
    }

    @Override
    public int getCount() {
        return questionAnswerModels.size();
    }
}