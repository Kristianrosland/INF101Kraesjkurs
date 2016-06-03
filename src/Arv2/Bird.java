package Arv2;

public class Bird extends Animal {
	
	public Bird(){
		super();
		System.out.println("A new Bird has been created!");
	}
	
	@Override
	public void sleep(){
		System.out.println("A bird sleeps...");
	}
	
	@Override
	public void eat(){
		System.out.println("A bird eats");
	}

}
