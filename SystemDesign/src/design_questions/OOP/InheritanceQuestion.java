package design_questions.OOP;

// Is this class definition valid?

class A {
	public void foo(A a) {
	}
}

class B extends A {
	public void foo(B b) {
	}
}
