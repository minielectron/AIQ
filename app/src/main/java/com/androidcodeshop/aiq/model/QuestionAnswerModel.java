package com.androidcodeshop.aiq.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
@Entity(tableName = "AIQ_TABLE")
public class QuestionAnswerModel implements Parcelable {

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

    protected QuestionAnswerModel(Parcel in) {
        question = in.readString();
        answer = in.readString();
        questionNumber = in.readInt();
        bookmarked = in.readInt();
    }

    public static final Creator<QuestionAnswerModel> CREATOR = new Creator<QuestionAnswerModel>() {
        @Override
        public QuestionAnswerModel createFromParcel(Parcel in) {
            return new QuestionAnswerModel(in);
        }

        @Override
        public QuestionAnswerModel[] newArray(int size) {
            return new QuestionAnswerModel[size];
        }
    };

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

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(answer);
        dest.writeInt(questionNumber);
        dest.writeInt(bookmarked);
    }
}
