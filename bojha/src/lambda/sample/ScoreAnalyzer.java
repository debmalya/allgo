/**
 * 
 */
package lambda.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author debmalyajash
 *
 */
public class ScoreAnalyzer {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(createNewStudent(2011, 89));
		studentList.add(createNewStudent(2012, 99));
		studentList.add(createNewStudent(2011, 79));
		studentList.add(createNewStudent(2012, 69));

		analyzeResult(studentList, 2011);
		analyzeResult(studentList, 2012);
	}

	/**
	 * @param studentList
	 * @param graduationYear
	 */
	private static void analyzeResult(List<Student> studentList,
			int graduationYear) {
		//		return 
		System.out.println(filter(studentList,graduationYear));
		IntStream score = studentList.stream().filter(s -> s.getGraduationYear() == graduationYear).mapToInt(s->s.getScore());
		System.out.println("Max :" +score.max());		
		System.out.println("Min :"+ studentList.stream().filter(s -> s.getGraduationYear() == graduationYear).mapToInt(s->s.getScore()).min());
		System.out.println("Average :"+ studentList.stream().filter(s -> s.getGraduationYear() == graduationYear).mapToInt(s->s.getScore()).average());

	}

	public static List<Student> filter(List<Student> studentList,
			int graduationYear) {
		List<Student> filtered = new ArrayList<Student>();
		studentList.stream().filter(s -> s.getGraduationYear() == graduationYear).forEach(s -> filtered.add(s));
		return filtered;
	}

	public static List<Student> filter0(List<Student> studentlist,
			int graduationYear) {
		List<Student> filtered = new ArrayList<Student>();
		for (Student student : studentlist) {
			if (student.getGraduationYear() == graduationYear) {
				filtered.add(student);
			}
		}
		return filtered;
	}

	/**
	 * @param graduationYear
	 * @param score
	 * @return
	 */
	private static Student createNewStudent(int graduationYear, int score) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setGraduationYear(graduationYear);
		student.setScore(score);
		return student;
	}
}
