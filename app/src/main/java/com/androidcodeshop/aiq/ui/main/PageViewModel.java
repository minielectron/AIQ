package com.androidcodeshop.aiq.ui.main;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.androidcodeshop.aiq.Questions;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

class PageViewModel extends ViewModel {

    private static final String TAG = "PageViewModel";
    private ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    /**
     * This method maps the Questions and Answer according to fargment index
     * */
    private LiveData<QuestionAnswerModel> questionAnswerModelLiveData = Transformations.map(mIndex, new Function<Integer, QuestionAnswerModel>() {
        @Override
        public QuestionAnswerModel apply(Integer input) {
            Log.i(TAG, "apply: input"+input);
            if(input <= questionAnswerModels.size()-1)
               return questionAnswerModels.get(input);
            else return new QuestionAnswerModel("0","NA","NA");
        }
    });

    void setIndex(int index) {
        mIndex.setValue(index);
        questionAnswerModels.addAll(Questions.getInstance());
    }


    public LiveData<QuestionAnswerModel> getText() {
        return questionAnswerModelLiveData;
    }
}