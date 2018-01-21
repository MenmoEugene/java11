/*
需求：
银行有一个金库。
有两个储户分别存￥300，每次存￥100，存3次。

目的；该程序是否有安全问题，如果有该怎么解决。

如何找问题：
1，明确哪些代码是多线程运行代码。
2，明确共享数据。 
3，明确多线程运行代码中哪些语句是操作共享数据的。
*/
class Bank
{
	private int sum;
	public synchronized void add(int n)
	{
		sum+=n;
		try
		{
			Thread.sleep(10);
		}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+"....sum="+sum);
	}
}
class Save implements Runnable
{
	private Bank b = new Bank();
	public void run()
	{
		for (int x =0; x<3; x++)
		{
			b.add(100);
		}
	}
}

class ThreadBank 
{
	public static void main(String[] args) 
	{
		Save s = new Save();
		
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		t1.start();
		t2.start();
	}
}
