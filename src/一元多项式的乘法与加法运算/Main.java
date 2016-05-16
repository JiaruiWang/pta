package 一元多项式的乘法与加法运算;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main main = new Main();
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		ArrayList<node> poly1 = new ArrayList<node>();
		for (int i = 0; i< n1; i++){
			Main t1 = new Main();
			int c = in.nextInt();
			int e = in.nextInt();
			if ( c >= -1000 && c <= 1000 && e >= -1000 && e <= 1000){
				node t11 = t1.new node(c, e);
				poly1.add(t11);
			}
		}
		int n2 = in.nextInt();
		ArrayList<node> poly2 = new ArrayList<node>();
		for (int i = 0; i< n2; i++){
			Main t2 = new Main();
			int c = in.nextInt();
			int e = in.nextInt();
			if ( c >= -1000 && c <= 1000 && e >= -1000 && e <= 1000){
				node t22 = t2.new node(c, e);
				poly2.add(t22);
			}
		}

		ArrayList<node> mul = main.mul(poly1, poly2);
		int muln = mul.size();
		if( muln == 0){
			System.out.print(0+" "+0);
		}else{
			for (int i = 0; i< muln; i++){
				System.out.print(mul.get(i).coef+" " + mul.get(i).expo);
				if(i < muln-1)
					System.out.print(" ");
			}
		}
		System.out.println();
		ArrayList<node> sum = main.add(poly1,poly2);
		int sumn = sum.size();
		if(sumn == 0){
			System.out.print(0+" "+0);
		}else{
			for (int i = 0; i< sumn; i++){
				System.out.print(sum.get(i).coef+" " + sum.get(i).expo);
				if(i < sumn-1)
					System.out.print(" ");
			}
		}
		in.close();
	}
	public ArrayList<node> mul(ArrayList<node> a1, ArrayList<node> a2){
		ArrayList<node> mul = new ArrayList<node>();
		int n1 = a1.size();
		int n2 = a2.size();
		for( int i = 0; i < n1; i ++){
			ArrayList<node> temp = new ArrayList<node>();			
			for(int j = 0; j < n2; j++){
				temp.add(mul(a1.get(i), a2.get(j)));
			}
			mul = add(temp, mul);
		}
		return mul;
	}
	public ArrayList<node> add(ArrayList<node> a1, ArrayList<node> a2){
		int n1 = a1.size();
		int n2 = a2.size();
		ArrayList<node> sum = new ArrayList<node>();
		int i = 0;
		int j = 0;
		while( i < n1 && j < n2){
			node temp1 = a1.get(i);
			node temp2 = a2.get(j);
			if(temp1.expo > temp2.expo){
				if(temp1.coef != 0)
					sum.add(temp1);
				i++;
			}else if(temp1.expo < temp2.expo){
				if(temp2.coef != 0)
					sum.add(temp2);
				j++;
			}else{
				node temp3 = new node();
				temp3.expo = temp1.expo;
				temp3.coef = temp1.coef + temp2.coef;
				if(temp3.coef != 0)
					sum.add(temp3);
				i++;
				j++;
			}
		}
		while(i < n1){
			if(a1.get(i).coef != 0)
				sum.add(a1.get(i));
			i++;
		}
		while(j < n2){
			if(a2.get(j).coef != 0)
				sum.add(a2.get(j));
			j++;
		}
		return sum;
	}
	public node mul(node n1, node n2){
		node mul = new node();
		mul.coef = n1.coef * n2.coef;
		mul.expo = n1.expo + n2.expo;
		if(mul.coef == 0)
			mul.expo = 0;
		return mul;
	}
	public class node{
		int coef;
		int expo;	
		public node(int coef, int expo){
			this.coef = coef;
			this.expo = expo;
		}
		public node(){			
		}
	}
}

