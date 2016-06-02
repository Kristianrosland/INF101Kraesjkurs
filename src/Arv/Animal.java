package Arv;

public abstract class Animal implements IAnimal {

	private String name;
	
	public Animal(String name){
		this.name = name;
	}
	
	@Override
	public boolean canFly() {
		return false;
	}

	@Override
	public boolean isCarnivore() {
		return false;
	}

	@Override
	public boolean canWalk() {
		return false;
	}

	@Override
	public boolean canSwim() {
		return false;
	}

	@Override
	public boolean canChangeSex() {
		return false;
	}

	@Override
	public boolean hasFeathers() {
		return false;
	}

	@Override
	public boolean hasShell() {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getHighSpeed() {
		return 0;
	}
	
	
}
