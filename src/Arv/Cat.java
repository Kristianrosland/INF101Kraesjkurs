package Arv;

public class Cat extends Animal implements IAnimal {

	public Cat(String name) {
		super(name);
	}

	@Override
	public boolean isCarnivore() {
		return true;
	}

	@Override
	public boolean canWalk() {
		return true;
	}

	@Override
	public boolean canSwim() {
		return true;
	}

	@Override
	public int getHighSpeed() {
		return 20;
	}
	
	
}
