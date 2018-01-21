/*
����
������һ����⡣
�����������ֱ�棤300��ÿ�δ棤100����3�Ρ�

Ŀ�ģ��ó����Ƿ��а�ȫ���⣬����и���ô�����

��������⣺
1����ȷ��Щ�����Ƕ��߳����д��롣
2����ȷ�������ݡ� 
3����ȷ���߳����д�������Щ����ǲ����������ݵġ�
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
