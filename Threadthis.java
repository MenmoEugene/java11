/*
ͬ�������õ�����һ�����أ�
������Ҫ��������ã���ô��������һ������������ã�����this��
����ͬ������ʹ�õ�����this��

ͨ���ó��������֤��
	ʹ�������߳�����Ʊ
	һ���߳���ͬ���������
	һ���߳��Ӱ�ͬ��������
	����ִ����Ʊ������
*/
class Ticket implements Runnable
{
	private int tick = 100;
	boolean flag = true;
	public void run()
	{
		if(flag)
		{
			while(true)
			{
				synchronized(this)
				{
					if(tick>0)
					{
						try{Thread.sleep(10);}catch(Exception e){}
						System.out.println(Thread.currentThread().getName()+"code"+tick--);
					}
				}
			}
		}else
			while(true)
					show();
	}
		public synchronized void show(){
			if(tick>0)
			{
				try{Thread.sleep(10);}catch(Exception e){}
				System.out.println(Thread.currentThread().getName()+"show"+tick--);
			}
		}
}

class Threadthis
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}
		t.flag = false;
		t2.start();
	}
}