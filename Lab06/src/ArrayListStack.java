import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		this.a = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getA() {
		return this.a;
	}

	@Override
	public boolean isEmpty() {
		if (a.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if (a.size() >= 100000) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void makeEmpty() {
		this.a = new ArrayList<Integer>();
	}

	@Override
	public int top() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return this.a.get(a.size() - 1);
		}
	}

	@Override
	public void pop() throws Exception {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		} else {
			this.a.remove(a.size() - 1);
		}
	}

	@Override
	public void push(int data) throws Exception {
		if (this.isFull()) {
			throw new Exception("This stack is full.");
		} else {
			a.add(data);
		}
	}

}
