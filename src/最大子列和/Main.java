package 最大子列和;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		int[] nums = new int[n];
		int begin = 0;
		int end = 0;
		int maxBegin = 0;
		int maxEnd = 0;
		int sum = 0;
		int max = -1;
		for(int i = 0; i < n; i ++){
			nums[i] = in.nextInt();
			sum = sum + nums[i];
			if(sum > max){
				max = sum;
				end = i;
				maxEnd = end;
				maxBegin = begin;
			}
			else if(sum < 0){
				sum = 0;
				end = i + 1;
				begin = i + 1;
			}
		}
		if(max == -1){
			System.out.println(0+" "+nums[0]+" "+nums[n-1]);
			in.close();
			return;
		}
		System.out.println(max + " " + nums[maxBegin] + " " + nums[maxEnd]);
		in.close();
	}
}
