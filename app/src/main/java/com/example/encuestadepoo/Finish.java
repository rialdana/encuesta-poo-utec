package com.example.encuestadepoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.encuestadepoo.adapter.QuestionnaireListener;
import com.example.encuestadepoo.model.Questionnaire;

import java.text.DecimalFormat;

public class Finish extends AppCompatActivity implements QuestionnaireListener {

    private Toolbar mToolbar;
    private TextView ProcetajeCorectas, PorcentajeIncorectas, MensajeView;
    private Questionnaire questionnaire;
    public  int TodasPreguntas, PreguntasCorectas,PreguntasIncorectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        bindViews();
        setClickListeners();
        ProcetajeCorectas = findViewById(R.id.textView5);
        PorcentajeIncorectas = findViewById(R.id.textView7);
        MensajeView= findViewById(R.id.Mensaje);

        questionnaire = (Questionnaire) getIntent().getSerializableExtra("questions");

        Log.i("Results", "all questions: " + questionnaire.getQuestions().size());
        Log.i("Results", "Correct questions: " + questionnaire.getCorrectQuestions().size());
        Log.i("Results", "Wrong questions: " + questionnaire.getWrongQuestions().size());

        TodasPreguntas = questionnaire.getQuestions().size();
        PreguntasCorectas = questionnaire.getCorrectQuestions().size();
        PreguntasIncorectas = questionnaire.getWrongQuestions().size();

        DecimalFormat df = new DecimalFormat("0.00");
        double result1 = (PreguntasCorectas*100);
        double result2 = (PreguntasIncorectas*100);
        Log.i("corectas %", "resultado: "+ df.format(result1/TodasPreguntas));
        Log.i("Incorectas %", "resultado: "+ df.format(result2/TodasPreguntas));
        ProcetajeCorectas.setText(df.format(result1/TodasPreguntas)+ " %");
        PorcentajeIncorectas.setText(df.format(result2/TodasPreguntas)+" %");


    }



    private void setClickListeners() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void bindViews() {

        mToolbar=findViewById(R.id.toolbar_main_activity2);

    }

    @Override
    public void setAnswer(boolean isChecked, int position) {

    }
}