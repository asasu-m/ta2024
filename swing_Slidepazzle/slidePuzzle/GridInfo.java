/*
 * マスの情報とマスの移動の動作について
 * 管理しているクラス
 * そして、マスのクリア判定も管理している
 */
public class GridInfo
{
    private int gridXNum; //マスの横数:4
    private int gridYNum; //マスの縦数:4
    private int gridFlg[][]; //マス情報4,4

    /* コンストラクタ */
    GridInfo(int xNum, int yNum)//xNum:4 yNum:4
    {
	/* 引数から渡されたマスの横幅、縦幅を保存 */
	gridXNum = xNum;
	gridYNum = yNum;

	/* 各マスに置かれているコマを保持する二次元配列を定義 */
	gridFlg = new int[gridXNum][gridYNum];//4,4

	/* 1~15までの数を格納 */
	for(int y = 0; y < gridYNum; y++)//4
	    {
		for(int x = 0; x < gridXNum; x++)//4
		    {
				/*
				 * gridYNum=4
				 * xが横方向。yが縦方向。この場合
				 *  1, 2, 3, 4,
				 *  5, 6, 7, 8,
				 *  9,10,11,12,
				 * 13,14,15,16
				 */
			gridFlg[y][x] = (y * gridYNum) + x + 1;
		    }
	    }

	/* 右下のマスにはコマがないことを意味する0を格納 */
	/*
	 * ここで1~16まで格納したうちの16の配列の内容を0にする。
	 */
	gridFlg[gridYNum - 1][gridXNum - 1] = 0;
    }

    /* コマをシャッフルするメソッド */
    public void shfleTile()
    {
	int clickTileX = 0;
	int clickTileY = 0;
	int clickedTileX = 0;
	int clickedTileY = 0;
	int randNum;
	boolean blnRet = false;

	/* 500回コマを移動させる */
	for(int i=0;i<500;i++)
	    {
		/* コマが置かれていない空いているマスを取得 */
		clickTileX = getEmpGridXNum(); //横位置取得(配列の添字)
		clickTileY = getEmpGridYNum(); //縦位置取得(配列の添字)

		/* 0~3までの数値をランダムに取得 */
		randNum = (int)(Math.random() * 4);

		/* ランダムに得た0~3までの数値を上下左右に対応させて場合分け */
		switch(randNum)
		    {
			/* 右 */
		    case 0:
			/* 空いてあるマスの右にあるコマを移動させる */
			/*
			 * 空いているマスの右側はコマが入っている。
			 * そのコマが入っている位置をmoveTileに渡してあげて、
			 * moveTileではコマが入っている位置から
			 * コマが入っていない位置を探して
			 * 移動させている
			 */
			blnRet = moveTile(clickTileX + 1, clickTileY);//配列の添字を渡す
			clickedTileX = clickTileX + 1;
			clickedTileY = clickTileY;
			break;
			
			/* 左 */
		    case 1:
			/* 空いてあるマスの左にあるコマを移動させる */
			/*
			 * 空いているマスの左側はコマが入っている。
			 * そのコマが入っている位置をmoveTileに渡してあげて、
			 * moveTileではコマが入っている位置から
			 * コマが入っていない位置を探して
			 * 移動させている
			 */
			blnRet = moveTile(clickTileX - 1,clickTileY);
			clickedTileX = clickTileX - 1;
			clickedTileY = clickTileY;
			break;

			/* 下 */
		    case 2:
			/* 空いてあるマスの下にあるコマを移動させる */
			/*
			 * 空いているマスの下側はコマが入っている。
			 * そのコマが入っている位置をmoveTileに渡してあげて、
			 * moveTileではコマが入っている位置から
			 * コマが入っていない位置を探して
			 * 移動させている
			 */
			blnRet = moveTile(clickTileX,clickTileY + 1);
			clickedTileX = clickTileX;
			clickedTileY = clickTileY + 1;
			break;

			/* 上 */
		    case 3:
			/* 空いてあるマスの上にあるコマを移動させる */
			/*
			 * 空いているマスの上側はコマが入っている。
			 * そのコマが入っている位置をmoveTileに渡してあげて、
			 * moveTileではコマが入っている位置から
			 * コマが入っていない位置を探して
			 * 移動させている
			 */
			blnRet = moveTile(clickTileX,clickTileY - 1);
			clickedTileX = clickTileX;
			clickedTileY = clickTileY - 1;
			break;
		    }
			//ここから
		if(blnRet == true)
		    {
			clickTileX = clickedTileX;
			clickTileY = clickedTileY;
			moveTile(clickTileX,clickTileY);
		    }
	    }
		//ここまで。本には書いてあるがおそらく必要ない
		/*
		 * 空いているマスの周りにmoveTileで空いているマスを探している。
		 * しかし、空いているマスは一つのためどこも空いていないため、
		 * 結果的に何も動かさずに終わる。
		 */
    }

    /* コマが置かれていないX座標(論理値)を表すメソッド */
    public int getEmpGridXNum()
    {
	int rx = 0;
	for(int y = 0; y < gridYNum; y++)//gridYNum:4
	    {
		for(int x = 0; x < gridXNum; x++)//gridXNum:4
		    {//空の場所一箇所だけ0。それ以外は1~15が入っている
			if(gridFlg[y][x] == 0)
			    {//そのx座標(配列の添字)を格納
				rx = x;
			    }
		    }
	    }
	/* コマが置かれていない空いているX座標(論理値)を返す */
	return rx;//配列の添字(x座標)
    }

