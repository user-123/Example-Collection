package prepare.java.dataStructures.javaSort;

import java.io.*;
import java.util.*;

class Student {
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
class Sorter implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {	//s1代表小，s2代表大
		//不知為何有錯//return (int)(s1.getCgpa()!=s2.getCgpa() ? (s2.getCgpa()-s1.getCgpa()>0 ? -1 : 1) : !s1.getFname().equals(s2.getFname()) ? s2.getFname().compareTo(s1.getFname()) : s1.getId()-s2.getId());
		return s1.getCgpa()!=s2.getCgpa() ? Double.compare(s2.getCgpa(), s1.getCgpa()) : !s1.getFname().equals(s2.getFname()) ? s1.getFname().compareTo(s2.getFname()) : Integer.compare(s1.getId(), s2.getId());
		/*
		if (s1.getCgpa()!=s2.getCgpa()) {return Double.compare(s2.getCgpa(), s1.getCgpa());}
		if (!s1.getFname().equals(s2.getFname())) {return s1.getFname().compareTo(s2.getFname());}
		return Integer.compare(s1.getId(), s2.getId());
		*/
	}

}

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}

		//Collections.sort(studentList, Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getFname).thenComparing(Student::getId));
		Comparator<Student> sorter = (s1, s2) -> {
			/*
			if (s1.getCgpa() == s2.getCgpa()) {
				if (s1.getFname().equals(s2.getFname()))
					return Integer.compare(s1.getId(), s2.getId());
				return s1.getFname().compareTo(s2.getFname());
			}
			return Double.compare(s2.getCgpa(), s1.getCgpa());
			*/
			if (s1.getCgpa()!=s2.getCgpa()) {return Double.compare(s2.getCgpa(), s1.getCgpa());}
			if (!s1.getFname().equals(s2.getFname())) {return s1.getFname().compareTo(s2.getFname());}
			return Integer.compare(s1.getId(), s2.getId());


		};
		studentList.sort(sorter);

		for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}