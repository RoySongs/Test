import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	static ArrayList<Node> list;
	static ArrayList<Node> list2;
	static int[] minVals;
	static int m;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] firstStr = sc.nextLine().split(" ");
		int n = Integer.parseInt(firstStr[0]);
		m = Integer.parseInt(firstStr[1]);
		int[][] square = new int[n+1][n+1];
		
		
		for(int idx=1; idx<=n;idx++) {
			String str = sc.nextLine();
			String[] secStr = str.split(" ");
			for(int subIdx=1;subIdx<=n;subIdx++) {
				square[idx][subIdx] = Integer.parseInt(secStr[subIdx-1]);
				if(square[idx][subIdx] == 2) {
					list.add(new Node(idx,subIdx));
				} else if (square[idx][subIdx] == 1) {
					list2.add(new Node(idx,subIdx));
				} else {
					
				}
			}
		}
		System.out.println(solve());
		
	}
	
	static int solve() {
		int result=0;
		for(int idx=0; idx <list.size();idx++) {
			int chiX = list.get(idx).x;
			int chiY = list.get(idx).y;
			int dist = 0;
			
			for(int subIdx=0; subIdx<list2.size();subIdx++) {
				int homeX = list2.get(subIdx).x;
				int homeY = list2.get(subIdx).y;
				
				dist = Math.abs(chiX-homeX)+Math.abs(chiY-homeY);
				minVals[idx] = minVals[idx] +dist;
			}
			
		}
		Arrays.sort(minVals);
		
		for(int idx=0; idx<m;idx++) {
			result = result +minVals[idx];
		}
		
		return result;
	}


}

class Node{
	int x;
	int y;
	Node(int x, int y){
		System.out.println(x);System.out.println(y);
		this.x = x;
		this.y = y;
	}
}
