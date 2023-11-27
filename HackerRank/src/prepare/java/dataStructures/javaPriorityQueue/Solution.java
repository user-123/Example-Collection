package prepare.java.dataStructures.javaPriorityQueue;

import java.io.*;
import java.util.*;

//TODO 完成其它寫法：如讓Student實做Comparable<Student>

/*
 * Create the Student and Priorities classes here.
 */

class Student {
	int id;
	String name;
	double cgpa;

	Student(int id, String name, double cgpa) {
		this.id=id;
		this.name=name;
		this.cgpa=cgpa;
	}

	int getID() {
		return id;
	}

	String getName() {
		return name;
	}

	double getCGPA() {
		return cgpa;
	}
}

class Priorities {
	private final PriorityQueue<Student> priorityQueue;

	Priorities() {
		priorityQueue = new PriorityQueue<>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));
	}

	List<Student> getStudents(List<String> events) {
		events.forEach((event) -> {
			if(event.equals("SERVED")) {
				priorityQueue.poll();
			}else {
				String[] details = event.split(" ");
				priorityQueue.offer(new Student(Integer.parseInt(details[3]), details[1],Double.parseDouble(details[2])));
			}
		});
		List<Student> students = new ArrayList<>();
		while(!priorityQueue.isEmpty()) {
			students.add(priorityQueue.poll());
		}
		return students;
	}
}

public class Solution {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<Student> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (Student st: students) {
				System.out.println(st.getName());
			}
		}
	}
}