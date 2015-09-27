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
		else if(max <= str.length())
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
}
