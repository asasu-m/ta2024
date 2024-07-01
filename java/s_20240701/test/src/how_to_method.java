
/*
メソッドについての説明、
メソッドはある一連の処理のまとまりを一つの機能として実装するものです。
例えば、手を洗う、ご飯を食べるなどです。
手を洗うにしても、蛇口をひねる、水が出る、手を洗う。蛇口を閉めることをしなければいけません
そういう一連の動作をメソッドとして作成します。

以下の例は、文字をゆっくり表示するプログラムです。
文字をゆっくり表示するにしても、その文字の内容を決めなければいけません。
それをメソッドで引数としてゆっくり表示する文字を渡してあげて、表示します。
*/
public class how_to_method {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		slow_str("勇者は荒野を歩いている。。。。");
	}
	private static void slow_str(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			System.out.print(s.charAt(i));
			try
			{
				Thread.sleep(100);
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
	}
}
