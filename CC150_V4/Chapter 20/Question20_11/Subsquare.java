package Question20_11;

public class Subsquare {

	public int row, column, size;

	public Subsquare(int r, int c, int sz) {
		row = r;
		column = c;
		size = sz;
	}

	public void print() {
		System.out.println("(Row " + row + ", Col " + column + " of Size " + size + ")");
	}
}