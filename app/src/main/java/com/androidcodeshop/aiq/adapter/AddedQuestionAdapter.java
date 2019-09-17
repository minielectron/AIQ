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

    private ArrayList<QuestionAnswerModel> arrayList;
    private Context context;
    private ViewHolder holder;


    public AddedQuestionAdapter(ArrayList<QuestionAnswerModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        if (convertView == null) {
            //will be called once to fetch the id not multiple times
            convertView = LayoutInflater.from(context).inflate(R.layout.question_list_item_1, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else holder = (ViewHolder) convertView.getTag();

        holder.question.setText(arrayList.get(position).getQuestion());
        if(arrayList.get(position).getBookmarked() == 1){
            holder.question.setBackgroundColor(Color.GREEN);
        }else if(arrayList.get(position).getBookmarked() == 2){
            holder.question.setBackgroundColor(Color.RED);
            holder.question.setTextColor(Color.BLACK);
        }

        return convertView;
    }

    class ViewHolder{
        TextView question;

        ViewHolder(View view) {
            question = view.findViewById(R.id.question_label);
        }
    }
}
