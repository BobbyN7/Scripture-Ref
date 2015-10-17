package com.example.robert.scriptureref;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.Script;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_SCRIPTURE = "com.example.robert.scriptureref.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Context context = this;
        final Button shareButton = (Button) findViewById(R.id.share);
            shareButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Perform Action on Click
                Intent displayIntent = new Intent(context, Display.class); // new intent
                // Grab a scripture
                EditText editText = (EditText) findViewById(R.id.editBook);
                String book = editText.getText().toString();
                editText = (EditText) findViewById(R.id.editChapter);
                String chapter = editText.getText().toString();
                editText = (EditText) findViewById(R.id.editVerse);
                String verse = editText.getText().toString();
                try {
                    Scripture scripture = new Scripture(book, Integer.parseInt(chapter), Integer.parseInt(verse));
                    displayIntent.putExtra(EXTRA_SCRIPTURE, scripture.getScripture());
                    startActivity(displayIntent);
                }
                catch(Exception e){
                    // tell the user that he put in invalid data
                    return;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
