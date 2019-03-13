import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for(;;){
			int n = sc.nextInt();
			if(n == 0)
				break;
			int root = (int) Math.ceil(Math.sqrt(n));
			int c = root * root - root + 1;
			int x,y;
			x = y = root;
		    if(root % 2 == 0){
		    	if(n > c)
		    		y -= n - c;
		    	else
		    		x -= c - n;
		    }
		    else{
		    	if(n > c)
		    		x-= n - c;
		    	else
		    		y -= c - n;
		    }
		    System.out.println(x + " " + y);
		}
		sc.close();
	}

}
