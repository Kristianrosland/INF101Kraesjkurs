package JUnit;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import Eksamen.IVector;
import Eksamen.Vector;

public class VectorTest {
	
	private IVector randomVector;
	
	@Before
	public void setup(){
		double[] elem = new double[10];
		Random rnd = new Random();
		for(int i = 0; i < elem.length; i++){
			elem[i] = rnd.nextDouble() * rnd.nextInt(100);
		}
		randomVector = new Vector(elem);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testThatGetThrowsIndexOutOfBoundsExceptionWithLargeInvalidIndex(){
		randomVector.get(100);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testThatGetThrowsIndexOutOfBoundsExceptionWithNegativIndex(){
		randomVector.get(-1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testThatNewVectorThrowsIllegalArgumentExceptionForNullArray(){
		new Vector(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testThatNewVectorThrowsIllegalArgumentExceptionForEmptyArray(){
		new Vector(new double[0]);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testThatAddThrowsIllegalArgumentExceptionUsingTwoVectorsWithDifferentSize(){
		randomVector.add(new Vector(new double[]{1}));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testThatSubThrowsIllegalArgumentExceptionUsingTwoVectorsWithDifferentSize(){
		randomVector.sub(new Vector(new double[]{2, 4, 5, 6, 7, 1, 2}));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testThatMulThrowsIllegalArgumentExceptionUsingTwoVectorsWithDifferentSize(){
		randomVector.mul(new Vector(new double[]{2, 4, 5, 6, 7, 1, 2}));
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testThatDivThrowsIllegalArgumentExceptionUsingTwoVectorsWithDifferentSize(){
		randomVector.div(new Vector(new double[]{2, 4, 5, 6, 7, 1, 2}));
	}
	
	@Test
	public void testThatSizeReturns10ForVectorWith10Elements(){
		assertEquals(10, randomVector.size());
	}
	
	@Test
	public void testThatGetReturnsCorrectValueInEachPositionInVector(){
		double[] elements = new double[5];
		for(int i = 0; i < elements.length; i++){
			elements[i] = i;
		}
		IVector vector = new Vector(elements);
		for(int i = 0; i < elements.length; i++){
			assertTrue(i == vector.get(i));
		}
	}
	
	@Test
	public void testThatAddAddsCorrect(){
		IVector expected = new Vector(new double[]{2,4,6,8});
		IVector vector = new Vector(new double[]{1,2,3,4});
		assertEquals(expected, vector.add(vector)); // Hvorfor fungerer ikke dette?
	}
	
	@Test
	public void testThatSubSubtractsCorrect(){
		IVector expected = new Vector(new double[]{0,0,0,0});
		IVector vector = new Vector(new double[]{1,2,3,4});
		assertEquals(expected, vector.sub(vector));
	}
	
	@Test
	public void testThatMulMultipliesCorrect(){
		IVector expected = new Vector(new double[]{1,4,9,16});
		IVector vector = new Vector(new double[]{1,2,3,4});
		assertEquals(expected, vector.mul(vector));;
	}
	
	@Test
	public void testThatDivDividesCorrect(){
		IVector expected = new Vector(new double[]{1,1,1,1});
		IVector vector = new Vector(new double[]{1,2,3,4});
		assertEquals(expected, vector.div(vector));;
	}
	
	
	
	

	

}
