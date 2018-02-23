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
    };
    Database database;
    Game game = new Game(subcode);
    Door[] door = new Door[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        database = new Database(this);
        for (int i = 0; i < 99; i++) {
            door[i] = new Door(i + 1, subcode);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_core);
        TextView game_core = this.findViewById(R.id.textView);
        String game_core_view = getString(R.string.game_core, game.select);
        game_core.setText(game_core_view);
        switch (game.stage) {
            case 1:
                game.GameStart();
                break;
            case 2:
                game.FirstChoice();
                break;
            case 3:
                game.FinalChoice();
                break;
        }

    }

    //public void writeing(View view) {game_core.setText(Database.reading());}


    void screenUpdate() {
        TextView game_core = this.findViewById(R.id.textView);
        String game_core_view = getString(R.string.game_core, game.select);
        game_core.setText(game_core_view);
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
    */
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
    int stage;//現在の段階
    int dummy;//プレイヤーが1回目で正解のドアを選んだ際に指定される不正解のドア
    int score = 0;//現在のプレイヤーのスコア
    Subcode subcode;

    Game(Subcode subcode) {
        select = 0;
        this.subcode = subcode;
    }

    //スタート
    void GameStart() {
    }

    //1回目のドア選択
    void FirstChoice() {
        firstId = subcode.idSearch();
    }

    //最後のドア選択
    void FinalChoice() {

    }

    void StageClear() {
    }

    void GameSet() {
        String finalscore = String.valueOf(score);
        subcode.writeing(finalscore);

    }

    void GameOver() {
    }
}

class Door {
    final int id;//ドアの固有ID
    boolean choose = false;//プレイヤーはこのドアを選んだか?
    boolean open = false;//結局ドアは今空いているのか?
    boolean correct = false;//これは正解のドアか?
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
}
/*
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