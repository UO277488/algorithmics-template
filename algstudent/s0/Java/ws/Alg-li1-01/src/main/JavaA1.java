package main;

import java.util.ArrayList;
import java.util.List;

public class JavaA1 {

	public static void main(String[] args) {
		prime();
	}

	private static void prime() {
		int n = 10000;
		for (int i = 0; i < 7; i++) {
			long t1 = System.currentTimeMillis();
			List<Integer> primes = listadoPrimos(n);
			long t2 = System.currentTimeMillis();
			System.out.println("n =" + n + "***" + "time = " + String.valueOf(((1000 * (t2 - t1)))) + "milliseconds)");
			System.out.println(primes);
			n = n * 2;
		}
	}
	
	/*
	 * def listadoPrimos(n):
    """ calculates and returns all primes up to n """
    primes = []
    for i in range (2, n+1):
        if primoA1(i):
            primes.append(i)
    return primes
	 */
	
	private static List<Integer> listadoPrimos(int n) {
		List<Integer> primes = new ArrayList<Integer>();
		for(int i = 2; i < n + 2; i++) {
			if(primoA1(i)) {
				primes.add(i);
			}
		}
		
		return primes;
	}
	
	/*
	 * def primoA1(m):
    """ returns whether m is prime or not """
    p = True
    for i in range (2,m):
        if m%i == 0:
            p = False
    return p

	 */
	
	private static boolean primoA1(int m) {
		boolean b = true; 
		for (int i = 2; i < m; i++) {
			if(m%i == 0) {
				b = false;
			}
		}
		return b;
	}

}
