package com.example.encuestadepoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire implements Serializable {
    private ArrayList<Question> questions;

    public void addQuestion(Question question) {

        if (questions == null) {
            questions = new ArrayList<>();
        }

        questions.add(question);
    }

    public ArrayList<Question> getCorrectQuestions() {
        ArrayList<Question> correctQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (question.isCorrectAnswer()) {
                correctQuestions.add(question);
            }
        }

        return correctQuestions;
    }

    public ArrayList<Question> getWrongQuestions() {
        ArrayList<Question> wrongQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (!question.isCorrectAnswer()) {
                wrongQuestions.add(question);
            }
        }

        return wrongQuestions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
