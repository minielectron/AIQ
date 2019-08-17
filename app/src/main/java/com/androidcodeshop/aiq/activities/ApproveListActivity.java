package com.androidcodeshop.aiq.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApproveListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.approve_listview)
    ListView approveListview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ArrayList<String> questions;
    private ArrayList<String> keys;
    private ArrayList<QuestionAnswerModel> questionsList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        questions = new ArrayList<>();
        questionsList = new ArrayList<>();
        keys = new ArrayList<>();

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("add_request");

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, questions);
        approveListview.setAdapter(adapter);

//        loadQuestionsToApprove();

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        approveListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("question", questionsList.get(position));
                bundle.putString("key", keys.get(position));
                Intent intent = new Intent(getApplicationContext(), ApproveQuestionDetailsActivity.class);
                intent.putExtras(bundle);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadQuestionsToApprove();
    }

    private void loadQuestionsToApprove() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Questions");
        progressDialog.show();
        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionsList.clear();
                questions.clear();
                keys.clear();
                if (dataSnapshot.getValue() != null) {
                    for (DataSnapshot ques : dataSnapshot.getChildren()) {
                        if (ques.getValue(QuestionAnswerModel.class) != null) {
                            questions.add(ques.getValue(QuestionAnswerModel.class).getQuestion());
                            questionsList.add(ques.getValue(QuestionAnswerModel.class));
                            keys.add(ques.getKey());
                        }
                    }
                    if (questions.size() > 0)
                        adapter.notifyDataSetChanged();
                }
                progressDialog.hide();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.hide();
            }
        });
    }

    @Override
    public void onRefresh() {
        loadQuestionsToApprove();
        swipeRefreshLayout.setRefreshing(false);
    }
}
