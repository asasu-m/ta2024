
/*
 * メソッドとは(20240706追記)
 * メソッドは動作のことである。
 * 例えば、勇者の攻撃などである。
 * これを変数として int Attack;と書いても攻撃力がわかるだけで実際に攻撃してるかはわからない。
 * 例えば攻撃するなら
 * public static void Attack()
 * {
 * 		System.out.println("勇者は攻撃した");
 * }
 * などのように書かないといけない。
 * ではなぜ、メソッドを使わないといけないのか？
 * それは、複雑なプログラムは別として、簡単なプログラムでは、名前を付けたほうがわかりやすいからだ。
 * たとえば
 * 相手に10ダメージ５ダメージ４ダメージの三回攻撃してHPをそのダメージ分減らすとする
 * すると
 * 一回メソッドを作っておくと以下のような文章
 * System.out.println("勇者は攻撃した");
 * System.out.println("勇者は10ダメージ与えた");
 * EnemyHP=EnemyHP-10;
 * System.out.println("勇者は攻撃した");
 * System.out.println("勇者は5ダメージ与えた");
 * EnemyHP=EnemyHP-5;
 * System.out.println("勇者は攻撃した");
 * System.out.println("勇者は4ダメージ与えた");
 * EnemyHP=EnemyHP-4;
 * を次のようなメソッドを作り
 * public static void Attack(int ATK,int EnemyHP)
 * {
 * 		System.out.println("勇者は攻撃した");
 * 		System.out.println("勇者は"++ATK"ダメージ与えた");
 * 		EnemyHP=EnemyHP-ATK;
 * 		return;
 * }
 * これをmainメソッドの中で使うと
 * Attack(10,EnemyHP);
 * Attack(5,EnemyHP);
 * Attack(4,EnemyHP);
 * このようになりとても分かりやすい。
 * これがメソッドの利点である。(一度作っておくと何回でも使える。しかも攻撃力を変えて。)
 */

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
