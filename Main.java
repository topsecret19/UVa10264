import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
public static void main(String[] args) throws IOException {
	Hashtable<Integer,Integer> p1 = new Hashtable<Integer,Integer>();
	Hashtable<Integer,Integer> p2 = new Hashtable<Integer,Integer>();

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line1;
	String line2;
	while((line1=br.readLine())!=null&&line1.length()!=0) {
	Scanner sc = new Scanner(line1);
	int D = sc.nextInt();
	int counting = (int) Math.pow(2, D);
	int highestPotency=0;
	for(int i =0; i<counting; i++) {
		line2=br.readLine();
		Scanner sc2 = new Scanner(line2);
		int value= sc2.nextInt();
		p1.put(i, value);
	}
	for(int i=0; i<counting; i++) {
		for(int j =0; j<counting; j++) {
			if(i!=j && isneighbors(i,j)) {
				int add = p1.get(j);
				if(p2.get(i)!=null) {
					p2.put(i, p2.get(i)+add);

				}else {
					p2.put(i, add);
				}
			}
		}
	}
	
	for(int i=0; i<counting; i++) {
		for(int j=0; j<counting; j++) {
			if(i!=j&& isneighbors(i,j)) {
				int sum = p2.get(i)+p2.get(j);
				if(sum>highestPotency) {
					highestPotency = sum;
				}
			}
		}
	}
	System.out.println(highestPotency);
	p1.clear();
	p2.clear();
	}
}
static boolean isneighbors(int n1, int n2) {
	int n = n1^n2;
	return (n&(n-1))==0;
}
}
