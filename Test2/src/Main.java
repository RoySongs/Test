import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		int circle = Integer.parseInt(sc.nextLine());
		HashMap<Integer, Integer> hs = new HashMap<>();
		ArrayList<Integer> array = new ArrayList<>();
		for(int i=0; i<circle;i++) {
			String scStr = sc.nextLine();
			String[] str = scStr.split(" ");
			hs.put(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			
		}
		while(!hs.isEmpty()) {
			System.out.println("1");
			System.out.println(hs.get(1));
			
		}
		
	}
	
}
