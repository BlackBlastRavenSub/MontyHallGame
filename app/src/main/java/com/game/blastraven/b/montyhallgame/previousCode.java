package com.game.blastraven.b.montyhallgame;

/**
 * Created by NodaShotaro on 2018/03/26.
 */

public class previousCode {
    /*
    2018/03/25
            package com.game.blastraven.b.montyhallgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

    public class GameCoreActivity extends AppCompatActivity {
        //インターフェイスの実装と処理の記述
        Subcode subcode = new Subcode() {
            //interface Subcodeのオーバーライド
            @Override
            public void disableButton() {
                BootstrapButton button1 = findViewById(R.id.bootstrapDoor1);
                button1.setVisibility(View.INVISIBLE);
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
        BootstrapButton DoorButton1;
        BootstrapButton DoorButton2;
        BootstrapButton DoorButton3;
        BootstrapButton DoorButton4;
        BootstrapButton DoorButton5;
        BootstrapButton DoorButton6;
        BootstrapButton DoorButton7;
        BootstrapButton DoorButton8;
        BootstrapButton DoorButton9;
        BootstrapButton DoorButton10;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            database = new Database(this);
            for (int i = 0; i < 99; i++) {
                door[i] = new Door(i + 1, subcode);
            }
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game_core);
            //bootstrapのドアをプログラムから制御するために名前付け(続き)
            DoorButton1 = findViewById(R.id.bootstrapDoor1);
            DoorButton2 = findViewById(R.id.bootstrapDoor2);
            DoorButton3 = findViewById(R.id.bootstrapDoor3);
            DoorButton4 = findViewById(R.id.bootstrapDoor4);
            DoorButton5 = findViewById(R.id.bootstrapDoor5);
            DoorButton6 = findViewById(R.id.bootstrapDoor6);
            DoorButton7 = findViewById(R.id.bootstrapDoor7);
            DoorButton8 = findViewById(R.id.bootstrapDoor8);
            DoorButton9 = findViewById(R.id.bootstrapDoor9);
            DoorButton10 = findViewById(R.id.bootstrapDoor10);
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
                case "firstchoice":
                    game.FirstChoice();
                    break;
                case "finalchoice":
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

                case R.id.bootstrapDoor1:
                    door[0].choose = true;
                    DoorButton1.setShowOutline(true);
                    break;
                case R.id.bootstrapDoor2:
                    door[1].choose = true;
                    break;
                case R.id.bootstrapDoor3:
                    door[2].choose = true;
                    break;
                case R.id.bootstrapDoor4:
                    door[3].choose = true;
                    break;
                case R.id.bootstrapDoor5:
                    door[4].choose = true;
                    break;
                case R.id.bootstrapDoor6:
                    door[5].choose = true;
                    break;
                case R.id.bootstrapDoor7:
                    door[6].choose = true;
                    break;
                case R.id.bootstrapDoor8:
                    door[7].choose = true;
                    break;
                case R.id.bootstrapDoor9:
                    door[8].choose = true;
                    break;
                case R.id.bootstrapDoor10:
                    door[9].choose = true;
                    break;
            }
            //共通の処理
            game.select = subcode.idSearch();
            screenUpdate();

        /*ボタン旧案
    public void bootstrapDoor1(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[0].choose=true;

    }
    public void bootstrapDoor2(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[1].choose=true;
    }
    public void bootstrapDoor3(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[2].choose=true;
    }
    public void bootstrapDoor4(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[3].choose=true;
    }
    public void bootstrapDoor5(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[4].choose=true;
    }
    public void bootstrapDoor6(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[5].choose=true;
    }
    public void bootstrapDoor7(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[6].choose=true;
    }
    public void bootstrapDoor8(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[7].choose=true;
    }
    public void bootstrapDoor9(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[8].choose=true;
    }
    public void bootstrapDoor10(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[9].choose=true;
    }
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
    }

    class Game {
        int select;//プレイヤーが選んだドア
        int firstId;//プレイヤーが最初に選んだドアのidを保存しておく変数
        int finalId;//プレイヤーが最終的にに選んだドアのidを保存しておく変数
        int level;//現在のステージ
        String stage;//現在の段階
        int dummy;//プレイヤーが1回目で正解のドアを選んだ際に指定される不正解のドア
        int correct;//正解のドア
        int score = 0;//現在のプレイヤーのスコア
        Subcode subcode;

        Game(Subcode subcode) {
            select = 0;
            this.subcode = subcode;
            this.stage = "outofrange";
        }

        //スタート
        void GameStart() {
            //正解のドアとダミーのドアの決定
            correct = 1 + new java.util.Random().nextInt(100);
            do {
                dummy = 1 + new java.util.Random().nextInt(100);
            }
            while (correct == dummy);
            subcode.textChange("test", "gamestart", "textView");
        }

        //1回目のドア選択
        void FirstChoice() {
            firstId = subcode.idSearch();
            DoorButton1.setShowOutline(true);
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

        }

        //失敗した!
        void GameOver() {
        }
    }

    class Door {
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
 public void writeing(View view) {
        writeFile("testing!!");
    }
    public void reading(View view) {
        //readFile(getFilesDir());
    }

    //ファイルの書き込みクラス
    private void writeFile(String contents){
        //ファイルを出力するフォルダの作成
        File temppath=new File(Environment.getExternalStorageDirectory().getPath() + "/"+"TESTFILE");
        //File temppath=new File(getFilesDir(), "TESTFILE");
        if (temppath.exists() != true){
            temppath.mkdirs();
            Toast.makeText(this, "cleate", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Oready", Toast.LENGTH_LONG).show();
        }
        //ファイルをオープン
        File tempfile =new File(temppath,"Subcode.txt");
        FileWriter output =null;
        try{
            output =new FileWriter(tempfile,true);
            //書き込む!!
            output.write(contents);
            output.write("\n");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(output !=null){
                try{
                    output.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    //ファイルの読み込みクラス
    private void readFile(){
        try{
            //Uriからファイルのパスを取得してFileを作成する
            File file =new File(Environment.getExternalStorageDirectory().getPath() + "/"+"TESTFILE");
            mTextFilename.setText(file.getName());
            //FileからReaderクラスを作成
            BufferedReader bufferReader=new BufferedReader(new FileReader(file));
            String StringBuffer;
            String stringText="";
            //一行ずつ読み込みString形式のデータを作成
            while ((StringBuffer=bufferReader.readLine()) != null){
                stringText+=StringBuffer;
            }
            bufferReader.close();
            mTextContents.setText(stringText);
        }catch (MalformedURLException e){
            e.printStackTrace();
            mTextContents.setText(e.toString());
        }
        catch (IOException e){
            e.printStackTrace();
            mTextContents.setText(e.toString());
        }
    }
 */

    /*ボタン旧案
    public void bootstrapDoor1(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[0].choose=true;

    }
    public void bootstrapDoor2(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[1].choose=true;
    }
    public void bootstrapDoor3(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[2].choose=true;
    }
    public void bootstrapDoor4(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[3].choose=true;
    }
    public void bootstrapDoor5(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[4].choose=true;
    }
    public void bootstrapDoor6(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[5].choose=true;
    }
    public void bootstrapDoor7(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[6].choose=true;
    }
    public void bootstrapDoor8(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[7].choose=true;
    }
    public void bootstrapDoor9(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[8].choose=true;
    }
    public void bootstrapDoor10(View view) {
        for(int i=0;i<99;i++){
            door[i].choose=false;
        }
        door[9].choose=true;
    }

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
            //GameCoreActivity.textChange("test", "gamestart", "textView");

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

        void test(View DoorB1) {
            DoorB1.setVisibility(View.INVISIBLE);
        }
    /*
    void textChange(){
        TextView name = getString(R.id.output);
        name.setText(R.string.input);
    }*/
}
