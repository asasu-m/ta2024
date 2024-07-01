package java.s_20240630;

public class toi4 {
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
class Hero extends Human{
    String Job;
    Hero(String Name,String Job){
        super(Name);
        this.Job=Job;
    }

    @Override
    public void show()
    {
        System.out.println("私の名前は"+this.Name+"です。職業は"+this.Job+"です");
        return;
    }

}