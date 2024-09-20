// class that prints "hello java" to the console
class Greeting
{
    public String sayhello()
    {
        return("Hello, Java!");
    }
}
//checker
class GreetA {
	public static void main(String[] args)
	{
  	  Greeting greet = new Greeting();
  	  String result = greet.sayhello();
    	if (result.equals("Hello, Java!")) {
	    System.out.println("Test Passed!");
   	 } 
	else {
     	   System.out.println("Test Failed!");
 	   }
	}
}


