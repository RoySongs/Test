import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	static int n, k, min = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Node> list = new ArrayList<Node>();


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
	    k = sc.nextInt();
	    map = new int[n + 1][n + 1];
	 
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= n; j++) {
	            map[i][j] = sc.nextInt();
	            if (map[i][j] == 2) {
	                list.add(new Node(j, i));
	            }
	        }
	    }
	 
	    int[][] dist = new int[n + 1][n + 1];
	    for (int k = 1; k <= n; k++) {
	        Arrays.fill(dist[k], 9999);
	    }
	    search(0, 0, dist);
	    System.out.println(min);

	}
	
	public static void search(int next, int cnt, int[][] prev) {
	    int len = list.size();
	    for (int i = next; i < len; i++) {
	        int[][] dist = new int[n + 1][n + 1];
	        for (int k = 1; k <= n; k++) {
	            dist[k] = Arrays.copyOf(prev[k], n + 1); // deep copy
	        }
	        Node node = list.get(i);
	        int x = node.x;
	        int y = node.y;
	 
	        // 치킨 거리 업데이트 && 도시 치킨 거리 반환 
	        int sum = totalDistance(x, y, dist);
	        if (cnt + 1 == k) {
	            if (sum < min) {
	                min = sum;
	            }
	        } else {
	            search(i + 1, cnt + 1, dist);
	        }
	    }
	}

	public static int totalDistance(int x, int y, int[][] dist) {
	    int sum = 0;
	    for (int i = 1; i <= n; i++) {
	        for (int j = 1; j <= n; j++) {
	            if (map[i][j] == 1) {
	                int d = Math.abs(y - i) + Math.abs(x - j);
	                if (dist[i][j] > d) {
	                    dist[i][j] = d;
	                }
	                sum += dist[i][j];
	            }
	        }
	    }
	    return sum;
	}
	 
	static class Node {
	    int x;
	    int y;
	 
	    Node(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}


}
