package java.s_20240630.kita_kotate;
/*
 * メソッド北ソフト工房問題6-6~6-8
 */
public class kotae{

    public static void main(String[] args)
    {
        kuku();//6-6
        System.out.println();
        System.out.println();
        System.out.println();
        sosuu();//6-7
        System.out.println();
        System.out.println();
        System.out.println();
        fibonacchi(1, 1, 2);//6-8
        return;
    }
    private static void kuku()//6-6
    {
        for(int i=1;i<=9;i++)
        {
            for(int j=1;j<=9;j++)
            {
                System.out.printf("%3d",i*j);
            }
            System.out.println();
        }
        return;
    }
    private static void sosuu()//6-7
    {
        System.out.println("10000-10100の間の素数は");
        System.out.println();
        int i,j;
        for(i=10000;i<=10100;i++)
        {
            for(j=2;j<i;j++)
            {
                if(i%j==0)
                {
                    break;
                }
            }
            if(i==j)
            {
                System.out.println(i);
            }
        }
        return;
    }
    private static void fibonacchi(int n1,int n2,int cnt)//6-8
    {
        
        
        if(cnt>=11&&cnt<20)
        {
            System.out.println(n2);
        }
        else if(cnt>20)
        {
            return;
        }
        cnt++;
        fibonacchi(n2, n1+n2,cnt);
    }
}