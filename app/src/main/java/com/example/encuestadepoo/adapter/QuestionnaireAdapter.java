package com.example.encuestadepoo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.encuestadepoo.R;
import com.example.encuestadepoo.model.Question;

import java.util.List;

public class QuestionnaireAdapter extends RecyclerView.Adapter<QuestionnaireAdapter.QuestionnaireViewHolder> {

    private List<Question> questions;
    private QuestionnaireListener listener;

    public QuestionnaireAdapter(List<Question> questions, QuestionnaireListener listener) {
        this.questions = questions;
        this.listener = listener;
    }

    @NonNull
    @Override
    public QuestionnaireViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionnaireViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuestionnaireViewHolder holder, int position) {
        holder.bindData(questions.get(position), listener, position);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionnaireViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewQuestion;
        private SwitchCompat switchQuestion;

        public QuestionnaireViewHolder(@NonNull View view) {
            super(view);
            textViewQuestion = view.findViewById(R.id.text_view_question);
            switchQuestion = view.findViewById(R.id.switch_question);
        }

        public void bindData(final Question question, final QuestionnaireListener listener, final int position) {

            textViewQuestion.setText(question.getQuestion());
            switchQuestion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    listener.setAnswer(isChecked, position);
                }
            });

        }
    }
}