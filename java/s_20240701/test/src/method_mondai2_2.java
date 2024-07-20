import java.util.Random;
import java.util.Scanner;

public class method_mondai2_2
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
    static int enemyHP[];//敵の体力
    public static void main(String[] args)
    {
        summonPlayer();
        summonEnemy();
        show();
        field("平和な草原");

        return;
    }
    /*
     * バトルシーン
     */
    public static void battle()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("モンスターが現れた!!");
        while(true)
        {
            show();
            System.out.print("1:攻撃. 2:逃げる");
            int choice=sc.nextInt();
            if(choice==1)
            {
                enemyshow();
                System.out.println("どのモンスターに攻撃しますか？");
                

            }
        }
        

    }
    public static void enemyshow()
    {
        /*
         * 以下のような出力にする(下のshow()メソッドを参考にしてください。
         * モンスター1:「(モンスターの名前)」 HP:10
         */
    }
    /*
     * 一覧表示
     */
    public static void show()
    {
        for(int i=0;i<PLAYERCNT;i++)
        {
            System.out.println("勇者："+(i+1)+":"+playerName[i]+" HP:"+playerHP[i]);
        }
        
        for(int i=0;i<ENEMYCNT;i++)
        {
            System.out.println("モンスター："+(i+1)+":"+enemyName[i]+" HP:"+enemyHP[i]);
        }
        
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
        System.out.println("ーーモンスター召喚ーー");
        enemyName=new String[ENEMYCNT];
        enemyHP=new int[ENEMYCNT];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<ENEMYCNT;i++)
        {
            System.out.print((i+1)+"番目のモンスターの名前:");
            String name = sc.next();
            enemyName[i]=name;
            enemyHP[i]=10;

        }
        for(int i=0;i<ENEMYCNT;i++)
        {
            System.out.println("名前："+enemyName[i]+"を召喚した");
        }
    }
    public static void hello()
    {
        System.out.println("hello");
    }

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
}