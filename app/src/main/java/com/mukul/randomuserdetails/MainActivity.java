
package com.mukul.randomuserdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.mukul.randomuserdetails.database.UsersDatabase;
import com.mukul.randomuserdetails.databinding.ActivityMainBinding;
import com.mukul.randomuserdetails.models.ListOfUsers;
import com.mukul.randomuserdetails.models.Result;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    AdapterClass adapter;
    RecyclerView recyclerView;
    ActivityMainBinding bind;
    UsersDatabase usersDatabaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usersDatabaseList = UsersDatabase.getInstance(this);

        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        setupanimation();
        recyclerView = findViewById(R.id.RV);
        mainMethod();

    }


    private void mainMethod() {
        if (isNetworkConnected()) {
            getVolleyResponse();
        } else {
            if (getUsers().isEmpty())
                displayAnimation();
            else {
                displayRecyclerView();
                loadItemIntoRV(getUsers());
            }

        }
    }

    private List<Result> getUsers(){
        return usersDatabaseList.Dao().getAllSaveddetails();
    }

    private void getVolleyResponse() {
        String url = "https://randomuser.me/api/?results=20";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest getDetails = new JsonObjectRequest(Request.Method.GET,
                url, null,
                response -> {

                    ListOfUsers listOfUsers = new GsonBuilder().create().fromJson(response.toString(), ListOfUsers.class);
                    usersDatabaseList.Dao().insertListOfResults(listOfUsers.getResults());

                    Log.e(TAG, response.toString());
                    displayRecyclerView();
                    loadItemIntoRV(getUsers());

                }, error -> {
            Log.e(TAG, error.getMessage());

        });

        requestQueue.add(getDetails);
    }



    private void loadItemIntoRV(List<Result> allSaveddetails) {
       displayRecyclerView();

        adapter = new AdapterClass(allSaveddetails);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    private void displayAnimation() {
        bind.RV.setVisibility(View.GONE);
        bind.noInternetAnim.setVisibility(View.VISIBLE);
    }
    private void displayRecyclerView() {
        bind.RV.setVisibility(View.VISIBLE);
        bind.noInternetAnim.setVisibility(View.GONE);
    }

    void setupanimation() {
        bind.noInternetAnim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            mainMethod();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_screen,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case (R.id.call_item):{
                String phone = "+91 8683937456";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                break;
            }

            case  (R.id.developer_info_item):{
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://techiemukul.com/")));
                break;
            }
            case  (R.id.gitLink_item):{
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ghanghasmukul/RandomUserDetails")));
                break;
            }
            case (R.id.whatsapp_item):{
                PackageManager packageManager = MainActivity.this.getPackageManager();
                Intent i = new Intent(Intent.ACTION_VIEW);
                try {
                    String url = "https://api.whatsapp.com/send?phone="+ "+918683937456" +"&text=" + URLEncoder.encode("Thanks for Mukul for creating this awesome app", "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        this.startActivity(i);
                    }
                    else
                    {
                        i.setPackage("com.whatsapp.w4b");
                        if (i.resolveActivity(packageManager) != null) {
                            this.startActivity(i);
                        }
                        else
                            Toast.makeText(this, "Whatsapp Not Found. Please install Whatsapp!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e){
                    Toast.makeText(this, "Some Error Occured!", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case R.id.saveContact_item: {

                Intent saveMyContact = new Intent(Intent.ACTION_INSERT);

                saveMyContact.setType(ContactsContract.Contacts.CONTENT_TYPE);

                saveMyContact.putExtra(ContactsContract.Intents.Insert.NAME, "Mukul Ghanghas");

                saveMyContact.putExtra(ContactsContract.Intents.Insert.PHONE, "+91 8683937456");

                saveMyContact.putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE, "+91 9518893119");

                saveMyContact.putExtra(ContactsContract.Intents.Insert.EMAIL, "mukulghanghas1@gmail.com");

                startActivity(saveMyContact);

                break;
            }


            case (R.id.quit_item):{
                finish();
                break;
            }

        }
        return super.onOptionsItemSelected(item);
    }
    private void requestPermission(String permissionName, int requestCode) {

        String[] permissionArray = {permissionName};

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(this, permissionArray, requestCode);
        }

    }


}