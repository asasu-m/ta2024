public class CoinCase
{
    private int maisu_500;
    private int maisu_100;
    private int maisu_50;
    private int maisu_10;
    private int maisu_5;
    private int maisu_1;
    CoinCase()
    {
        maisu_500=0;
        maisu_100=0;
        maisu_50=0;
        maisu_10=0;
        maisu_5=0;
        maisu_1=0;
    }
    public void AddCoins(int coin_type,int coin_maisu)
    {
        switch(coin_type)
        {
            case 500:
                maisu_500+=coin_maisu;
                break;
            case 100:
                maisu_100+=coin_maisu;
                break;
            case 50:
                maisu_50+=coin_maisu;
                break;
            case 10:
                maisu_10+=coin_maisu;
                break;
            case 5:
                maisu_5+=coin_maisu;
                break;
            case 1:
                maisu_1+=coin_maisu;
                break;
            default:
                System.out.println("追加するコインの種類が不適切です。不正な値:AddCoins()");
        }
        return;
    }
    public int GetCount(int coin_type)
    {
        switch(coin_type)
        {
            case 500:
                return maisu_500;
            case 100:
                return maisu_100;
            case 50:
                return maisu_50;
            case 10:
                return maisu_10;
            case 5:
                return maisu_5;
            case 1:
                return maisu_1;
            default:
                System.out.println("指定するコインの種類が不適切です。不正な値:AGetCount(int coin_type)");
                return -1;
        }
    }
    
    public int GetAmount()
    {
        int sum_500=500*maisu_500;
        int sum_100=100*maisu_100;
        int sum_50=50*maisu_50;
        int sum_10=10*maisu_10;
        int sum_5=5*maisu_5;
        int sum_1=1*maisu_1;
        int sum=sum_500+sum_100+sum_50+sum_10+sum_5+sum_1;
        return sum;
    }
    /*
     * GetCount():全ての硬貨の枚数を取得()合計枚数
     */
    public int GetCount()
    {
        int sum_maisu=0;
        //TODO:sum_maisuに全ての硬貨の枚数を計算して代入。


        return sum_maisu;
    }
    /*
     * 指定した種類の硬貨の総額を取得する、
     * 引数のある GetAmount メソッド.
     * 
     */
    public int GetAmount(int coin_type)
    {
        int sum_coin_type=0;//指定した種類の硬貨の総額

        switch(coin_type)
        {
            case 500:
                //500円玉のみの金額(合計):計算
                return sum_coin_type;
            case 100:
                //100円玉のみの金額(合計):計算
                return sum_coin_type;
            case 50:
                //50円玉のみの金額(合計):計算
                return sum_coin_type;
            case 10:
                //10円玉のみの金額(合計):計算

                return sum_coin_type;
            case 5:
                //5円玉のみの金額(合計):計算

                return sum_coin_type;
            case 1:
                //1円玉のみの金額(合計):計算

                return sum_coin_type;
            default:
                System.out.println("指定するコインの種類が不適切です。不正な値:GetAmount()");
                return -1;
        }
    }
}