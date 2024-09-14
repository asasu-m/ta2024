public class Dog extends Animal 
{
    public void Run()
    {
        //トコトコという文字を表示
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
        System.out.println("ワンワン");
        return;
    }
}