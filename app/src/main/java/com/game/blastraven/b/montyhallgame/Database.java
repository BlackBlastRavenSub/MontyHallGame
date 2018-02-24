package com.game.blastraven.b.montyhallgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by shotaro on 2018/02/04.
 */

public class Database {
    private final static String TAG_WRITE = "write";
    private final static String TAG_READ = "read";
    private final static String DB_NAME = "databank.db";//DB名
    private final static String DB_TABLE = "databank";   //テーブル名
    private final static int DB_VERSION = 1;        //バージョン
    private EditText editText;//エディットテキスト
    private SQLiteDatabase db;//データベースオブジェクト
    private Context context = null;

    Database(Context context) {
        //データベースオブジェクトの取得(5)
        this.context = context;
        DBHelper dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //DBへの書き込み
    public void writeing(String string) {
        Toast.makeText(context, "書き込み中", Toast.LENGTH_LONG).show();
        try {
            //String str = editText.getText().toString();
            //テスト用のサンプルデータ
            String str = string;
            writeDB(str);
        } catch (Exception e) {
            Toast.makeText(context, "書き込みに失敗しました！", Toast.LENGTH_LONG).show();
        }
    }

    //DBからの読み込み
    public String reading() {
        //Toast.makeText(this, "読み込み中", Toast.LENGTH_LONG).show();
        try {
            return readDB();

        } catch (Exception e) {
            return "読み込み失敗しました。";
        }
    }

    //データベースへの書き込み(6)
    private void writeDB(String info) throws Exception {
        ContentValues values = new ContentValues();
        values.put("id", "0");
        values.put("info", info);
        int colNum = db.update(DB_TABLE, values, null, null);
        if (colNum == 0) db.insert(DB_TABLE, "", values);
    }

    //データベースからの読み込み(7)
    private String readDB() throws Exception {
        Cursor c = db.query(DB_TABLE, new String[]{"id", "info"},
                "id='0'", null, null, null, null);
        if (c.getCount() == 0) throw new Exception();
        c.moveToFirst();
        String str = c.getString(1);
        c.close();
        return str;
    }

    //データベースヘルパーの定義(1)
    private static class DBHelper extends SQLiteOpenHelper {
        //データベースヘルパーのコンストラクタ(2)
        public DBHelper(Context context) {
            //データベースの名前、ファクトリー、バージョンの設定
            super(context, DB_NAME, null, DB_VERSION);
        }

        //データベースの生成(3)
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table if not exists " +
                    DB_TABLE + "(id text primary key,info text)");
        }

        //データベースのアップグレード(4)
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + DB_TABLE);
            onCreate(db);
        }
    }
}
