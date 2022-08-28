
public class LearnJava2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal();
		String dog = a.iAmDog(" with a bone", " from my owner", " That has gone", "lunatic");
		System.out.println(dog);
		Animal b = new Animal();
		String cat = b.iAmCat(" with a mouse");
		System.out.println(cat);
	}
	

}
