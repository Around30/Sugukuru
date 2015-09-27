package jp.ac.hal.Util;

public class Ic
{
	public static String stringNullable(String str)
	{
		if(str == null || str.isEmpty())
		{
			return null;
		}
		else
		{
			return str;
		}
	}
	
	public static String stringNullable(String str, int max)
	{
		if(str == null || str.isEmpty())
		{
			return null;
		}
		else if(max < str.length())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return str;
		}
	}
	
	public static String stringNullable(String str, int max, int min)
	{
		if(str == null || str.isEmpty())
		{
			return null;
		}
		else if(str.length() < min || max < str.length())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return str;
		}
	}
	
	public static String stringNotNullable(String str)
	{
		if(str == null || str.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return str;
		}
	}
	
	public static String stringNotNullable(String str, int max)
	{
		if(str == null || str.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		else if(max < str.length())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return str;
		}
	}
	
	public static String stringNotNullable(String str, int max, int min)
	{
		if(str == null || str.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		else if(str.length() < min || max < str.length())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return str;
		}
	}
	
	public static Integer intNullable(String str)
	{
		if(str == null || str.isEmpty())
		{
			return null;
		}
		else
		{
			return Integer.parseInt(str);
		}
	}

	public static Integer intNotNullable(String str)
	{
		if(str == null || str.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		else
		{
			return Integer.parseInt(str);
		}
	}
}
