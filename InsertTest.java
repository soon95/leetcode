import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertTest {
	public static void main(String[] args) {
		//
		List<Interval> intervals=new ArrayList<>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		for (int i = 0; i < intervals.size(); i++) {
			intervals.get(i).print();
		}
		Interval newInterval=new Interval(4, 8);
		newInterval.print();
		//
		System.out.println("*********************");
		List<Interval> ans=insert(intervals, newInterval);
		for (int i = 0; i < ans.size(); i++) {
			ans.get(i).print();
		}	
	}
	public static List<Interval> insert(List<Interval> intervals,Interval newInterval){
		intervals.add(newInterval);
		
		List<Interval> ans=new ArrayList<>();
		
		int size=intervals.size();
		int[] st=new int[size];
		int[] en=new int[size];
		
		for (int i = 0; i < size; i++) {
			st[i]=intervals.get(i).start;
			en[i]=intervals.get(i).end;
		}
		Arrays.sort(st);
		Arrays.sort(en);
		
		int index=0;
		int down;
		int temp;
		while(index<size) {
			down=index;
			temp=down;
			while(index<size-1&&st[index+1]<=en[temp]) {
				index++;
				temp++;
			}
			ans.add(new Interval(st[down],en[index]));
			index++;
		}
		return ans;
	}
}
