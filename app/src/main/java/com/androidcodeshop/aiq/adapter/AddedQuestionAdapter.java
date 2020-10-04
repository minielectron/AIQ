package com.androidcodeshop.aiq.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

public class AddedQuestionAdapter extends BaseAdapter {

    private final ArrayList<QuestionAnswerModel> arrayList;
    private final Context context;


    public AddedQuestionAdapter(final ArrayList<QuestionAnswerModel> arrayList, final Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.question_list_item_1, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.getQuestion().setText(arrayList.get(position).getQuestion());
        if(1 == arrayList.get(position).getBookmarked()){
            holder.getQuestion().setBackgroundColor(Color.GREEN);
        }else if(2 == arrayList.get(position).getBookmarked()){
            holder.getQuestion().setBackgroundColor(Color.RED);
            holder.getQuestion().setTextColor(Color.BLACK);
        }

        return convertView;
    }

    static class ViewHolder{
        private TextView question;

        ViewHolder(final View view) {
            setQuestion(view.findViewById(R.id.question_label));
        }

        public TextView getQuestion() {
            return question;
        }

        public void setQuestion(final TextView question) {
            this.question = question;
        }
    }
}
