package com.androidcodeshop.aiq.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
@Entity(tableName = "AIQ_TABLE")
public class QuestionAnswerModel {

    @NonNull
    private String question;
    @NonNull
    private String answer;
    @PrimaryKey

    private int questionNumber;
    private int bookmarked = 0; // 0 indicates non bookmarked

    @Ignore
    public QuestionAnswerModel() {
        // for room database to write the object to the realtime db, it is mandatory to use this
    }

    public QuestionAnswerModel(int questionNumber, String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.questionNumber = questionNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    @NonNull
    public String getQuestion() {
        return question;
    }

    @NonNull
    public String getAnswer() {
        return answer;
    }

    public int getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(int bookmarked) {
        this.bookmarked = bookmarked;
    }
}
