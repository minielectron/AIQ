package com.androidcodeshop.aiq.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.adapter.AddedQuestionAdapter;
import com.androidcodeshop.aiq.fragments.AnswerDisplayFromListFragment;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddedQuestionsListActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.added_list_view)
    ListView addedListView;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private ArrayList<QuestionAnswerModel> questionsAddedList;
    private AddedQuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_added_questions_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        database = FirebaseDatabase.getInstance();
        questionsAddedList = new ArrayList<>();
        adapter = new AddedQuestionAdapter(questionsAddedList,this);
        addedListView.setAdapter(adapter);
//        loadList();
        addedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AnswerDisplayFromListFragment display = new AnswerDisplayFromListFragment(questionsAddedList.get(position));
                display.show(getSupportFragmentManager(),"answer-display");
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadList();
    }

    private void loadList() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading questions...");
        progressDialog.show();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            databaseReference = database.getReference("users").child(FirebaseAuth.getInstance().getUid()).child("add");
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue() != null) {
                        for (DataSnapshot ques : dataSnapshot.getChildren()) {
                            if (ques.getValue(QuestionAnswerModel.class) != null) {
                                questionsAddedList.add(ques.getValue(QuestionAnswerModel.class));
                            }
                        }
                    }
                    adapter.notifyDataSetChanged();
                    progressDialog.hide();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    progressDialog.hide();
                }
            });
        }else Toast.makeText(this, "Log in to check list", Toast.LENGTH_SHORT).show();
    }
}
