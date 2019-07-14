package com.androidcodeshop.aiq.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "AIQ_TABLE")
public class QuestionAnswerModel {

    @NonNull
    private String question;
    @NonNull
    private String answer;
    @PrimaryKey

    private int questionNumber;
    private int bookmarked = 0; // 0 indicates non bookmarked

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
