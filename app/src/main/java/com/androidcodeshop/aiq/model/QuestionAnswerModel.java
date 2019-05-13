package com.androidcodeshop.aiq.model;

public class QuestionAnswerModel {
    private String question ;
    private String answer ;
    private String questionNumber;

    public QuestionAnswerModel(String questionNumber,String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.questionNumber = questionNumber;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
