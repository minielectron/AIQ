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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
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
    private long quesNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);
        ButterKnife.bind(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("questions");
        setQuestionNumber();


    }

    private void setQuestionNumber() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                quesNum = dataSnapshot.getChildrenCount() + 1;
                addQuesNo.setText(String.format(getString(R.string.add_question_no_s), String.valueOf(quesNum)));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void clear(){
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
                databaseReference.child(String.valueOf(quesNum)).setValue(questionAnswerModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressDialog.hide();
                        clear();
                        setQuestionNumber();
                        Toast.makeText(AddQuestions.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        progressDialog.hide();
                        Toast.makeText(AddQuestions.this, "" + "Sorry! Not an Admin", Toast.LENGTH_SHORT).show();
                    }
                });
            } else
                Toast.makeText(this, "Database reference is not valid", Toast.LENGTH_SHORT).show();
        }
    }
}
