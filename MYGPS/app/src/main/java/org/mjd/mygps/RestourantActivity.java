package org.mjd.mygps;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class RestourantActivity extends ActionBarActivity {
    WebView webView;

    private class WebViewClientClass extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restourant);
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://valueup16-jb7959.c9.io/res_boards/4");
        webView.setVerticalScrollBarEnabled(true);
        webView.setWebViewClient(new WebViewClientClass());
    }
}


/*
public class RestourantActivity extends ActionBarActivity {
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restourant);
        LinearLayout resLayout =  (LinearLayout) findViewById(R.id.resLayout);
        String title = getIntent().getExtras().getString("title"); // 인텐트로 넘어온 타이틀 받기. 추후 디비 key로 활용하면 될듯. 액티비티간 참조 활용
        //텍스트창
        TextView text1 = new TextView(this);
        text1.setText(title);
        resLayout.addView(text1);

        //메뉴그림
        //그림참조는 http://blog.naver.com/yikj1004/134314705F
       ImageView resImage = (ImageView) findViewById(R.id.resImage);
       resImage.setImageResource(R.drawable.songbaek2);

        //설명
        String temp = getIntent().getExtras().getString("key");
        String explain = "no value"; //한글로 안나오는 문제 처리할것.
        if(temp.equals("1")) {
         explain = "goooooodd";
        }
        TextView text2 = new TextView(this);
        text2.setText(explain);
        resLayout.addView(text2);




    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop fisrst Rest", Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restourant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

*/