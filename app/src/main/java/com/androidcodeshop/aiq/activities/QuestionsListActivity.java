package com.androidcodeshop.aiq.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.FragmentManager;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.adapter.QuestionListAdapter;
import com.androidcodeshop.aiq.fragments.AnswerDisplayDialogFragment;
import com.androidcodeshop.aiq.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private boolean icon;
    private static final String TAG = "QuestionsListActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    ListView listView;
    private QuestionListAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_list);
        ButterKnife.bind(this);
        toolbar.setTitle("All Questions");
        setSupportActionBar(toolbar);
        icon = getIntent().getBooleanExtra(MainActivity.ICONIFIED, true);
        adapter = new QuestionListAdapter(MainActivity.questionAnswerModelArrayList, this);
        listView.setAdapter(adapter);
        final Activity activity = this;
        listView.setOnItemClickListener((parent, view, position, id) -> {
            final TextView qestTv = view.findViewById(R.id.question_number);
            final int pageNum = Integer.valueOf(qestTv.getText().toString());
            Log.i(TAG, "onItemClick: page from questTv" + pageNum);
            final FragmentManager manager = getSupportFragmentManager();
            final AnswerDisplayDialogFragment displayDialog = AnswerDisplayDialogFragment.getInstance(pageNum - 1);
            displayDialog.show(manager, "answer-display");
            Utils.hideKeyboard(activity);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        final MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setQueryHint("Search Question");
        searchView.setIconified(icon);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(final String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(final String s) {
        adapter.filter(s);
        return true;
    }
}
