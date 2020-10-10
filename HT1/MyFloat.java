package lab1;

public class MyFloat
{
	public long mantissa;
	public long exponent;
	private long myInt;
	private long myFract;

	public MyFloat(long mantissa, long exponent)
	{
		this.mantissa = mantissa;
		this.exponent = exponent;
		split();
	}

	private void split()
	{
		this.myInt = (long)(this.mantissa / Math.pow(10, this.exponent));
		this.myFract = (long)(this.mantissa % Math.pow(10, this.exponent));
	}

	public void sum(MyFloat b)
	{
		long resultExp = this.exponent;
		if (b.exponent > this.exponent) 
		{
			this.mantissa *= (long)(Math.pow(10, b.exponent - this.exponent));
		    resultExp += b.exponent - this.exponent;
		} 
		else if (b.exponent < this.exponent)
		{
			b.mantissa *= (long)(Math.pow(10, this.exponent - b.exponent));
		}
		
		this.mantissa += b.mantissa;
		this.exponent = resultExp;
		
	}

	public void sub(MyFloat b)
	{
		long resultExp = this.exponent;
		if (b.exponent > this.exponent) 
		{
			this.mantissa *= (long)(Math.pow(10, b.exponent - this.exponent));
		    resultExp += b.exponent - this.exponent;
		} 
		else if (b.exponent < this.exponent)
		{
			b.mantissa *= (long)(Math.pow(10, this.exponent - b.exponent));
		}
		
		this.mantissa -= b.mantissa;
		this.exponent = resultExp;
	}

	public void out()
	{
		char[] ch = Long.toString(this.mantissa).toCharArray();
		for (long i = 0; i<(long)ch.length; i++)
		{
			System.out.print(ch[(int)i]);
			if (i == ((long)ch.length - this.exponent - 1))
			{
				System.out.print(",");
			}
		}
		System.out.println();
	}

	public long getMyInt()
	{
		return myInt;
	}
	public long getMyFract()
	{
		return myFract;
	}
}