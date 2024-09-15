class Calculator
{
	int a;

	public int add(int n1, int n2)
	{
		System.out.println("Call me");
		return n1 + n2;
	}
	// Method overloading
	public double add(double n1, int n2)
        {
                System.out.println("Call me");
                return n1 + n2;
        }
}

public class Demo
{
	public static void main(String a[])
	{
		int bv = 34, bz = 15;
		Calculator calc = new Calculator();

		int result = calc.add(bv, bz);
		System.out.println(result);
	}
}
