package prepare.java.advanced.canYouAccess;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		DoNotTerminate.forbidExit();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

			//Write your code here
			Inner inner = new Inner();
			//Inner.Private privateInstance = inner.new Private();
			//privateInstance.powerof2(num);
			o = inner.new Private();
			Method method = o.getClass().getDeclaredMethod("powerof2", int.class);
			//Method method = Inner.Private.class.getDeclaredMethod("powerof2", int.class);
			method.setAccessible(true);
			String result = (String)method.invoke(o, num);
			System.out.println(num + " is " + result);

			System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

		}catch (DoNotTerminate.ExitTrappedException | NoSuchMethodException | NumberFormatException | IOException | IllegalAccessException | InvocationTargetException ex) {	//NumberFormatException, IOException, NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException
			System.out.println("Unsuccessful Termination!!");
		}
	}	//end of main

	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}	//end of Inner
}

class DoNotTerminate {	//This class prevents exit(0)

	public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
	}

	@SuppressWarnings({"removal", "deprecation"})
	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if (permission.getName().contains("exitVM")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}