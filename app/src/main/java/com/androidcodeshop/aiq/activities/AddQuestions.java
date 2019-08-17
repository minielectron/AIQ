package com.androidcodeshop.aiq.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddQuestions extends AppCompatActivity {

    @BindView(R.id.add_ques_no)
    TextView addQuesNo;
    @BindView(R.id.question_test)
    EditText questionTestView;
    @BindView(R.id.ans_text)
    EditText ansTextView;
    @BindView(R.id.button)
    Button buttonSubmit;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private long quesNum = 1;
    private long addRequestQuesNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);
        ButterKnife.bind(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        setQuestionNumber();


    }

    private void setQuestionNumber() {
        databaseReference.child("users").child(FirebaseAuth.getInstance().getUid()).child("add").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null){
                    quesNum = dataSnapshot.getChildrenCount() + 1;
                }
                addQuesNo.setText(String.format(getString(R.string.add_question_no_s), String.valueOf(quesNum)));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void clear() {
        questionTestView.setText("");
        ansTextView.setText("");
    }

    @OnClick(R.id.button)
    public void onViewClicked() {

        if (TextUtils.isEmpty(questionTestView.getText()) || TextUtils.isEmpty(ansTextView.getText())) {
            Toast.makeText(this, "Please add questions and answer", Toast.LENGTH_SHORT).show();
        } else {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Saving Question...");
            progressDialog.show();
            QuestionAnswerModel questionAnswerModel = new QuestionAnswerModel((int) quesNum, questionTestView.getText().toString(), ansTextView.getText().toString());
            if (databaseReference != null) {
                databaseReference.child("users").child(FirebaseAuth.getInstance().getUid()).child("add").push().setValue(questionAnswerModel)
                        .addOnCompleteListener(task -> {
                            progressDialog.hide();
                            clear();
                            setQuestionNumber();
                            Toast.makeText(AddQuestions.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                        })
                        .addOnFailureListener(e -> {
                            progressDialog.hide();
                            Toast.makeText(AddQuestions.this, "" + "Sorry! Internet/Server issue", Toast.LENGTH_SHORT).show();
                        });

                databaseReference.child("add_request").push().setValue(questionAnswerModel)
                        .addOnCompleteListener(task -> {
                            progressDialog.hide();
                            clear();
                            setTotalQuestionNumber();
                            Toast.makeText(AddQuestions.this, "Request : " + addRequestQuesNum + " Added!", Toast.LENGTH_LONG).show();
                        })
                        .addOnFailureListener(e -> {
                            progressDialog.hide();
                            Toast.makeText(AddQuestions.this, "" + "Sorry! Internet/Server issue", Toast.LENGTH_SHORT).show();
                        });
            } else
                Toast.makeText(this, "Database reference is not valid", Toast.LENGTH_SHORT).show();
        }
    }

    private void setTotalQuestionNumber() {
        databaseReference.child("add_request").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    addRequestQuesNum = dataSnapshot.getChildrenCount() + 1;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
