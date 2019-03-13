package elementary.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prime {
  public static void main(String[] args){
	  Scanner sc = new Scanner(System.in);
	  prime(6,9);
	  System.out.println();
	  System.out.println(primeCount);
	  sc.close();
  }
  static int primeCount = 0;
  
  static void prime(int l, int r){
	  primeCount = 0;
	  List<Integer> list = new ArrayList<>();
	  //list.add(2);
	  if(l > r)
	  {
		  int temp = r;
		  r = l;
		  l = temp;
	  }
	  list = getList(l);
	  if(l == 2){
		  primeCount++;
		  l++;
	  }
	  else if(l == 1)
		  l++;
	  for(int i = l; i <= r; i++){
		  int n = (int) Math.sqrt(i);
		  boolean prime = true;
		  for(int j = 0; j <list.size() && list.get(j) <= n; j++){
			  if(i % list.get(j) == 0)
			  {
				  prime = false;
				  break;
			  }
		  }
		  if(prime){
			  System.out.print(i + " ");
			  primeCount++;
			  list.add(i);
		  }
	  }
  }
  static List<Integer> getList(int l){
	  List<Integer> list = new ArrayList<>();
	  list.add(2);
	  for(int i = 3; i < l; i++){
		  int n = (int) Math.sqrt(i);
		  boolean prime = true;
		  for(int j = 2; j <= n; j++){
			  if(i % 2 == 0)
			  {
				  prime =false;
				  break;
			  }
		  }
		  if(prime){
			  list.add(i);
		  }
	  }
	  return list;
  }
}
