package com.androidcodeshop.aiq.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApproveQuestionDetailsActivity extends AppCompatActivity {

    private static final String TAG = "ApproveQuestionDetailsA";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.question_text)
    TextView questionText;
    @BindView(R.id.answer_text)
    TextView answerText;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference, addRequestDbRequestReference;
    long quesNumber = 1001;
    String deleteKey = "";
    private QuestionAnswerModel questionAnswerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_question_details);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("questions");
        addRequestDbRequestReference = firebaseDatabase.getReference("add_request");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                quesNumber = dataSnapshot.getChildrenCount() + 1;
                Log.d(TAG, "onDataChange: " + quesNumber);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        if (getIntent().getExtras() != null) {
            questionAnswerModel = getIntent().getExtras().getParcelable("question");
            deleteKey = getIntent().getStringExtra("key");
            if (questionAnswerModel != null) {
                questionText.setText(String.format("Question : %s", questionAnswerModel.getQuestion()));
                answerText.setText(String.format("Answer : %s", questionAnswerModel.getAnswer()));
            }
        } else Toast.makeText(this, "The data object is not parsed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.approve_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_approve:
                approveQuestions();
                break;
            case R.id.action_reject:
                removeOnReject();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void approveQuestions() {
        if (questionAnswerModel != null) {
            questionAnswerModel.setQuestionNumber((int) quesNumber);
            databaseReference.child(String.valueOf(quesNumber)).setValue(questionAnswerModel, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                    if (databaseError == null) {
                        Toast.makeText(ApproveQuestionDetailsActivity.this, "Successfully Added", Toast.LENGTH_SHORT).show();
                        removeOnReject();
                    } else
                        Toast.makeText(ApproveQuestionDetailsActivity.this, "Database error occurred", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void removeOnReject() {
        addRequestDbRequestReference.child(deleteKey).setValue(null, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    Toast.makeText(ApproveQuestionDetailsActivity.this, "Some error occurred", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ApproveQuestionDetailsActivity.this, "Successfully Updated list", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }
        });
    }
}
