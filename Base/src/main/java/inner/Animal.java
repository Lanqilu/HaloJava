package inner;

/**
 * @author Halo
 * @create 2021/10/29 下午 09:35
 * @description
 */
abstract class Animal {
    public abstract void run();
}

class Cat extends Animal {
    @Override
    public void run() {
        System.out.println("猫在跑");
    }
}

