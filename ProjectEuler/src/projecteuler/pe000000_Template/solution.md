$ multipleOf3Sum = \dfrac{(3+3i)*i}{2}, 3i<target \le{3(i+1)} $

$ multipleOf5Sum = \dfrac{(5+5j)*j}{2}, 5j<target \le{5(j+1)} $

$ duplicatesSum = multipleOf15Sum = \dfrac{(15+15k)*k}{2}, 15k<target \le{15(k+1)} $

$ result = multipleOf3Sum + multipleOf5Sum - duplicatesSum $

[code=Java]
package projecteuler.pe000000_Template;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				long n = Long.parseLong(bufferedReader.readLine().trim());
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
[/code]