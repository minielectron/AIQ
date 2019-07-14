package com.androidcodeshop.aiq.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.util.Log;

import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.androidcodeshop.aiq.room.MyDatabase;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class PageViewModel extends AndroidViewModel {

    private static final String TAG = "PageViewModel";
    private ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private MyDatabase database = MyDatabase.getDatabase(getApplication());
    /**
     * This method maps the Questions and Answer according to fargment index
     */
    private LiveData<QuestionAnswerModel> questionAnswerModelLiveData = Transformations.map(mIndex, input -> {
        Log.i(TAG, "apply: input" + input);
        if (input <= questionAnswerModels.size() - 1)
            return questionAnswerModels.get(input);
        else return new QuestionAnswerModel(0, "NA", "NA");
    });

    public PageViewModel(@NonNull Application application) {
        super(application);
        updateDbData();
    }

    public void updateDbData() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                questionAnswerModels.addAll(database.aiqDao().getAllQuestionAnswers());
            }
        });
    }

    void setIndex(int index) {
        mIndex.setValue(index);
    }

    LiveData<QuestionAnswerModel> getQuestionAnswers() {
        return questionAnswerModelLiveData;
    }
}