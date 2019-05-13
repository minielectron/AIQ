package com.androidcodeshop.aiq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

public class QuestionListAdapter extends BaseAdapter {

    private ArrayList<QuestionAnswerModel> questionAnswerModel;
    private ArrayList<QuestionAnswerModel> questionAnswerModelCopy = new ArrayList<>();
    private Context context;

    public QuestionListAdapter(ArrayList<QuestionAnswerModel> questionAnswerModel, Context context) {
        this.questionAnswerModel = questionAnswerModel;
        questionAnswerModelCopy.addAll(questionAnswerModel);
        this.context = context;
    }

    @Override
    public int getCount() {
        return questionAnswerModel.size();
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
        ViewHolder holder ;
        if(convertView == null){
            //will be called once to fetch the id not multiple times
            convertView = LayoutInflater.from(context).inflate(R.layout.question_list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else holder = (ViewHolder) convertView.getTag();
        holder.question.setText(questionAnswerModel.get(position).getQuestion());
        holder.qno.setText(questionAnswerModel.get(position).getQuestionNumber());
        return convertView;
    }

    public void filter(String queryText) {
        questionAnswerModel.clear();
        if (queryText.isEmpty()) {
            questionAnswerModel.addAll(questionAnswerModelCopy);
        } else {
            for (QuestionAnswerModel question : questionAnswerModelCopy) {
                if (question.getQuestion().toLowerCase().contains(queryText.toLowerCase())) {
                    questionAnswerModel.add(question);
                }
            }
        }
        notifyDataSetChanged();
    }

    private class ViewHolder{

        TextView question , qno ;
        ViewHolder(View view){
            question = view.findViewById(R.id.question_label);
            qno = view.findViewById(R.id.question_number);
        }
    }
}
