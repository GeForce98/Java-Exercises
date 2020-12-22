package csi405.lecture04;

class A {
	int f = 0;

	public String toString() {
		return "" + f;
	}
}

class B extends A {
	B() {
		f = 1;
	}
}

class C extends A {
	{
		f = 2;
	}
}

// class D cannot extend both B and C due to conflicts caused by B and C
class D extends B /* , C */ {
}

public class DiamondProblem {

	public static void main(String[] args) {
		System.out.println(new D());
	}

}
