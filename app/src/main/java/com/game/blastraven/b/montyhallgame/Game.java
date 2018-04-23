package com.game.blastraven.b.montyhallgame;

import android.view.View;

/**
 * Created by KOGUMA on 2018/03/25.
 */

public class Game {

    int select;//プレイヤーが選んだドア
    int firstId;//プレイヤーが最初に選んだドアのidを保存しておく変数
    int finalId;//プレイヤーが最終的にに選んだドアのidを保存しておく変数
    int level;//現在のステージ
    String stage;//現在の段階
    int dummy;//プレイヤーが1回目で正解のドアを選んだ際に指定される不正解のドア
    int correct;//正解のドア
    int score = 0;//現在のプレイヤーのスコア
    Subcode subcode;
    Database database;

    Game(Subcode subcode) {
        select = 0;
        this.subcode = subcode;
        this.stage = "outofrange";
        //database = new Database(this);

    }

    //スタート
    void GameStart() {
        //正解のドアとダミーのドアの決定
        correct = 1 + new java.util.Random().nextInt(100);
        do {
            dummy = 1 + new java.util.Random().nextInt(100);
        }
        while (correct == dummy);
        GameCoreActivity.textChange("test", "gamestart", "textView");

    }

    //1回目のドア選択
    void FirstChoice() {
        firstId = subcode.idSearch();

    }

    //最後のドア選択
    void FinalChoice() {
        finalId = subcode.idSearch();
    }

    //成功した!
    void StageClear() {
    }

    //成功して終了した!
    void GameSet() {
        String finalscore = String.valueOf(score);
        subcode.writeing(finalscore);
        database.writeing(finalscore);

    }

    //失敗した!
    void GameOver() {
    }
    void test(View DoorB1){
        DoorB1.setVisibility(View.INVISIBLE);
    }
}
