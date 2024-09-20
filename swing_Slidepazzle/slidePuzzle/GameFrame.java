import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class GameFrame extends JFrame implements MouseListener
{
    //ゲーム状態フラグ定数(タイトル画面時)
    private static final int GAME_WAIT = 0;

    //ゲーム状態フラグ定数(ゲーム中)
    private static final int GAME_ING = 1;

    //ボードの横マス数
    private static final int GRID_X = 4;

    //ボードの縦マス数
    private static final int GRID_Y = 4;

    //マスの横幅
    private static final int GRID_WIDTH = 64;

    //マスの縦幅
    private static final int GRID_HEIGHT = 64;

    //ゲーム状態フラグ
    private static int gameFlg;

    //グリッドクラス
    private static GridInfo GInfo;

    private static ImageIcon tileImage[];
    private static JLabel label1[];
	/*
	 * GInfo:4*4のマスのデータを作成
	 * 
	 * tileImage:0~16の大きさ(17)の配列を作成
	 * 画像のデータを保存
	 * 
	 * label1:0~16の大きさ(17)の配列を作成
	 * ウインドウに表示するために
	 * ラベルとして画像を貼り付ける
	 * 
	 * setLayout(null):
	 * ラベルを貼り付けるときのレイアウトを
	 * なしにしている(自分で指定)
	 */
    GameFrame()
    {
	GInfo = new GridInfo(GRID_X, GRID_Y);
	tileImage = new ImageIcon[GRID_X * GRID_Y + 1];
	label1 = new JLabel[GRID_X * GRID_Y + 1];

	this.getContentPane().setLayout(null);

	//1~15までのコマの画像読み込み
	/*
	 * decimalFormat:
	 * 二桁で表示するようにしている:(00,01)
	 * 
	 * tileImage[i]:
	 * blockディレクトリ下の00,01などの
	 * 画像イメージ(拡張子は.png)を
	 * 読み込んでいる
	 * 
	 * label[i]:
	 * 画像イメージをラベルに貼り付けている
	 * 
	 * this.getContentPane().add(label[i]):
	 * ウインドウにラベルを追加している。
	 * このままの状態では一つの場所にすべての画像が
	 * 重なっている。
	 * (レイアウトをなしにしたため。)
	 */
	DecimalFormat decimalFormat = new DecimalFormat("00");
	for(int i = 1; i < GRID_X * GRID_Y; i++)
	    {
		tileImage[i] = new ImageIcon("./block/"+decimalFormat.format(i)+".gif");
		label1[i] = new JLabel(tileImage[i]);

		this.getContentPane().add(label1[i]);
	    }

	//1~15までのコマをボードに配置
	/*
	 * setBoundsで画像を適切な位置に移動させて
	 * 大きさを64にしている。
	 * 
	 * getTileNum(x,y):
	 * 1~15の数字を取り出している
	 * 0(空)の場合は除く
	 */
	for(int y = 0; y < GRID_Y; y++)
	    {
		for(int x = 0; x < GRID_X; x++)
		    {
			if(GInfo.getTileNum(x,y) != 0)
			    {
				label1[GInfo.getTileNum(x,y)].setBounds(x * GRID_WIDTH, y * GRID_HEIGHT, GRID_WIDTH, GRID_HEIGHT);
			    }
		    }
	    }
	//コンテントペインに対するマウスイベントの取得を開始する
	this.getContentPane().addMouseListener(this);
    }

    /* ゲーム初期化メソッド */
    public void gameInit()
    {
	GInfo.shfleTile();
	gameFlg = GAME_ING;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){}

    @Override
    public void mousePressed(MouseEvent e)
    {
	int clickTileX;
	int clickTileY;
	boolean blnRet;

	switch(gameFlg)
	    {
	    case GAME_WAIT:
		System.out.println("GAME START");
		gameInit();//マスをシャッフルする
		break;
		
	    case GAME_ING:
		/* クリック座標からクリックされたコマがおいてあるマスを取得 */
		clickTileX = (int)((e.getX()) / GRID_WIDTH);
		clickTileY = (int)((e.getY()) / GRID_HEIGHT);
		/* コマを移動させる。移動できない場合は何もしない */
		blnRet = GInfo.moveTile(clickTileX,clickTileY);
		/* コマが整列した場合はゲーム終了 */
		blnRet = GInfo.getGameClearFlg();
		if(blnRet == true)
		    {
			/* ゲーム状態フラグを変更 */
			gameFlg = GAME_WAIT;
			System.out.println("GAME OVER");
		    }
		break;
	    }
	/* 描画 */
	/*
	 * 再描画(マスを移動したため)
	 */
	for(int y = 0; y < GRID_Y; y++)
	    {
		for(int x = 0; x <GRID_X; x++)
		    {
			if(GInfo.getTileNum(x,y) != 0)
			    {
				label1[GInfo.getTileNum(x,y)].setBounds(x * GRID_WIDTH, y * GRID_HEIGHT, GRID_WIDTH, GRID_HEIGHT);
			    }
		    }
	    }
	this.setVisible(true);//ウインドウを見えるようにする
    }
    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
}
