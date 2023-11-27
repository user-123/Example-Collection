package prepare.java.advanced.javaSha256;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println(computeSha256Hash(scanner.nextLine()));
		}
	}

	private static String computeSha256Hash(String input) {
		StringBuilder output = new StringBuilder();
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			byte[] inputBytes = input.getBytes();
			byte[] hashBytes = sha256.digest(inputBytes);
			for(byte bi : hashBytes) {	//byte：-128~127 => unsigned byte：0~255 => 0b00000000~0b11111111 => 0x00~0xff(hex：00~ff)
				output.append(String.format("%02x", bi&0xFF));	//string格式化，%02x代表不足兩位補0到兩位(02)、十六進位(x)；&0xFF運算是為了把高於8位的位補0，避免byte在處理時因為自動提昇(promote)型態到int所造成的"問題"(數值不變，但二進制編碼改變)；這邊我們要的是二進制編碼不變(利用&0xFF運算)，但數值可能改變
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return output.toString();
	}
}