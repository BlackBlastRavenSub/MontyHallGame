package com.game.blastraven.b.montyhallgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class HowToPlayActivity extends AppCompatActivity {
    int Page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        Page=1;
    }
    //戻るボタン
    public void back(View view) {
        Intent intent = new Intent(this, TitleActivity.class);
        switch (Page){
            case 1:
            startActivity(intent);
            break;
            case 2:
                setContentView(R.layout.activity_how_to_play);
                Page=1;
        }
    }
    //Android端末の戻るボタン
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(this, TitleActivity.class);
            switch (Page){
                case 1:
                    startActivity(intent);
                    break;
                case 2:
                    setContentView(R.layout.activity_how_to_play);
                    Page=1;
            }
        }
        return false;
    }
    public void next(View view) {
        //getString(R.string.how_to_play2, "テスト");
        setContentView(R.layout.how_to_play_2);
        Page=2;
    }
}
