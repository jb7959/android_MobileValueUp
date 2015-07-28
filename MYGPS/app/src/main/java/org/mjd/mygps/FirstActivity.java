package org.mjd.mygps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;



public class FirstActivity extends ActionBarActivity {
    public static final String PREF_ID = "Pref01";
    public static final int actMode = Activity.MODE_PRIVATE;
    public static Bitmap bm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


    }

    public void startBtn(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    protected void restoredFormSavedState(){
        SharedPreferences myPrefs = getSharedPreferences(PREF_ID,actMode);
        if ((myPrefs != null) && (myPrefs.contains("txtMsg"))){
            String myData = myPrefs.getString("txtMsg","");
            Toast.makeText(this, "Restored : " + myData, Toast.LENGTH_SHORT).show();
        }
    }

    protected void saveCurrentState() {
        SharedPreferences myPrefs = getSharedPreferences(PREF_ID, actMode);
        SharedPreferences.Editor myEditor = myPrefs.edit();
        myEditor.putString( "txtMsg", "My name is mike." );
        myEditor.commit();
    }

    protected void clearMyPrefs() {
        SharedPreferences myPrefs = getSharedPreferences(PREF_ID, actMode);
        SharedPreferences.Editor myEditor = myPrefs.edit();
        myEditor.clear();
        myEditor.commit();
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
    @Override
    protected void onStop(){

        bm = BitmapFactory.decodeFile("@drawable/main3");
        if(bm !=null){
        bm = null;}
       // bm = BitmapFactory.decodeFile("@drawable/enter");
       // bm.recycle();
       // bm = null;
        super.onStop();


        Toast.makeText(this,"onStop fisrst Activity",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause() 호출됨.", Toast.LENGTH_LONG).show();

        saveCurrentState();

        super.onPause();
    }


    @Override
    protected void onRestart() {
        Toast.makeText(this, "onRestart() 호출됨.", Toast.LENGTH_LONG).show();

        super.onRestart();
    }


    @Override
    protected void onResume() {
        Toast.makeText(this, "onResume() 호출됨.", Toast.LENGTH_LONG).show();
        restoredFormSavedState();

        super.onResume();
    }
}
