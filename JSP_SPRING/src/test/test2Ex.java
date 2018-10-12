package test;

public class test2Ex {
	public static void main(String[] args) {
		
		
		test2 t = new test2();
		int[] arr = {4, 4, 4, 4, 4};
		int[] res = t.solution(	4, arr);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
