/*
 * クラスについて
 * クラスとはいわば設計図です。
 * どんなものをつくるかを骨組みを作ります。
 * ここではMonsterクラスを作ります。
 */
public class how_to_class {
    public static void main(String[] args)
    {
        Monster monster1 = new Monster(10,10,"スライム");//クラスの生成(コンストラクタが呼ばれる)
        monster1.tojoMonster();
        Monster monster2 = new Monster(20,2,"ゴーレム");
        monster2.tojoMonster();
        return;

    }


}

class Monster{
    int HP;//〇1
    int MP;
    String Name;
    /*
     * 以下に記述する Monster(int HP,int MP,String Name)は引数ありのコンストラクタといいます。
     * コンストラクタとはクラスが生成されるときの一番最初に呼び出される処理です。
     * ここではモンスターを生成したときに必要な情報を生成したモンスタークラスの骨組みに内容を追加していきます。
     * 例えばこのクラスを生成する前はモンスターという変数名はありますが実際の名前は入っていません。
     * そこでモンスターを生成したときに名前を付けます。そのことによってスライムならスライム。ゴーレムならゴーレムというモンスター名を持った
     * クラス、モンスターができます。
     */
    Monster(int HP,int MP,String Name)
    {
        //this.HPはこのクラスのHP。つまり〇1のHPのことです。
        this.HP=HP;
        this.MP=MP;
        this.Name=Name;
    }
    public void tojoMonster()
    {
        System.out.println(this.Name+"が現れた!!"+"HP:"+this.HP+" MP:"+this.MP);
        return;
    }
}