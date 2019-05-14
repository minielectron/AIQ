package com.androidcodeshop.aiq;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidcodeshop.aiq.ui.main.SectionsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GotoPageFragmentDialog.OnGotoFragmentLister, NavigationView.OnNavigationItemSelectedListener {

    public static final String PAGE_NUM = "page_num";
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ViewPager viewPager;
    private GotoPageFragmentDialog dialog;
    private Toolbar toolbar;
    int page = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Android Questions");
        setSupportActionBar(toolbar);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        setUpNavigationDrawer();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % Questions.getNumberOfQuestion());
            }
        });

    }

    private void setUpNavigationDrawer() {
//        name = navigationView.getHeaderView(0).findViewById(R.id.header_name_tv);
//        email = navigationView.getHeaderView(0).findViewById(R.id.header_email_tv);
//        name.setText(DEAFULT_NAME);
//        email.setText(DEAFULT_EMAIL);
//        image = navigationView.getHeaderView(0).findViewById(R.id.header_profile_image);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                Toast.makeText(HomeActivity.this, "Open", Toast.LENGTH_SHORT).show();
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
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this,R.color.white));
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
                dialog = new GotoPageFragmentDialog();
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
                    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Important Questions");
                    sharingIntent.putExtra(Intent.EXTRA_TEXT, clipboard.getText().toString());
                    startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
                }
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
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent = new Intent(this, QuestionsListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        switch (menuItem.getItemId()){
            case R.id.action_qustion_list:
                startActivity(intent);
                drawerLayout.closeDrawer(Gravity.START);
                break;
            case R.id.action_bookmarked_list:
                intent.putExtra("bookmarked",true);
                startActivity(intent);
                drawerLayout.closeDrawer(Gravity.START);
                break;
        }

        return true;
    }
}

//125 page number
