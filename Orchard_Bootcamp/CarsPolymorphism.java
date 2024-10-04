class Cars{
	public void describeObject(){
		System.out.println("This is a car object");
	}
}

class Ford extends Cars{
	public void carType(){
		System.out.println("A very expensve car");
	}
}

class Mercedes extends Cars{
	public void carType(){
		System.out.println("Affordable and classy!");
	}
}

public class CarsPolymorphism{

	public static void main(String[] ar){
		//instantiate an object
		Cars aCar = new Cars();
		aCar.describeObject();
		Ford firstCar = new Ford();
		firstCar.describeObject();
		firstCar.carType();
		Mercedes secondCar = new Mercedes();
		secondCar.describeObject();
		secondCar.carType();
	}
}

