public class Coinmain
{
    public static void main(String[] args)
    {
        CoinCase coincase=new CoinCase();
        coincase.AddCoins(1,1);//1
        coincase.AddCoins(5,1);//2
        coincase.AddCoins(10,1);//3
        coincase.AddCoins(50,1);//4
        coincase.AddCoins(100,1);//5
        coincase.AddCoins(500,1);//6
        coincase.AddCoins(1,1);//7
        coincase.AddCoins(1,1);//8
        coincase.AddCoins(1,1);//9
        coincase.AddCoins(1,1);//10
        System.out.println("500円："+coincase.GetCount(500)+"枚");
        System.out.println("100円："+coincase.GetCount(100)+"枚");
        System.out.println("50円："+coincase.GetCount(50)+"枚");
        System.out.println("10円："+coincase.GetCount(10)+"枚");
        System.out.println("5円："+coincase.GetCount(5)+"枚");
        System.out.println("1円："+coincase.GetCount(1)+"枚");
        System.out.println("合計金額："+coincase.GetAmount()+"円");
    }
}