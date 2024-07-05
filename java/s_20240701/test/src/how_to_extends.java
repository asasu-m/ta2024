

public class how_to_extends {
    public static void main(String[] args)
    {
        Hero hero = new Hero("Hayashi","戦士");  
        hero.show();
    }
}
class Human{
    String Name;
    int HP;
    int MP;
    int ATK;
    int DEF;
    int AGI;
    Human(String Name){
        this.Name=Name;
        this.HP=10;
        this.MP=10;
        this.ATK=4;
        this.DEF=4;
        this.AGI=3;
    }
    public void show()
    {
        System.out.println("私の名前は"+this.Name+"です");
        return;
    }
}
/*
 * extends 継承
 * Humanクラスの変数とメソッドを持っている。(継承している)
 * 人間の勇者を作成している。
 * 勇者なので特別な職業を持っている
 * @Overrideは親クラス(Human)のshowを上書き(Override)している。
 * これを書くことによって、上書きしていることがわかり、逆に親クラスにないクラスを@Overrideすると
 * エラーを出してくれるため、上書きしていることをわかりやすくするためのもの
 * super()は親クラスのこと
 * ここではsuper(Name)=Human(String Name)→Humanのコンストラクタ(引数文字列一つ)
 * super.show()=Human.show()→親クラス(Human)のshow()メソッドを呼び出している。
 */
class Hero extends Human{
    String Job;
    Hero(String Name,String Job){
        super(Name);
        this.Job=Job;
    }

    @Override
    public void show()
    {
        /*
         * 実行すると
         * "私の名前は"+this.Name+"です"
         * "職業は"+this.Job+"です"
         * となる。
         * super.show()に
         * System.out.println("私の名前は"+this.Name+"です");
         * が入る。
         */
        super.show();
        System.out.println("職業は"+this.Job+"です");
        return;
    }

}