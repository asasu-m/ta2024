package s_20240630;
/*
 * メソッドのオーバーロード
 * 同じメソッド名で引数の数や種類が違うもので別々の処理が書けること。
 * 例えばhelloでも引数の文字列が一つの場合と二つの場合で別のメソッドとして扱える。
 * この機能は一つのメソッド名で複数の型に対応できるメソッドを作ることができる。
 * (例えばSystem.out.println()これは引数に数字でもＯＫだし文字列でもＯＫ)
 */
public class method_use {
    public static void main(String[] args)
    {
        System.out.println("戻り値void 引数なし文字表示");
        hello();//戻り値void 引数なし文字表示

        System.out.println("戻り値void 引数String一つ 文字表示");
        hello("satou");//戻り値void 引数String一つ 文字表示

        System.out.println("戻り値void 引数string二つ 文字表示");
        hello("asa","yoru");//戻り値void 引数string二つ 文字表示

        System.out.println("戻り値void 引数int一つ 数字表示");
        show_num(10);//戻り値void 引数int一つ 数字表示

        System.out.println("戻り値int 引数なし 数字返す");
        System.out.println(two());//戻り値int 引数なし 数字返す

        System.out.println("戻り値int 引数一つ 数字返す");
        System.out.println(num(14));//戻り値int 引数一つ 数字返す

        System.out.println("戻り値int 引数二つ 数字足す");
        System.out.println(add(10,15));//戻り値int 引数二つ　数字足す


        return;
    }
    //戻り値void 引数なし文字表示
    private static void hello(){
        System.out.println("hello1");
    }
    //戻り値void 引数String一つ 文字表示
    private static void hello(String n)
    {
        System.out.println(n+"Hello2");
    }
    //戻り値void 引数string二つ 文字表示
    private static void hello(String n1, String n2)
    {
        System.out.println(n1+" "+n2+"Hello3");
    }
    //戻り値void 引数int一つ 数字表示
    private static void show_num(int num)
    {
        System.out.println("show_num():"+num);
    }
    //戻り値int 引数なし　数字返す
    private static int two()
    {
        return 2;
    }
    //戻り値int 引数一つ 数字返す
    private static int num(int num)
    {
        return num;
    }
    //戻り値int 引数二つ　数字足す
    private static int add(int num1,int num2)
    {
        return num1+num2;
    }
    
}
