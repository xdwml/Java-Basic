import java.util.*;

/**
 * 比较器
 */
public class Code_09_Comparator {

	public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}
	//按ID升序排列
	public static class IdAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			//负数第一个排前面，正数排后面
			return o1.id - o2.id;
		}

	}
	//按ID降序排列
	public static class IdDescendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.id - o1.id;
		}

	}

	public static class AgeAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}

	}

	public static class AgeDescendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.age - o1.age;
		}

	}

	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}
		System.out.println("===========================");
	}

	public static void main(String[] args) {
		Student student1 = new Student("A", 1, 23);
		Student student2 = new Student("B", 2, 21);
		Student student3 = new Student("C", 3, 22);

		Student[] students = new Student[] { student3, student2, student1 };
		printStudents(students);

		Arrays.sort(students, new IdAscendingComparator());
		printStudents(students);

		Arrays.sort(students, new IdDescendingComparator());
		printStudents(students);

		Arrays.sort(students, new AgeAscendingComparator());
		printStudents(students);

		Arrays.sort(students, new AgeDescendingComparator());
		printStudents(students);
        System.out.println("===========优先级队列============");
		//优先级队列
		PriorityQueue<Student> heap=new PriorityQueue<Student>(new IdAscendingComparator());
		heap.add(student3);
		heap.add(student2);
		heap.add(student1);
		while (!heap.isEmpty()){
		    Student student=heap.poll();
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("============红黑树==============");
        //红黑树
        TreeSet<Student> treeMap=new TreeSet(new IdAscendingComparator());

	}

}
