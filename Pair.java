
public class Pair {
	private String f;
	private String l;
	public Pair(String fname,String lname) {
		f=fname;
		l=lname;
	}
	@Override
	public String toString() {
		return f+l;
	}
}
