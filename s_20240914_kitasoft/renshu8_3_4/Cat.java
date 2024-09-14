public class Cat extends Animal
{
    public void Sleep()
    {
        //スースーと表示
        return;
    }


    /*
     * 親クラスのメソッドを上書きするときは
     * わかりやすいように@Overrideをつける
     * これをつけることによって
     * 親クラスのメソッドを上書きしようとして
     * もし小クラスのメソッド名が親クラスのメソッド名と違った場合
     * エラーが出て教えてくれる。
     */


    @Override
    public void Speak()
    {
        System.out.println("ニャー");
        return;
    }
}