    /* コマが置かれていないY座標(論理値)を返すメソッド */
    public int getEmpGridYNum()
    {
	int ry = 0;
	for(int y = 0; y < gridYNum; y++)
	    {
		for(int x = 0; x < gridXNum; x++)
		    {//空の場所一箇所だけ0。それ以外は1~15が入っている
			if(gridFlg[y][x]==0)
			    {//そのy座標(配列の添字)を格納
				ry = y;
			    }
		    }
	    }
	/* コマが置かれていない空いているY座標(論理値)を返す */
	return ry;//配列の添字(y座標)
    }

    /* コマを空いているマスに移動させるメソッド */
	//clickTileX clickTileYは配列の添字番号
    public boolean moveTile(int clickTileX, int clickTileY)
    {
	boolean blnRet;
	boolean blnExist;
	blnRet = true;
	blnExist = false;
	while(true)
	    {
		/* 右に移動できるか判別 */
		//clickTileX+1:右側。 gridXNum:4 配列は3までなので未満にしている
		if(clickTileX + 1 < gridXNum && clickTileX >= 0 && clickTileY >= 0 && clickTileY < gridYNum)
		    {/*gridFlg[Y座標][X座標]:コマのデータ保持(1~15)
			  *もし右側が空(0)だったら、
			  */
			if(gridFlg[clickTileY][clickTileX + 1] == 0)
			    {//クリックしたところから右側にコマのデータを移動
				gridFlg[clickTileY][clickTileX + 1] = gridFlg[clickTileY][clickTileX];
				blnExist = true;
				break;
			    }
		    }

		/* 左に移動できるか判別 */
		//clickTileX-1:左側。0 配列は0までなので＝を含む
		if(clickTileX - 1 >= 0 && clickTileX < gridXNum && clickTileY >= 0 && clickTileY <gridYNum)
		    {/*gridFlg[Y座標][X座標]:コマのデータ保持(1~15)
			  *もし左側が空(0)だったら、
			  */
			if(gridFlg[clickTileY][clickTileX -1] == 0)
			    {//クリックしたところから左側にコマのデータを移動
				gridFlg[clickTileY][clickTileX - 1] = gridFlg[clickTileY][clickTileX];
				blnExist = true;
				break;
			    }
		    }

		/* 下に移動できるか判別 */
		//clickTileY+1:下側。gridYNum:4 配列は3までなので未満にしている
		if(clickTileY + 1 < gridYNum && clickTileY >= 0 && clickTileX >= 0 && clickTileX < gridXNum)
		    {/*gridFlg[Y座標][X座標]:コマのデータ保持(1~15)
			  *もし下側が空(0)だったら、
			  */
			if(gridFlg[clickTileY + 1][clickTileX] == 0)
			    {//クリックしたところから下側にコマのデータを移動
				gridFlg[clickTileY + 1][clickTileX] = gridFlg[clickTileY][clickTileX];
				blnExist = true;
				break;
			    }
		    }

		/* 上に移動できるか判別 */
		//clickTileY-1:上側。0 配列は0までなので＝を含む
		if(clickTileY - 1 >= 0 && clickTileY < gridYNum && clickTileX >= 0 && clickTileX < gridXNum)
		    {/*gridFlg[Y座標][X座標]:コマのデータ保持(1~15)
			  *もし上側が空(0)だったら、
			  */
			if(gridFlg[clickTileY - 1][clickTileX] == 0)
			    {//クリックしたところから上側にコマのデータを移動
				gridFlg[clickTileY - 1][clickTileX] = gridFlg[clickTileY][clickTileX];
				blnExist = true;
				break;
			    }
		    }
		break;
	    }

	/* クリックされたマスからコマを移動させたら、そのマスを空にする */
	/*
	 * クリックしたところからコマを移動させたのでクリックしたところを空(0)にする
	 * blnExist=trueならコマを移動させたということ
	 * 初期値はfalse
	 */
	if(blnExist == true)
	    {
		gridFlg[clickTileY][clickTileX] = 0;
	    }
	return blnRet;//blnRetを返したらこのメソッドは正常終了。
    }

    /* 引数で指定されたマスに置かれているコマを返すメソッド */
    public int getTileNum(int x,int y)
    {
	return gridFlg[y][x];//gridFlg[Y座標][X座標]その1~15のデータを取り出す。
    }

    /* ゲームクリアを判断するメソッド */
    public boolean getGameClearFlg()
    {
	boolean blnRet;
	blnRet = true;

	for(int y = 0; y < gridYNum; y++)//gridYNum:4
	    {
		for(int x = 0; x < gridXNum; x++)//gridXNum:4
		    {
			/* 右下のマスが空いているかどうかを判断 */
			if(y == gridYNum -1 && x == gridXNum - 1)
			    {//gridFlg[3][3]:右下
				if(gridFlg[y][x] != 0)
				    {
					/* 右下のマスが空いてなかったらfalseを代入 */
					blnRet = false;
				    }
			    }
			/* 数字が整列されているかどうかを判断 */
			else if(gridFlg[y][x] != (y * gridYNum)+ x + 1)
			    {/*
					 1, 2, 3, 4,
					 5, 6, 7, 8,
					 9,10,11,12,
					13,14,15,16
					のどれか違うものがあればfalseをblnRetに代入
					ただし,16については上のif文が実行されるので
					このelseifは実行されない。
					よってこのelse ifは1~15までの判定
					*/
				/* 数字が整列されていなかったらfalseを代入 */
				blnRet = false;
			    }
		    }
	    }
	/* ゲームクリアならtrue、まだならfalseを返す */
	return blnRet;
    }
}
