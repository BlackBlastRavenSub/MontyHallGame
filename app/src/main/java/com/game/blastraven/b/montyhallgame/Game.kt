package com.game.blastraven.b.montyhallgame

import android.view.View

/**
 * Created by KOGUMA on 2018/03/25.
 */

class Game internal constructor(internal var subcode: Subcode){
    //class Game internal constructor(internal var subcode: Subcode)

    internal var select: Int = 0//プレイヤーが選んだドア
    internal var firstId: Int = 0//プレイヤーが最初に選んだドアのidを保存しておく変数
    internal var finalId: Int = 0//プレイヤーが最終的にに選んだドアのidを保存しておく変数
    internal var level: Int = 0//現在のステージ
    internal var stage: String//現在の段階
    internal var dummy: Int = 0//プレイヤーが1回目で正解のドアを選んだ際に指定される不正解のドア
    internal var correct: Int = 0//正解のドア
    internal var score = 0//現在のプレイヤーのスコア
    internal var database: Database? = null

    init {
        select = 0
        this.stage = "outofrange"
        //database = new Database(this);
        this.subcode=subcode

    }

    //スタート
    internal fun GameStart() {
        //正解のドアとダミーのドアの決定
        correct = 1 + java.util.Random().nextInt(100)
        do {
            dummy = 1 + java.util.Random().nextInt(100)
        } while (correct == dummy)
        //GameCoreActivity.textChange("test", "gamestart", "textView");


    }

    //1回目のドア選択
    internal fun FirstChoice() {
        firstId = subcode.idSearch()

    }

    //最後のドア選択
    internal fun FinalChoice() {
        finalId = subcode.idSearch()
    }

    //成功した!
    internal fun StageClear() {

    }

    //成功して終了した!
    internal fun GameSet() {
        val finalscore = score.toString()
        subcode.writeing(finalscore)
        database!!.writeing(finalscore)
        subcode.screenUpdate("DataSending...")
    }

    //失敗した!
    internal fun GameOver() {}

    internal fun test(DoorB1: View) {
        DoorB1.visibility = View.INVISIBLE
    }
    /*
    void textChange(){
        TextView name = getString(R.id.output);
        name.setText(R.string.input);
    }*/
}