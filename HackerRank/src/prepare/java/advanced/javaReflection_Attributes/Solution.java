package prepare.java.advanced.javaReflection_Attributes;

import java.lang.reflect.*;
import java.util.*;

class Student{
	private String name;
	private String id;
	private String email;

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

class Solution {

	public static void main(String[] args){
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		//TODO 待測試、待學習
		Class<Student> studentClass = Student.class;
		//Class studentClass = new Student().getClass();
		Method[] methods = studentClass.getDeclaredMethods();

		ArrayList<String> methodList = new ArrayList<>();
		for(Method method : methods) {
			methodList.add(method.getName());
		}
		Collections.sort(methodList);
		for(String name: methodList){
			System.out.println(name);
		}
	}

}




