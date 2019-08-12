package com.androidcodeshop.aiq.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.androidcodeshop.aiq.R;
import com.androidcodeshop.aiq.fragments.GotoPageFragmentDialogFragment;
import com.androidcodeshop.aiq.interfaces.ShowSnackBar;
import com.androidcodeshop.aiq.model.QuestionAnswerModel;
import com.androidcodeshop.aiq.room.MyDatabase;
import com.androidcodeshop.aiq.ui.main.SectionsPagerAdapter;
import com.androidcodeshop.aiq.utils.Questions;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GotoPageFragmentDialogFragment.OnGotoFragmentLister, NavigationView.OnNavigationItemSelectedListener, ShowSnackBar {

    private static final String TAG = "MainActivity";
    public static final String PAGE_NUM = "page_num";
    public static final String ICONIFIED = "iconified";
    private static final String SAVED = "saved";
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private GotoPageFragmentDialogFragment dialog;
    private Toolbar toolbar;
    int page = 0;
    public static final String AIQ_PREFS = "aiqp";
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private AdView mAdView;
    public static SectionsPagerAdapter sectionsPagerAdapter;
    private FloatingActionButton fab;


//    ChildEventListener childEventListener = new ChildEventListener() {
//        @Override
//        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//            if (dataSnapshot.getValue() != null)
//                Toast.makeText(MainActivity.this, dataSnapshot.getValue(QuestionAnswerModel.class).getQuestion(), Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//            if (dataSnapshot.getValue() != null) {
//                Toast.makeText(MainActivity.this, dataSnapshot.getValue(QuestionAnswerModel.class).getQuestion() + "Changed", Toast.LENGTH_LONG).show();
//                Log.d(TAG, "onChildChanged: "+dataSnapshot.getKey());
//            }
//        }
//
//        @Override
//        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//        }
//
//        @Override
//        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//        }
//    };
    private DatabaseReference myRef;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Android Questions");
        setSupportActionBar(toolbar);

        // write all the questions message to db
        database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true); // for offline support
//        myRef = database.getReference("questions");

//        myRef.setValue(null);// clear the whole list
//        for(int i = 0 ; i < Questions.getNumberOfQuestion() ; i++){
//            myRef.push().setValue(Questions.getInstance().get(i));
//        }

//        myRef.addChildEventListener(childEventListener);

        // firebase database code ended
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setUpNavigationDrawer();
        editor = getSharedPreferences(AIQ_PREFS, MODE_PRIVATE).edit();
        fab = findViewById(R.id.fab);
        preferences = getSharedPreferences(AIQ_PREFS, MODE_PRIVATE);
        fab.setOnClickListener(view -> {
            viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % Questions.getNumberOfQuestion());
        });

        if (preferences.getString(SAVED, null) == null) insertAllDataToDb();
    }

    private void insertAllDataToDb() {
        MyDatabase database = MyDatabase.getDatabase(this);
        ArrayList<QuestionAnswerModel> answerModels = Questions.getInstance();
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < Questions.getNumberOfQuestion(); i++)
                database.aiqDao().insert(Questions.getInstance().get(i));
            Log.d(TAG, "insertAllDataToDb: All data inserted");
            editor.putString(SAVED, SAVED);
            editor.apply();
        });
    }


    private void setUpNavigationDrawer() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                Toast.makeText(HomeActivity.this, "Close", Toast.LENGTH_SHORT).show();
            }
        };

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, R.color.white));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.forwad_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_goto:
                dialog = new GotoPageFragmentDialogFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                dialog.show(fragmentManager, "goto-fragment");
                break;
            case R.id.action_copy:
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Label", Questions.getInstance()
                        .get(viewPager.getCurrentItem())
                        .getQuestion() +
                        Questions.getInstance()
                                .get(viewPager.getCurrentItem())
                                .getAnswer());
                if (clipboard != null) {
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(this, "Q & A Copied Successfully to share", Toast.LENGTH_SHORT).show();
                    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Important Question");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, clipboard.getText().toString());
                    startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
                }
                break;
            case R.id.action_search:
                Intent searchActivityIntent = new Intent(this, QuestionsListActivity.class);
                searchActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                searchActivityIntent.putExtra(ICONIFIED, false);
                startActivity(searchActivityIntent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void gotoPage(int n) {
        if (n <= Questions.getNumberOfQuestion()) {
            viewPager.setCurrentItem(n - 1);
            dialog.dismiss();
        } else Toast.makeText(this, "Question number is invalid", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (preferences != null) {
            int lastVisited = preferences.getInt("last_visited_question", 0);
            viewPager.setCurrentItem(lastVisited);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case R.id.action_qustion_list:
                intent = new Intent(this, QuestionsListActivity.class);
                intent.putExtra(ICONIFIED, true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.action_bookmarked_list:
                intent = new Intent(this, BookmarkedListActivity.class);
                intent.putExtra("bookmarked", true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.share_app:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://www.androidcodeshop.com");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.action_about_me:
                Intent aboutIntent = new Intent(this, WebViewActivity.class);
                aboutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(aboutIntent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
//        myRef.removeEventListener(childEventListener);
        editor.putInt("last_visited_question", viewPager.getCurrentItem());
        editor.apply();
    }

    @Override
    public void showSnack() {
        Snackbar.make(fab, "Done! Check Bookmark List", Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BookmarkedListActivity.class);
                intent.putExtra("bookmarked", true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }).show();
    }

}

//125 page number
