import java.util.Random;
import java.util.Scanner;

public class method_mondai2_2
{
    final static int ALL_DEAD=-1;//すべての敵が死んでいる
    final static int ALLIVE=1;//生きている敵がいる
    //finalは変更できない値(定数)。値を変更しようとするとエラーになる
    //mainメソッドを含むクラスの変数やメソッドは基本staticをつける。(mainメソッドの中以外で作成したもの。
    final static int ENEMY_NUM=3;//敵の種類の数
    final static int PLAYER_NUM=4;//味方の種類の数
    final static int ENEMYCNT=1;//出現する敵の数
    final static int PLAYERCNT=1;//出現する味方の数(主人公含む)
    static String enemyName[];//敵の名前
    static String playerName[];//味方の名前
    static int playerHP[];//味方の体力
    static int enemyHP[];//敵の体力
    static int enemy_shutugen_persent;//敵の出現確率(最低0-最高10)
    static int playerXP[];
    public static void main(String[] args)
    {
        summonPlayer();
        summonEnemy();
        show();
        field("平和な草原",0);
        field("荒野",5);
        return;
    }
    /*
     * バトルシーン
     */
    public static void battle()
    {
        enemy_toujou();
        Scanner sc = new Scanner(System.in);
        System.out.println("モンスターが現れた!!");
        show();
        System.out.print("1:攻撃. 2:逃げる");
        int choice=sc.nextInt();
        if(choice==1)
        {
            while(true)
            {
                enemyshow();
                System.out.println("どのモンスターに攻撃しますか？");
                int enemySelect=sc.nextInt();
                if(!(enemySelect>0&&enemySelect<=ENEMYCNT))
                {
                    System.out.println("勇者は攻撃を外してビビって逃げた。");
                    break;
                }
                enemySelect--;
                System.out.println("勇者の攻撃："+enemyName[enemySelect]+"に10ダメージ!!");
                enemyHP[enemySelect]-=10;
                if(check_All_DEAD_ENEMY()==ALL_DEAD)
                {
                    System.out.println("すべての敵を倒した");
                    keikenti();
                    System.out.println("ーー戦闘終了ーー");
                    break;
                }
            }

        }else if(choice==2)
        {
            System.out.println("勇者は逃げた。");
        }
        return;
    }
    public static void enemy_toujou()
    {
        for(int i=0;i<ENEMYCNT;i++)
        {
            enemyHP[i]=10;

        }
    }
    public static void keikenti()
    {
        /*
         * 勇者のパーティー全員に10経験値を足してください。
         * 勇者のパーティ全員は繰り返しを使う
         * for(int i=0;i<PLAYERCNT;i++)
         * {
         * }
         */
        System.out.println("勇者は10の経験値を得た。");
        return;
    }
    public static int check_All_DEAD_ENEMY()
    {
        for(int i=0;i<ENEMYCNT;i++)
        {
            if(enemyHP[i]>0)
            {
                return ALLIVE;
            }
        }
        return ALL_DEAD;
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
        //追加
        playerXP=new int[PLAYERCNT];
        //
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<PLAYERCNT;i++)
        {
            System.out.print((i+1)+"番目の勇者の名前:");
            String name = sc.next();
            playerName[i]=name;
            playerHP[i]=10;
            //追加
            playerXP[i]=0;
            //

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

    public static void field(String fieldname,int syutugenkakuritu)
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
                Random rnd = new Random();
                int kakuritu=rnd.nextInt(10);
                if(syutugenkakuritu>kakuritu)
                {
                    battle();
                }
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