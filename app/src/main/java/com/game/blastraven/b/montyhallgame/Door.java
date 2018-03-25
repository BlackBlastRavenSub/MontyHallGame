package com.game.blastraven.b.montyhallgame;

/**
 * Created by KOGUMA on 2018/03/25.
 */

public class Door {

    final int id;//ドアの固有ID
    boolean choose = false;//プレイヤーはこのドアを選んだか?
    boolean open = false;//結局ドアは今空いているのか?
    //boolean correct = false;//これは正解のドアか?
    Subcode subcode;

    Door(int id, Subcode subcode) {
        this.id = id;
        this.subcode = subcode;
    }

    void bootstrapDoor2() {
        //ボタンを非表示にする
        subcode.disableButton();
    }
}
