package Arv;

public class Dog extends Animal implements IAnimal{

	public Dog(String name) {
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
		return 15;
	}
}
