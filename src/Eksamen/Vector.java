package Eksamen;

import java.util.Arrays;

public class Vector implements IVector {

	/**
	 * OPPGAVE 3A.
	 *
	 *	FORKRAV:
	 * 		size(): ingen forkrav
	 * 		get(index): 0 <= index < size()
	 * 		add/sub/mul/div: vektorene må ha samme size()
	 * 		div: vektoren man deler på må ikke inneholde 0
	 * 		(dvs., med flyttall vil dette i prinsippet gå bra, fordi man får ± uendelig som resultet – men å dele 0 på 0 vil fremdeles være et problem)
	 */

	/**
	 * Vector-data, ikke null
	 */
	private double[] data;

	public Vector(double[] elements) {
		if (elements == null || elements.length == 0) {
			throw new IllegalArgumentException("Elements kan ikke være tom eller null");
		}

		//Mutable version
		data = elements;

		//Immutable version
		//data = elements.clone();
	}

	@Override
	public int size() {
		return data.length;
	}

	@Override
	public double get(int index) {
		if (index < 0 || index >= data.length) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return data[index];
	}

	@Override
	public IVector add(IVector addend) {
		checkArguments(addend);
		double[] sum = new double[size()];
		for (int i = 0; i < data.length; i++) {
			sum[i] = data[i] + addend.get(i);
		}
		return new Vector(sum);
	}

	@Override
	public IVector sub(IVector subtrahend) {
		checkArguments(subtrahend);
		double[] sum = new double[size()];
		for (int i = 0; i < data.length; i++) {
			sum[i] = data[i] - subtrahend.get(i);
		}
		return new Vector(sum);
	}

	@Override
	public IVector mul(IVector factor) {
		checkArguments(factor);
		double[] sum = new double[size()];
		for (int i = 0; i < data.length; i++) {
			sum[i] = data[i] * factor.get(i);
		}
		return new Vector(sum);
	}
	
	

	@Override
	public IVector div(IVector divisor) {
		checkArguments(divisor);
		double[] sum = new double[size()];
		for (int i = 0; i < data.length; i++) {
			sum[i] = data[i] / divisor.get(i);
		}
		return new Vector(sum);
	}
	
	private void checkArguments(IVector vector){
		if(vector.size() != size()){
			throw new IllegalArgumentException("bla bla ");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(data);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		return true;
	}

}
