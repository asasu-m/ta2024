

/*
 * メソッドの問題1,2,3
 */

public class method_mondai {
    private static final int TOI1=0;
    public static void main(String[] args)
    {
        int sum=add(2,3);
        System.out.println("2+3="+sum);
        //hello()を呼び出してください。

        int n1=5,n2=3;
        int sum2=0;
        //n1+n2を足してsumに代入してください。(addメソッドを使う。)

        System.out.println(n1+"+"+n2+"="+sum2);
        //メソッドsubを作成して、3-1(=2)の計算をして、答えをprintlnで出力してください。
        /*
         * 例：メソッドmultiの場合(掛け算)
         * public static int multi(int n1,int n2)
         * {
         *      return n1*n2;
         * }
         * mainで呼び出すときは
         * int n=multi(3,1);//nには3が代入される。
         */

        return;

    }
    private static int add(int n1, int n2)
    {
        //return文を作成してください。(TOI1は削除する(一時的に仮に書いたものです。))
        return TOI1;
    }
    private static void hello()
    {
        System.out.println("こんにちは!");
        return;
    }
}
