package com.androidcodeshop.aiq.ui.main;

public class QuestionAnswerModel {
    private String question ;
    private String answer ;

    public QuestionAnswerModel(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
