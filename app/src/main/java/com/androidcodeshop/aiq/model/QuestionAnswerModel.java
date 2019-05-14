package com.androidcodeshop.aiq.model;

public class QuestionAnswerModel {
    private String question;
    private String answer;
    private int questionNumber;
    private boolean bookmarked = false;

    public QuestionAnswerModel(int questionNumber, String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.questionNumber = questionNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        this.bookmarked = bookmarked;
    }
}
