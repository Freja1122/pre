/**
 * @program: singleton
 * @description:
 * @author: Annntn
 * @create: 2018-06-29 18:37
 **/

public class Singleton {
    int count = 0;

    public void init(int count) {
        this.count = count;
    }

    static class SingletonInstance {
        public static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public static void main(String[] args) {

//        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
//        for (int i = 0; i < 3; i++) {
//            singletonEnum.a++;
//            System.out.println(singletonEnum.a);
//        }
    }

}

//enum SingletonEnum {
//    INSTANCE;
//    int a;
//}