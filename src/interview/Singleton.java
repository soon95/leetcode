package interview;

/**
 * 单例模式
 */
public class Singleton {

    private volatile static Singleton instance;


    public Singleton getInstance(){

        if (instance==null){
            synchronized (Singleton.class){
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;

    }




}
