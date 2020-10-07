package com.example.encuestadepoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.encuestadepoo.adapter.QuestionnaireAdapter;
import com.example.encuestadepoo.adapter.QuestionnaireListener;
import com.example.encuestadepoo.model.Questionnaire;

public class ResultsActivity extends AppCompatActivity implements QuestionnaireListener {
    private Questionnaire questionnaire;
    private RecyclerView recycler_view_correctquestions,mRecyclerViewgetwrongquestions;
    private Button mButtonContinue;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        questionnaire = (Questionnaire) getIntent().getSerializableExtra("questions");
        bindViews();
        setClickListeners();
        setupRecyclersView();
        Log.i("Results", "Correct questions: " + questionnaire.getCorrectQuestions());
        Log.i("Results", "Wrong questions: " + questionnaire.getWrongQuestions().size());
    }
    private void setClickListeners() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mButtonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ResultsActivity.this, Finish.class);
                intent.putExtra("questions", questionnaire);
                startActivity(intent);
            }
        });

    }
    private void setupRecyclersView() {
        recycler_view_correctquestions.setAdapter(new QuestionnaireAdapter(questionnaire.getCorrectQuestions(),this, false));
        mRecyclerViewgetwrongquestions.setAdapter(new QuestionnaireAdapter(questionnaire.getWrongQuestions(),this, false));
    }
    private void bindViews() {
        recycler_view_correctquestions=findViewById(R.id.recycler_view_correctquestions);
        mRecyclerViewgetwrongquestions=findViewById(R.id.recycler_view_wrongquestions);
        mToolbar=findViewById(R.id.toolbar_main_activity);
        mButtonContinue=findViewById(R.id.button_continue);
    }
    @Override
    public void setAnswer(boolean isChecked, int position) {
    }
}