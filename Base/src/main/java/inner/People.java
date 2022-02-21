package inner;

/**
 * @author Halo
 * @create 2021/10/29 下午 09:04
 * @description
 */
class People {
    private int heartbeat = 150;

    public class Heart {
        private int heartbeat = 110;

        public void show() {
            int heartbeat = 78;
            System.out.println(heartbeat); // 78
            System.out.println(this.heartbeat); // 110
            System.out.println(People.this.heartbeat); // 150
        }
    }
}

