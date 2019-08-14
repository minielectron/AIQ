package com.androidcodeshop.aiq.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.adapter.QuestionListAdapter;
import com.androidcodeshop.aiq.fragments.AnswerDisplayDialogFragment;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.androidcodeshop.aiq.room.MyDatabase;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookmarkedListActivity extends AppCompatActivity {

    private static final String TAG = "BookmarkedListActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.list_view_bookmark)
    ListView listViewBookmark;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarked_list);
        ButterKnife.bind(this);
        toolbar.setTitle("Bookmarked Questions");
        setSupportActionBar(toolbar);
        ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
        MyDatabase database = MyDatabase.getDatabase(this);
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Toast.makeText(this, "Login to see bookmarked questions", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getUid()).child(getString(R.string.bookmarked_ques));
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionAnswerModels.clear();
                QuestionAnswerModel model;
                for (DataSnapshot ques : dataSnapshot.getChildren()) {
                    model = ques.getValue(QuestionAnswerModel.class);
                    if (model != null && model.getBookmarked() == 1)
                        questionAnswerModels.add(model);
                }
                listViewBookmark.setAdapter(new QuestionListAdapter(questionAnswerModels, getApplicationContext()));
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });

        listViewBookmark.setOnItemClickListener((parent, view, position, id) -> {
            TextView qestTv = view.findViewById(R.id.question_number);
            int pageNum = Integer.valueOf(qestTv.getText().toString());
            Log.i(TAG, "onItemClick: page from questTv" + pageNum);
            FragmentManager manager = getSupportFragmentManager();
            AnswerDisplayDialogFragment displayDialog = AnswerDisplayDialogFragment.getInstance(pageNum - 1);
            displayDialog.show(manager, "answer-display");
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
}
