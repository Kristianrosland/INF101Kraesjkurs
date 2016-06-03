package Arv2;

public class MainClass {
	
	public static void main(String... orange){
		Animal animal = new Animal();
		Bird bird = new Bird();
		
		System.out.println();
		
		animal.sleep();
		animal.eat();
		
		bird.sleep();
		bird.eat();
	}

}
