package com.cs441.knox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView backButton = findViewById(R.id.back_button);
        ImageView forwardButton = findViewById(R.id.front_button);
        ImageView vaultButton = findViewById(R.id.vault_button);
        ImageView homeButton = findViewById(R.id.home_button);
        ImageView refreshButton = findViewById(R.id.refresh_button);
        ImageView searchButton = findViewById(R.id.search_button);
        EditText searchBar = findViewById(R.id.search_bar);

//        TextView title = findViewById(R.id.helloworld);

        WebView browser = findViewById(R.id.browser);
        WebSettings websettings = browser.getSettings();
        websettings.setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.google.com");

        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                title.setText("HIIIIII");
//                browser.loadUrl("https://www.facebook.com");
                if(browser.canGoBack()){
                    browser.goBack();
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence errorMsg = "Can't go back!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, errorMsg, duration);
                    toast.show();
                }
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                title.setText("HIIIIII");
//                browser.loadUrl("https://www.google.com");
                if(browser.canGoForward()){
                    browser.goForward();
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence errorMsg = "Can't go forward!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, errorMsg, duration);
                    toast.show();
                }
            }
        });

        vaultButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                title.setText("HIIIIII");
                browser.loadUrl("https://www.google.com");
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                title.setText("HIIIIII");
                Context context = getApplicationContext();
                CharSequence errorMsg = "Going home :)";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, errorMsg, duration);
                toast.show();
                browser.loadUrl("https://www.google.com");
            }
        });

        refreshButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                title.setText("HIIIIII");
//                browser.loadUrl("https://www.google.com");
                Context context = getApplicationContext();
                CharSequence errorMsg = "Refreshing!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, errorMsg, duration);
                toast.show();
                browser.reload();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browser.loadUrl(searchBar.getText().toString());
            }
        });

        searchBar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keycode, KeyEvent keyEvent) {
                if((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (keycode == KeyEvent.KEYCODE_ENTER)){
                    browser.loadUrl(searchBar.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }
}