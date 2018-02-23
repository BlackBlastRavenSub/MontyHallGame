package com.game.blastraven.b.montyhallgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

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

    //Android端末の戻るボタン
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            new AlertDialog.Builder(TitleActivity.this)
                    .setTitle("アプリを閉じようとしています")
                    .setMessage("終了しますか？")
                    .setIcon(R.drawable.exit)
                    .setPositiveButton(
                            "YES",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    moveTaskToBack(true);//アプリ全体の中断(できれば完全に終了させたい・・・)
                                }
                            }
                    )
                    .setNegativeButton("No",null)
                    .show();
            return false;
        }
        return true;
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
*verEditText = (EditText) findViewById(R.id.editText);
* */