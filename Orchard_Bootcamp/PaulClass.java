public class PaulClass{
	int moneyInPocket;
	double koboInPocket;
	float piePaulo;
	char pauloCharacter;
	boolean paulSincerity;

	public PaulClass(){
		System.out.println("Money In Pocket:"+this.moneyInPocket);
		System.out.println("Add more money:"+(this.moneyInPocket + 10000013));

		//work on piePaulo
		System.out.println("Paul piePaulo:"+this.piePaulo);
		System.out.println("Paul piePaulo:"+(this.piePaulo + 3.51));
	}

	public static void main(String[] ar){
		System.out.println("This is the entry point");
		PaulClass paulClass = new PaulClass();
		System.out.println("Paul Object1 name:"+paulClass);
		System.out.println();
		System.out.println("Kobo In Pocket:"+paulClass.koboInPocket);
		System.out.println("Add kobo in Pocket:"+(paulClass.koboInPocket+4.5673));

		//pauloCharacter;
		System.out.println("pauloCharacter name:"+(paulClass.pauloCharacter));
		System.out.println("pauloCharacter name:"+(paulClass.pauloCharacter + 5));
		//paulSincerity;
		System.out.println("paulSincerity status:"+(paulClass.paulSincerity));
		System.out.println("paulSincerity status:"+(!paulClass.paulSincerity));
	}
}

