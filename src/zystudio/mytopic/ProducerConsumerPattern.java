package zystudio.mytopic;

import java.util.LinkedList;

/**
 * 这是一种实验
 * http://blog.csdn.net/monkey_d_meng/article/details/6251879
 */
public class ProducerConsumerPattern {

    public static void showDemo() {
        work();
    }

    private static void work() {

        // 仓库对象
        Storage storage = new Storage();

        // 生产者对象
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);
        Producer p7 = new Producer(storage);

        // 消费者对象
        Consumer c1 = new Consumer("c1_50", storage);
        Consumer c2 = new Consumer("c2_20", storage);
        Consumer c3 = new Consumer("c3_30", storage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }

    private static class Storage {

        private final int MAX_SIZE = 100;

        private LinkedList<Object> list = new LinkedList<>();

        public void produce(int num) {

            synchronized (list) {
                while (list.size() + num > MAX_SIZE) {
                    System.out.println("要生产的产品数量: " + num + ",库存量:" + list.size() + ",暂时不能执行生产任务!");

                    try {
                        System.out.println(" produce wait occured");
                        list.wait();
                        System.out.println(" produce wait release occured");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //生产条件满足的情况下,生产num个产品
                for (int i = 1; i <= num; ++i) {
                    list.add(new Object());
                }

                System.out.println("已经生产的产品数:" + num + ",现仓数量为:" + list.size());
                list.notifyAll();
                System.out.println(" produce notifyAll occured");
            }
        }

        public void consume(int num) {
            //同步代码段
            synchronized (list) {

                while (list.size() < num) {
                    System.out.println("要消费的产品数量:" + num + ",库存量:" + list.size() + ",暂时不能执行生产任务");
                    try {
                        //由于条件不满足,消费阻塞
                        System.out.println("consume " + Thread.currentThread().getName() + " wait occured");
                        list.wait();
                        System.out.println("consume " + Thread.currentThread().getName() + " wait release occured");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (int i = 1; i < num; ++i) {
                    list.remove();
                }

                System.out.println("已经消费产品数:" + num + ", 现仓存储量为:" + list.size());
                list.notifyAll();
                System.out.println("consume notifyAll occured");
            }
        }

        public LinkedList<Object> getList() {
            return list;
        }

        public void setList(LinkedList<Object> list) {
            this.list = list;
        }

        public int getMAX_SIZE() {
            return MAX_SIZE;
        }
    }

    private static class Producer extends Thread {
        private int num;
        private Storage storage;

        public Producer(Storage storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            produce(num);
        }

        public void produce(int num) {
            storage.produce(num);
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Storage getStorage() {
            return storage;
        }

        public void setStorage(Storage storage) {
            this.storage = storage;
        }
    }

    private static class Consumer extends Thread {

        private int num;

        private Storage storage;

        public Consumer(String name, Storage storage) {
            this.setName(name);
            this.storage = storage;
        }

        @Override
        public void run() {
            consume(num);
        }

        public void consume(int num) {
            storage.consume(num);
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Storage getStorage() {
            return storage;
        }

        public void setStorage(Storage storage) {
            this.storage = storage;
        }

    }


}
