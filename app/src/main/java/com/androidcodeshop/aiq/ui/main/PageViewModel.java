package com.androidcodeshop.aiq.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidcodeshop.aiq.Questions;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

public class PageViewModel extends AndroidViewModel {

    private static final String TAG = "PageViewModel";
    private ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    /**
     * This method maps the Questions and Answer according to fargment index
     */
    public LiveData<QuestionAnswerModel> questionAnswerModelLiveData = Transformations.map(mIndex, input -> {
        Log.i(TAG, "apply: input" + input);
        if (input <= questionAnswerModels.size() - 1)
            return questionAnswerModels.get(input);
        else return new QuestionAnswerModel(0, "NA", "NA");
    });

    public PageViewModel(@NonNull Application application) {
        super(application);
        questionAnswerModels.addAll(Questions.getInstance());
    }

    void setIndex(int index) {
        mIndex.setValue(index);
    }


    public LiveData<QuestionAnswerModel> getQuestionAnswers() {
        return questionAnswerModelLiveData;
    }
}