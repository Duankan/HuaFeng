package cn.wtu.etc11304;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.List;

class Zhangsan{
    public void say(){
        System.out.println("张三对李四说：“你给我画，我就把书给你。”");
    }
    public void get(){
        System.out.println("张三得到了画！");
    }
}
class Lisi{
    public void say(){
        System.out.println("李四对张三说：“你给我书，我就把画给你。”");
    }
    public void get(){
        System.out.println("李四得到了书！");
    }
}
public class ThreadDeadlock implements Runnable {
    public static Zhangsan zs = new Zhangsan();
    public static Lisi ls = new Lisi();
    private boolean flag =false;
    ////////////////////////////////

    public static void main(String []args){
        ThreadDeadlock t1 =new ThreadDeadlock();
        ThreadDeadlock t2= new ThreadDeadlock();
        t1.flag=true;
        t2.flag=false;
        Thread tha = new Thread(t1);
        Thread thb =new Thread(t2);
        tha.start();
        thb.start();
    }
    @Override
    public void run() {
        if(flag){
            synchronized (zs){  //几乎这两个线程同时到这，tha抢到zs，thb抢到ls，彼此等待释放各自的锁
                zs.say();
                try {
                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (ls){
                    zs.get();
                }
            }
        }
        else {
            synchronized (ls){
                ls.say();
                try {
//                    Thread.sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (zs){
                    ls.get();
                }
            }
        }
    }
}
