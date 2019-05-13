package com.androidcodeshop.aiq;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidcodeshop.aiq.adapter.QuestionListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    ListView listView;
    private QuestionListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("All Questions List");
        String[] questions = new String[Questions.getNumberOfQuestion()];
        for (int i = 0; i <= Questions.getNumberOfQuestion() - 1; i++) {
            questions[i] = Questions.getInstance().get(i).getQuestion();
        }
        adapter = new QuestionListAdapter(Questions.getInstance(), this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView qestTv = view.findViewById(R.id.question_number);
                int pageNum = Integer.valueOf(qestTv.getText().toString());
                FragmentManager manager = getSupportFragmentManager();
                AnswerDisplayDialog displayDialog = new AnswerDisplayDialog();
                Bundle bundle = new Bundle();
                bundle.putInt("page", pageNum - 1);
                displayDialog.setArguments(bundle);
                displayDialog.show(manager, "answer-display");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setQueryHint("Search Question");
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filter(s);
        return true;
    }
}
