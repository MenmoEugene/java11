/*
�������ģʽ��


����ʽ
class Single
{
	private static final Single s = new Single();
	private Single(){}
	public static Single getInstance()
	{
		return s;
	}
}


*/
//����ʽ(������ �ӳټ��ص������ģʽʾ��)
class Single
{
	private Single s = null;
	private Single(){}
	public Single getInstance()
	{
		if(s==null)
		{
			synchronized(Single.class)
			{
				if (s==null)
					s = new Single();
			}
		}
		return s;
	}
}
class SingleDemo
{
	public static void main(String[] args) 
	{
		System.out.println("�������ģʽ");
	}
}
