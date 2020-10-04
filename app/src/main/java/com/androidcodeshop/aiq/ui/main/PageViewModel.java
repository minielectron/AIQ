package com.androidcodeshop.aiq.ui.main;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.androidcodeshop.aiq.activities.MainActivity;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

public class PageViewModel extends AndroidViewModel {

    private static final String TAG = "PageViewModel";
    private final ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
    private final MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    /**
     * This method maps the Questions and Answer according to fargment index
     */
    private final LiveData<QuestionAnswerModel> questionAnswerModelLiveData = Transformations.map(mIndex, input -> {
        Log.i(TAG, "apply: input" + input);
        if (input <= questionAnswerModels.size() - 1) {
            return questionAnswerModels.get(input);
        } else {
            return new QuestionAnswerModel(0, "NA", "NA");
        }
    });

    public PageViewModel(@NonNull final Application application) {
        super(application);
        updateDbData();
    }

    private void updateDbData() {
        if (null != MainActivity.questionAnswerModelArrayList) {
            questionAnswerModels.addAll(MainActivity.questionAnswerModelArrayList);
        }
    }

    void setIndex(final int index) {
        mIndex.setValue(index);
    }

    LiveData<QuestionAnswerModel> getQuestionAnswers() {
        return questionAnswerModelLiveData;
    }
}