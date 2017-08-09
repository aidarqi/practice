package com.aidar.thread_test;

/**
 * @desc 调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。它跟sleep方法类似，同样不会释放锁。
 *       但是yield不能控制具体的交出CPU的时间，另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。
 *       调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的。
 * @date 17-7-10
 */
public class YieldTest {
    public static void main(String[] args) {
        YieldTest yieldTest = new YieldTest();
        MyThread t= yieldTest.new MyThread();
        t.start();
    }

    public class MyThread  extends Thread{
        @Override
        public void run() {
            long beginTime=System.currentTimeMillis();
            int count=0;
            for (int i=0;i<50000;i++){
                count=count+(i+1);
                Thread.yield();
            }
            long endTime=System.currentTimeMillis();
            System.out.println("用时："+(endTime-beginTime)+" 毫秒！");
        }
    }
}
