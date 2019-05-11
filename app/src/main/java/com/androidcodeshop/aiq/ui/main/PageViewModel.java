package com.androidcodeshop.aiq.ui.main;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.androidcodeshop.aiq.Questions;

import java.util.ArrayList;

class PageViewModel extends ViewModel {

    private static final String TAG = "PageViewModel";
    private ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<QuestionAnswerModel> mText = Transformations.map(mIndex, new Function<Integer, QuestionAnswerModel>() {
        @Override
        public QuestionAnswerModel apply(Integer input) {
            Log.i(TAG, "apply: input"+input);
            if(input <= questionAnswerModels.size()-1)
               return questionAnswerModels.get(input);
            else return new QuestionAnswerModel("NA","NA");
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
        questionAnswerModels.addAll(new Questions().getQuestionsAns());
    }


    public LiveData<QuestionAnswerModel> getText() {
        return mText;
    }
}