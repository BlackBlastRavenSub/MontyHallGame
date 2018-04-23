package com.game.blastraven.b.montyhallgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class GameCoreActivity extends AppCompatActivity {
    //インターフェイスの実装と処理の記述
    Subcode subcode = new Subcode() {
        //interface Subcodeのオーバーライド
        @Override
        public void disableButton() {
            DoorButton1.setVisibility(View.INVISIBLE);
        }

        //interface Subcodeのオーバーライド
        @Override
        public int idSearch() {
            int id = 0;
            for (int i = 0; i < 99; i++) {
                if (door[i].choose == true) {
                    id = door[i].id;
                }
            }
            return id;
        }

        @Override
        public void writeing(String finalscore) {
            database.writeing(finalscore);
        }

        @Override
        public void reading() {
            database.reading();
        }

        @Override
        public void textChange(String name, String input, String output) {
            //TextView name = findViewById(R.id.output);
            //name.setText(R.string.input);
        }
    };
    Database database;
    Game game = new Game(subcode);
    Door[] door = new Door[100];
    //画面テキストを変更するためにテキストビューを指定
    TextView game_core;
    //bootstrapのドアをプログラムから制御するために名前付け
    static Button DoorButton1;
    static Button DoorButton2;
    static Button DoorButton3;
    static Button DoorButton4;
    static Button DoorButton5;
    static Button DoorButton6;
    static Button DoorButton7;
    static Button DoorButton8;
    static Button DoorButton9;
    static Button DoorButton10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = new Database(this);
        for (int i = 0; i < 99; i++) {
            door[i] = new Door(i + 1, subcode);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_core);
        //bootstrapのドアをプログラムから制御するために名前付け(続き)
        DoorButton1 = findViewById(R.id.DoorButton1);
        DoorButton2 = findViewById(R.id.DoorButton2);
        DoorButton3 = findViewById(R.id.DoorButton3);
        DoorButton4 = findViewById(R.id.DoorButton4);
        DoorButton5 = findViewById(R.id.DoorButton5);
        DoorButton6 = findViewById(R.id.DoorButton6);
        DoorButton7 = findViewById(R.id.DoorButton7);
        DoorButton8 = findViewById(R.id.DoorButton8);
        DoorButton9 = findViewById(R.id.DoorButton9);
        DoorButton10 = findViewById(R.id.DoorButton10);
        game_core = this.findViewById(R.id.textView);
        String game_core_view = getString(R.string.game_core, game.select);
        game_core.setText(game_core_view);
        if (game.stage == null) {
            game.stage = "outofrange";
        }
        switch (game.stage) {
            case "start":
                game.GameStart();
                break;
            case "Firstchoice":
                game.FirstChoice();
                break;
            case "Finalchoice":
                game.FinalChoice();
                break;
            case "StageClear":
                game.StageClear();
                break;
            case "GameOver":
                game.GameOver();
                break;
            case "GameSet":
                game.GameSet();
                break;
        }

    }

    //public void writeing(View view) {game_core.setText(Database.reading());}

    void screenUpdate() {
        String game_core_setview = getString(R.string.game_core, game.select);
        game_core.setText(game_core_setview);
    }


    //各ボタンを押したときの動作
    //ドアボタン
    public void buttonclick(View view) {
        //共通の処理
        for (int i = 0; i < 99; i++) {
            door[i].choose = false;
        }
        //押されたボタンごとに個別の動作
        switch (view.getId()) {

            case R.id.DoorButton1:
                door[0].choose = true;
                database.writeing("Door1");

                //テスト
                game.test(DoorButton1);
                break;
            case R.id.DoorButton2:
                door[1].choose = true;
                break;
            case R.id.DoorButton3:
                door[2].choose = true;
                break;
            case R.id.DoorButton4:
                door[3].choose = true;
                break;
            case R.id.DoorButton5:
                door[4].choose = true;
                break;
            case R.id.DoorButton6:
                door[5].choose = true;
                break;
            case R.id.DoorButton7:
                door[6].choose = true;
                break;
            case R.id.DoorButton8:
                door[7].choose = true;
                break;
            case R.id.DoorButton9:
                door[8].choose = true;
                break;
            case R.id.DoorButton10:
                door[9].choose = true;
                break;
        }
        //共通の処理
        game.select = subcode.idSearch();
        screenUpdate();
    }

    //書き込み/読み込みボタン(テスト用)
    public void database(View view) {
        switch (view.getId()) {
            case R.id.writeing:
                database.writeing("Dummy");
                break;
            case R.id.reading:
                //database.reading();
                Toast.makeText(this, database.reading(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    //ボタンの色をもとに戻す
    void buttonColorReset() {
    }

    //画面表示の変更
    public void textChange(String name, String input, String output) {
        TextView name = findViewById(R.id.output);
        name.setText(R.string.input);
    }
}

//処理の移譲
interface Subcode {
    //ボタンを非表示にする(テスト用)
    void disableButton();

    //プレイヤーに選択されているドアのidを返す関数
    int idSearch();

    void writeing(String score);

    void reading();

    void textChange(String name, String input, String output);
}