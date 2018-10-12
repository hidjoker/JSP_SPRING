package test;

public class testEx {

	public static void main(String[] args) {
		
		test t = new test();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] answer = t.solution(record);
		
		for (String string : answer) {
			
			System.out.println(string);
		}
	}
}
