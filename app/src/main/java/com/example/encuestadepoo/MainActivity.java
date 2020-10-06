package com.example.encuestadepoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.encuestadepoo.adapter.QuestionnaireAdapter;
import com.example.encuestadepoo.adapter.QuestionnaireListener;
import com.example.encuestadepoo.model.Question;
import com.example.encuestadepoo.model.Questionnaire;

public class MainActivity extends AppCompatActivity implements QuestionnaireListener {

    private Questionnaire questionnaire;
    private RecyclerView mRecyclerView;
    private Button mButtonContinue;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupRecyclerView();
        setClickListeners();

    }

    private void setClickListeners() {
        mButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void bindViews() {
        mRecyclerView = findViewById(R.id.recycler_view_questions);
        mButtonContinue = findViewById(R.id.button_continue);
        mToolbar = findViewById(R.id.toolbar_main_activity);
    }

    private void setupRecyclerView() {

        questionnaire = createQuestionnaire();

        mRecyclerView.setAdapter(new QuestionnaireAdapter(questionnaire.getQuestions(), this));
    }


    private Questionnaire createQuestionnaire() {

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.addQuestion(new Question(getString(R.string.question_one), true));
        questionnaire.addQuestion(new Question(getString(R.string.question_two), false));
        questionnaire.addQuestion(new Question(getString(R.string.question_three), true));
        questionnaire.addQuestion(new Question(getString(R.string.question_four), true));
        questionnaire.addQuestion(new Question(getString(R.string.question_five), false));
        questionnaire.addQuestion(new Question(getString(R.string.question_six), true));
        questionnaire.addQuestion(new Question(getString(R.string.question_seven), true));
        questionnaire.addQuestion(new Question(getString(R.string.question_eight), true));

        return questionnaire;
    }

    @Override
    public void setAnswer(boolean isChecked, int position) {
        questionnaire.getQuestions().get(position).setUserAnswer(isChecked);

        Log.i("MainActivity", "Question: " + position + " isChecked: " + isChecked);

        Log.i("MainActivity", "Correct questions: " + questionnaire.getCorrectQuestions().size());
        Log.i("MainActivity", "Wrong questions: " + questionnaire.getWrongQuestions().size());
    }
}