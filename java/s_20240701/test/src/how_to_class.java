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
    /*
     * Monsterクラスの実体monster1(HPが10でMPが10で名前がスライム)のtojoMonster()メソッドが呼ばれている
     * つまり、Monsterクラスの変数HPに10 MPに10 Nameにスライムが入ったMonsterクラスのtojoMonster()メソッドがよばれている。
     * ちなみにmain関数の中ではMonsterの実体が二つできている。(スライムとゴーレム)
     */


}
/*
     * 以下に記述する Monster(int HP,int MP,String Name)は引数ありのコンストラクタといいます。
     * コンストラクタとはクラスが生成されるときの一番最初に呼び出される処理です。
     * ここではモンスターを生成したときに必要な情報を、生成したモンスタークラスの骨組みに内容を追加していきます。
     * 例えばこのクラスを生成する前はモンスターという変数名はありますが実際の名前は入っていません。
     * そこでモンスターを生成したときに名前を付けます。そのことによってスライムならスライム。ゴーレムならゴーレムというモンスター名を持った
     * クラス、モンスターができます。
     */
    /*
     * (20240706追記)
     * クラスとは、ゲームでいう勇者みたいなものである。
     * 例えば勇者には体力があり、攻撃力もある。そして必殺技をもっていたりする。
     * この体力と攻撃力がステータス(値)(情報)であり、必殺技は動作(メソッド)である。
     * 体力と攻撃力は例えばint HP,int ATKのように変数で表すことができる。
     * ただ、必殺技は、変数としてあらわすことができない。たとえばint gigaslushとしても
     * その変数に何を入れたらいいのかわからない。なぜなら、必殺技は情報ではなく動作だからだ。
     * そのため、書くとしたら、メソッドとして、
     * public static void gigaslush(){
     *      System.out.println("勇者はギガスラッシュを放った");
     * }
     * このような動作(どのように勇者は行動するのか)をメソッドという。
     * そして、それらの動作(メソッド)と情報(変数)をまとめたものをクラスという。
     * 
     * コンストラクタとは
     * mainの中でMonster monster1 = new Monster(10,10,"スライム");//クラスの生成(コンストラクタが呼ばれる)
     * とあるが、このnew Monster(10,10,"スライム")というのが実行されたときに
     * コンストラクタMonster(int HP,int MP,String Name)が一番最初に自動的に呼ばれる。
     * このmainの中でnewしたときに一番最初に呼ばれるものをコンストラクタという。
     * ちなみにこのMonsterクラスではnew Monster()などのように引数なしのものっはえらーになる。
     * なぜなら引数なしのコンストラクタが記述されていないからだ。
     * もし引数なしでもよびだせるようにしたいならば
     * 下のMonsterクラスに
     * Monster(){
     * }
     * というのを記述してやらないといけない。
     */
class Monster{
    int HP;//〇1
    int MP;
    String Name;
    
    Monster(int HP,int MP,String Name)
    {
        //this.HPはこのクラスのHP。つまり〇1のHPのことです。ただのHPは引数のHPです。
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