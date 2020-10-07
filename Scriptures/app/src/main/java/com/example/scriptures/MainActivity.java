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

public class MainActivity extends AppCompatActivity {

    public static final String scripture = "scripture";
    public static final String book = "book";
    public static final String chapter = "chapter";
    public static final String verse = "verse";

    public static final String preferences = "preference";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScripture(View view) {
        EditText editText = (EditText) findViewById(R.id.bookName);
        String book = editText.getText().toString();

        editText = (EditText) findViewById(R.id.chapter);
        String chapter = editText.getText().toString();

        editText = (EditText) findViewById(R.id.verse);
        String verse = editText.getText().toString();

        String message =  book + " " + chapter + ":" + verse;

        Log.d("MainActivity", "About to create intent with " + message);

        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        intent.putExtra(scripture, message);
        intent.putExtra(MainActivity.book, book);
        intent.putExtra(MainActivity.chapter, chapter);
        intent.putExtra(MainActivity.verse, verse);
        startActivity(intent);
    }

    public void loadScripture(View view){
        String book = null;
        String chapter = null;
        String verse = null;
        SharedPreferences preferences;
        preferences = getSharedPreferences(MainActivity.preferences,
                Context.MODE_PRIVATE);

        book = preferences.getString(MainActivity.book, "Not found");
        chapter = preferences.getString(MainActivity.chapter, "Not found");
        verse = preferences.getString(MainActivity.verse, "Not found");

        TextView textView = findViewById(R.id.bookName);
        textView.setText(book);

        textView = findViewById(R.id.chapter);
        textView.setText(chapter);

        textView = findViewById(R.id.verse);
        textView.setText(verse);
    }
}