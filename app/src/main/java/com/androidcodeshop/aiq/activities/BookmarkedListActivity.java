package com.androidcodeshop.aiq.activities;

import android.os.Bundle;
import com.google.android.material.appbar.AppBarLayout;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.androidcodeshop.aiq.fragments.AnswerDisplayDialogFragment;
import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.adapter.QuestionListAdapter;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.androidcodeshop.aiq.room.MyDatabase;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarked_list);
        ButterKnife.bind(this);
        toolbar.setTitle("Bookmarked Questions");
        setSupportActionBar(toolbar);
        ArrayList<QuestionAnswerModel> questionAnswerModels = new ArrayList<>();
        MyDatabase database = MyDatabase.getDatabase(this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (QuestionAnswerModel model : database.aiqDao().getAllQuestionAnswers()) {
                    if (model.getBookmarked() == 1) questionAnswerModels.add(model);
                }
                Log.d(TAG, "run: " + questionAnswerModels.toString());
                listViewBookmark.setAdapter(new QuestionListAdapter(questionAnswerModels,getApplicationContext()));
            }
        });
        listViewBookmark.setOnItemClickListener((parent, view, position, id) -> {
            TextView qestTv = view.findViewById(R.id.question_number);
            int pageNum = Integer.valueOf(qestTv.getText().toString());
            Log.i(TAG, "onItemClick: page from questTv"+ pageNum);
            FragmentManager manager = getSupportFragmentManager();
            AnswerDisplayDialogFragment displayDialog = AnswerDisplayDialogFragment.getInstance(pageNum-1);
            displayDialog.show(manager, "answer-display");
        });
    }
}
