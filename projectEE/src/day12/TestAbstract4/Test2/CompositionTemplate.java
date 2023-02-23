package day12.TestAbstract4.Test2;

public abstract class CompositionTemplate {
    /*
        作文模板类
    */
    public final void write(){
        System.out.println("<<我的爸爸>>");

        body();

        System.out.println("啊~ 这就是我的爸爸");

    }

    public abstract void body();
}
