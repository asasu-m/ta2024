import java.util.Scanner;

public class method_mondai2_1
{
    //finalは変更できない値(定数)。値を変更しようとするとエラーになる
    //mainメソッドを含むクラスの変数やメソッドは基本staticをつける。(mainメソッドの中以外で作成したもの)
    final static int ENEMY_NUM=3;//敵の種類の数
    final static int PLAYER_NUM=4;//味方の種類の数
    final static int ENEMYCNT=1;//出現する敵の数
    final static int PLAYERCNT=1;//出現する味方の数(主人公含む)
    static String enemyName[];//敵の名前
    static String playerName[];//味方の名前
    static int playerHP[];//味方の体力
    int enemyHP[];//敵の体力
    public static void main(String[] args)
    {
        summonPlayer();
        summonEnemy();
        show();
        return;
    }
    public static void show()
    {
        for(int i=0;i<PLAYERCNT;i++)
        {
            System.out.println("勇者："+(i+1)+":"+playerName[i]);
        }
        /* 
        for(int i=0;i<ENEMYCNT;i++)
        {
            System.out.println("モンスター："+(i+1)+":"+enemyName[i]);
        }
        */
        return;
    }
    public static void summonPlayer()//勇者召喚
    {
        System.out.println("ーー勇者召喚ーー");
        playerName=new String[PLAYERCNT];
        playerHP=new int[PLAYERCNT];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<PLAYERCNT;i++)
        {
            System.out.print((i+1)+"番目の勇者の名前:");
            String name = sc.next();
            playerName[i]=name;
            playerHP[i]=10;

        }
        for(int i=0;i<PLAYERCNT;i++)
        {
            System.out.println("名前："+playerName[i]+"を召喚した");
        }
    }
    public static void summonEnemy()//モンスター召喚
    {
        //勇者召喚を見ながら作ってみてください
    }
    public static void hello()
    {
        System.out.println("hello");
    }
    /* 以下は今は気にしなくていいです。
    public static void field(String fieldname)
    {
        try{
            System.out.println("勇者一行は"+fieldname+"に到着した");
            Thread.sleep(2000);
            System.out.println("ーー"+fieldname+"ーー");
            Thread.sleep(2000);
            int cnt=0;
            while(true)
            {
                cnt++;
                walk();
                if(cnt>=10)
                {
                    break;
                }
            }
            System.out.println("勇者一行は"+fieldname+"を抜けた");
        }catch(InterruptedException e){
            System.out.println("field():InterruptedException error:"+e);
        }
        
    }
    public static void walk()
        {
            try{
                System.out.println("勇者一行は歩いている・・");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("walk():InterruptedException error:"+e);
            }
            return;
        }
    */
}