package com.example.encuestadepoo.model;

import java.io.Serializable;

public class Question implements Serializable {

    private String question;
    private boolean correctAnswer;
    private boolean userAnswer;

    public Question(String question, boolean correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer == userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
