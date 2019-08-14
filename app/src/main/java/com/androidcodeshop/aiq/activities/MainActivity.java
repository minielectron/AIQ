package com.androidcodeshop.aiq.activities;

import android.app.ProgressDialog;
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
import android.widget.ImageView;
import android.widget.TextView;
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
import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.ads.AdView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements GotoPageFragmentDialogFragment.OnGotoFragmentLister, NavigationView.OnNavigationItemSelectedListener, ShowSnackBar {

    private static final String TAG = "MainActivity";
    public static final String PAGE_NUM = "page_num";
    public static final String ICONIFIED = "iconified";
    private static final String SAVED = "saved";
    private static String userDispalyName = "User";
    private static final int RC_SIGN_IN = 100;
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
    private ProgressDialog progressDialog;

        ChildEventListener childEventListener = new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            if (dataSnapshot.getValue() != null){
                questionAnswerModelArrayList.add(dataSnapshot.getValue(QuestionAnswerModel.class));
                sectionsPagerAdapter.notifyDataSetChanged();
            }

        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            if (dataSnapshot.getValue() != null) {
                Toast.makeText(MainActivity.this, dataSnapshot.getValue(QuestionAnswerModel.class).getQuestion() + "Changed", Toast.LENGTH_LONG).show();
                Log.d(TAG, "onChildChanged: "+dataSnapshot.getKey());
            }
        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    private View headerview;
    private FirebaseUser firebaseUser;
    private TextView name;
    private TextView state;
    private FirebaseAuth mFirebaseAuth;
    private ImageView headerProfileImage;
    public static ArrayList<QuestionAnswerModel> questionAnswerModelArrayList;
    private ValueEventListener valueEventListener;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Android Questions");
        setSupportActionBar(toolbar);
        //--------initialize the variable --------------//
        questionAnswerModelArrayList = new ArrayList<>();
        // write all the questions message to db
        database = FirebaseDatabase.getInstance();
        tabs = findViewById(R.id.tabs);

        mFirebaseAuth = FirebaseAuth.getInstance();
        myRef = database.getReference("questions");
//        myRef.setValue(null);// clear the whole list
//        for(int i = 0 ; i < Questions.getNumberOfQuestion() ; i++){
//            myRef.child(String.valueOf(i+1)).setValue(Questions.getInstance().get(i));
//        }
//        myRef.addChildEventListener(childEventListener);

        // firebase database code ended
        viewPager = findViewById(R.id.view_pager);
        sectionsPagerAdapter = new SectionsPagerAdapter(getApplicationContext(), getSupportFragmentManager(), questionAnswerModelArrayList);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Questions...");
        progressDialog.show();
        Toast.makeText(this, "" + getString(R.string.test), Toast.LENGTH_LONG).show();
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                questionAnswerModelArrayList.clear();
                for (DataSnapshot question : dataSnapshot.getChildren()) {
                    QuestionAnswerModel questionAnswerModel = question.getValue(QuestionAnswerModel.class);
                    questionAnswerModelArrayList.add(questionAnswerModel);
                }
                sectionsPagerAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        };
        myRef.addValueEventListener(valueEventListener);

        setUpNavigationDrawer();
        firebaseUser = mFirebaseAuth.getCurrentUser();
        //---------------set firebase firebaseUser -----------------//
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            name.setText("User");
            state.setText("Login");
            Log.d(TAG, "onCreate: firebaseUser logged in already");
        } else if (FirebaseAuth.getInstance().getCurrentUser().getProviderId().equals(GoogleAuthProvider.PROVIDER_ID)) {
            name.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
            state.setText("Logout");
        } else if (FirebaseAuth.getInstance().getCurrentUser().getProviderId().equals(EmailAuthProvider.PROVIDER_ID)) {
            name.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
            state.setText("Logout");
        } else if (FirebaseAuth.getInstance().getCurrentUser().getProviderId().equals(PhoneAuthProvider.PROVIDER_ID)) {
            name.setText(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
            state.setText("Logout");
        }
        //--------------------------------------------------//
        editor = getSharedPreferences(AIQ_PREFS, MODE_PRIVATE).edit();
        fab = findViewById(R.id.fab);
        preferences = getSharedPreferences(AIQ_PREFS, MODE_PRIVATE);
        fab.setOnClickListener(view -> {
            viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % MainActivity.questionAnswerModelArrayList.size());
        });

    }

    private void insertAllDataToDb() {
        MyDatabase database = MyDatabase.getDatabase(this);
        ArrayList<QuestionAnswerModel> answerModels = Questions.getInstance();
        Executors.newSingleThreadExecutor().execute(() -> {
            for (int i = 0; i < Questions.getNumberOfQuestion(); i++)
                database.aiqDao().insert(answerModels.get(i));
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
        headerview = navigationView.getHeaderView(0);
        name = headerview.findViewById(R.id.header_name_tv);
        state = headerview.findViewById(R.id.header_email_tv);
        headerProfileImage = headerview.findViewById(R.id.header_profile_image);
        headerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();

            }
        });
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(ContextCompat.getColor(this, R.color.white));
    }

    private void performLogin() {
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.PhoneBuilder().build(),
                    new AuthUI.IdpConfig.EmailBuilder().build(),
                    new AuthUI.IdpConfig.GoogleBuilder().build());
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .setIsSmartLockEnabled(false)
                            .setTheme(R.style.LoginTheme)
                            .setLogo(R.drawable.qbitlogo)
                            .build(),
                    RC_SIGN_IN);
        } else {
            FirebaseAuth.getInstance().signOut();
            userDispalyName = "User";
            name.setText(userDispalyName);
            state.setText("Login");
            Glide.with(getApplicationContext()).load(R.drawable.ic_profile_icon).into(headerProfileImage);
            Toast.makeText(MainActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                Toast.makeText(this, "User logged in successfully" + firebaseUser.getDisplayName(), Toast.LENGTH_SHORT).show();
                if (response.getProviderType().equals(PhoneAuthProvider.PROVIDER_ID)) {
                    userDispalyName = firebaseUser.getPhoneNumber();
                } else if (response.getProviderType().equals(GoogleAuthProvider.PROVIDER_ID)) {
                    userDispalyName = firebaseUser.getDisplayName();
                } else {
                    userDispalyName = firebaseUser.getEmail();
                }
                name.setText(userDispalyName);
                state.setText("Logout");
                if (firebaseUser.getPhotoUrl() != null)
                    Glide.with(getApplicationContext()).load(firebaseUser.getPhotoUrl()).into(headerProfileImage);
                else
                    Glide.with(getApplicationContext()).load(R.drawable.ic_profile_icon).into(headerProfileImage);
                // ...
            } else {
                Toast.makeText(this, "Login Cancelled", Toast.LENGTH_SHORT).show();
                // Sign in failed. If response is null the firebaseUser canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
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
                ClipData clip = ClipData.newPlainText("Label", MainActivity.questionAnswerModelArrayList
                        .get(viewPager.getCurrentItem())
                        .getQuestion() +
                        MainActivity.questionAnswerModelArrayList
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
        if (n <= MainActivity.questionAnswerModelArrayList.size()) {
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
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.androidcodeshop.aiq and check code snippets here https://www.androidcodeshop.com");
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

            case R.id.action_privacy_policy:
                Intent privacyIntent = new Intent(this, PrivacyPolicyActivity.class);
                privacyIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(privacyIntent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.action_add_questions:
                if (FirebaseAuth.getInstance().getCurrentUser() == null) {
                    Toast.makeText(this, "Login to Add", Toast.LENGTH_SHORT).show();
                } else {
                    Intent addIntent = new Intent(this, AddQuestions.class);
                    addIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(addIntent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                break;

        }
        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (valueEventListener != null)
            myRef.removeEventListener(valueEventListener);
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
