package utilities;

public class MyMethods {
    public static void myWait(int time){
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
