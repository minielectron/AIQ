package com.androidcodeshop.aiq.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class QuestionListAdapter extends BaseAdapter {

    private ArrayList<QuestionAnswerModel> questionAnswerModel; // original list
    private ArrayList<QuestionAnswerModel> questionAnswerModelCopy = new ArrayList<>(); // copy list
    private Context context;

    public QuestionListAdapter(ArrayList<QuestionAnswerModel> questionAnswerModel, Context context) {
        this.questionAnswerModel = questionAnswerModel;
        questionAnswerModelCopy.addAll(questionAnswerModel);
        this.context = context;
    }

    @Override
    public int getCount() {
        return questionAnswerModelCopy == null ? 0 : questionAnswerModelCopy.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            //will be called once to fetch the id not multiple times
            convertView = LayoutInflater.from(context).inflate(R.layout.question_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else holder = (ViewHolder) convertView.getTag();
        holder.question.setText(questionAnswerModelCopy.get(position).getQuestion());
        Log.i(TAG, "getView: " + questionAnswerModelCopy.get(position).getQuestionNumber());
        holder.qno.setText(String.valueOf(questionAnswerModelCopy.get(position).getQuestionNumber()));
        return convertView;
    }

    public void filter(String queryText) {
        questionAnswerModelCopy.clear();
        if (queryText.isEmpty()) {
            questionAnswerModelCopy.addAll(questionAnswerModel);
        } else {
            for (QuestionAnswerModel question : questionAnswerModel) {
                if (question.getQuestion().toLowerCase().contains(queryText.toLowerCase())) {
                    questionAnswerModelCopy.add(question);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class ViewHolder {

        TextView question, qno;

        ViewHolder(View view) {
            question = view.findViewById(R.id.question_label);
            qno = view.findViewById(R.id.question_number);
        }
    }
}
