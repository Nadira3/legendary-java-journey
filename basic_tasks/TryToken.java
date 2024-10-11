import java.util.*;

class TryToken
{
	public static void main (String[] args)
	{
		String s1 = "Hello how are you";
		String s2 = "   Hello how are you  ";
		String s3 = "Hello       how are       you";

		StringTokenizer st1 = new StringTokenizer(s1, " ");
		StringTokenizer st2 = new StringTokenizer(s2, " ");
		StringTokenizer st3 = new StringTokenizer(s3, " ");

		System.out.println(st1);
		List<String> st1_list = new ArrayList<>();
		while (st1.hasMoreTokens())
		{
			st1_list.add(st1.nextToken());
		}
		System.out.println(st1_list);
	}
}
