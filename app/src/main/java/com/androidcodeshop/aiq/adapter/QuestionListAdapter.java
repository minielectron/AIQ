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

    private final ArrayList<QuestionAnswerModel> questionAnswerModel; // original list
    private final ArrayList<QuestionAnswerModel> questionAnswerModelCopy = new ArrayList<>(); // copy list
    private final Context context;

    public QuestionListAdapter(final ArrayList<QuestionAnswerModel> questionAnswerModel, final Context context) {
        this.questionAnswerModel = questionAnswerModel;
        questionAnswerModelCopy.addAll(questionAnswerModel);
        this.context = context;
    }

    @Override
    public int getCount() {
        return questionAnswerModelCopy.size();
    }

    @Override
    public Object getItem(final int position) {
        return null;
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final ViewHolder holder;
        if (null == convertView) {
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

    public void filter(final String queryText) {
        questionAnswerModelCopy.clear();
        if (queryText.isEmpty()) {
            questionAnswerModelCopy.addAll(questionAnswerModel);
        } else {
            for (final QuestionAnswerModel question : questionAnswerModel) {
                if (question.getQuestion().toLowerCase().contains(queryText.toLowerCase())) {
                    questionAnswerModelCopy.add(question);
                }
            }
        }
        notifyDataSetChanged();
    }

    private static class ViewHolder {

        TextView question, qno;

        ViewHolder(final View view) {
            question = view.findViewById(R.id.question_label);
            qno = view.findViewById(R.id.question_number);
        }
    }
}
