package day12.InterFace5;

public class test {
    public static void main(String[] args) {
        InterImpl ii = new InterImpl();
        ii.start();
        ii.end();

        Inter.open();
        Inter.close();
    }
}

class InterImpl implements Inter {

}