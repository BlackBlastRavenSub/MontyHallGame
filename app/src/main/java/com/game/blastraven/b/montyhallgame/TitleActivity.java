package com.game.blastraven.b.montyhallgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;

public class TitleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }
    public void gameStart(View view) {
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, GameCoreActivity.class);
        startActivity(intent);
    }
    public void howToPlay(View view) {
        Intent intent = new Intent(this, HowToPlayActivity.class);
        startActivity(intent);
    }
    public void highScore(View view) {
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
    }
    public void ranking(View view) {
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
    }

    public void writeing(View view) {
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();

    }
    public void reading(View view) {
        Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
    }

}
/*private static final String FILE_NAME1 = "highscore";
    private EditText verEditText;
    private String editedText;
    private void readFile(String filename){
        FileInputStream inputTextStream;
        try{
            inputTextStream=openFileInput(filename);
        }
    }
*
*verEditText = (EditText) findViewById(R.id.editText);
* */