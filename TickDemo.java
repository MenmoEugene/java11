/*
���󣺼򵥵���Ʊ����
�������ͬʱ��Ʊ��

�����̵߳ĵڶ��ַ�ʽ��ʵ��Runnable�ӿ�

���裺
1��������ʵ��Runnable�ӿ�
2������Runnable�ӿ��е�run����
		���߳�Ҫ���еĴ������ڸ�run�����С�

3��ͨ��Thread�ཨ���̶߳���

4����Runable�ӿڵ����������Ϊʵ�ʲ������ݸ�Thread��Ĺ��캯����
		ΪʲôҪ��Runnable�ӿڵ�������󴫵ݸ�Thread�Ĺ��캯����
		��Ϊ�Զ����run���������Ķ�����Runable�ӿڵ��������
		����Ҫ���߳�ȥָ�������run�������ͱ�����ȷ��run������������

5������Thread���start���������̲߳�����Runnable�ӿ������run������

ʵ�ַ�ʽ�ͼ̳з�ʽ��ʲô���𣿣����Ծ�������

ʵ�ַ�ʽ�ĺô��������˵��̳еľ����ԡ�
�ڶ����߳�ʱ������ʹ��ʵ�ַ�ʽ��

���ַ�ʽ������
�̳�Thread���̴߳�������Thread����run�����С�
ʵ��Runnable,�̴߳�����ڽӿڵ������run�����С�
*/

class Ticket implements Runnable
{
	private int tick =100;
	public void run()
	{
		while (true)
		{
			if(tick<0)
				break;
			
				System.out.println(Thread.currentThread().getName()+"...sale..."+tick--);
			
		}
	}
}
class TickDemo 
{
	public static void main(String[] args) 
	{
		Ticket t = new Ticket();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
