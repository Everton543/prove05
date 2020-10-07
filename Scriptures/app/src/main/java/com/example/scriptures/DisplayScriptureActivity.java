package com.example.scriptures;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {
    String book = null;
    String chapter = null;
    String verse = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_scripture);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.scripture);
        book = intent.getStringExtra(MainActivity.book);
        chapter = intent.getStringExtra(MainActivity.chapter);
        verse = intent.getStringExtra(MainActivity.verse);

        Log.d("DisplayMessageActivity", "Received intent with " + message);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.displayScripture);
        textView.setText(message);
    }

    public void saveFavoriteScripture(View view){
        SharedPreferences preferences;
        preferences = getSharedPreferences(MainActivity.preferences,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(MainActivity.book, this.book);
        editor.putString(MainActivity.chapter, this.chapter);
        editor.putString(MainActivity.verse, this.verse);

        editor.apply();

        Toast.makeText(getBaseContext(),
                "Saved favorite scripture",
                Toast.LENGTH_SHORT).show();
    }
}