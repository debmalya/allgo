import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class BotasanaBot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		htmlToLuna("<div><img /></div>");

	}

	/*
	 * ou have some tasks in your Asana account. For each ith of them you know
	 * its deadlinei - the last day by which it should be completed. As you can
	 * see in your calendar, today is the day number day. Asana labels each task
	 * in accordance with its due date:
	 * 
	 * If the task is due today or it's already overdue, it is labeled as Today;
	 * If the task should be completed within a week (but not today), i.e. its
	 * deadline is somewhere between day + 1 and day + 7 both inclusive, it is
	 * labeled as Upcoming; All other tasks are labeled as Later; Your goal is
	 * to find the number of tasks with each label.
	 * 
	 * Example
	 * 
	 * For deadline = [1, 2, 3, 4, 5] and day = 2 the answer is
	 * tasksTypes(deadline, day) = [2, 3, 0]. For deadline = [1, 2, 4, 2, 10, 3,
	 * 1, 4, 5, 4, 9, 8] and day = 1 the answer is tasksTypes(deadline, day) =
	 * [2, 8, 2]. [input] array.integer deadline
	 * 
	 * Array of positive integers. [input] integer day
	 * 
	 * A positive integer. [output] array.integer
	 * 
	 * Array of three elements - the number of tasks labeled as Today, Upcoming
	 * and Later, respectively. CODE
	 */
	int[] tasksTypes(int[] deadline, int day) {
		int[] t = new int[3];

		for (int i = 0; i < deadline.length; i++) {
			if (deadline[i] <= day) {
				t[0]++;
			} else if (deadline[i] >= day + 1 && deadline[i] <= day + 7) {
				t[1]++;
			} else {
				t[2]++;
			}

		}

		return t;
	}

	/**
	 * Consider the initial and the final positions of the mouse, then join them
	 * by a line. Each task whose rectangular block has at least one common
	 * point with this line becomes selected.
	 * 
	 * @param dimensions
	 * @param tasks
	 * @param mouseCoordinates
	 * @return
	 */
	String[] multiSelection(int[] dimensions, String[] tasks,
			int[][] mouseCoordinates) {
		List<String> r = new ArrayList<>();
		int[] e = mouseCoordinates[0];
		int[] s = mouseCoordinates[1];

		for (int i = 0; i < tasks.length; i += 10) {
			if (i <= s[0] && i + 10 * i <= s[0] && dimensions[0] <= s[0]
					&& 9 + 10 * i <= s[1]) {
				if (i <= e[0] && i + 10 * i <= e[0] && dimensions[0] <= s[0]
						&& 9 + 10 * i <= e[1]) {
					r.add(tasks[i]);
				}
			}
		}
		return r.toArray(new String[0]);
	}

	/**
	 * While preparing for your first round interview with Asana, you start
	 * exploring Luna, Asana's in-house framework for automating Web application
	 * creation. For practice - and fun! - you decide to implement a simple
	 * HTML-to-Luna converter.
	 * 
	 * To keep things straightforward, you will only consider 4 HTML tags: div,
	 * p, b, img. Here is how valid HTML is constructed:
	 * 
	 * an empty string is a valid HTML; <img /> is valid HTML (note the
	 * whitespace character between img and /); if HTML is valid HTML, then
	 * <div>HTML</div>,
	 * <p>
	 * HTML
	 * </p>
	 * and
	 * 
	 * <b>HTML</b> are all valid. if HTML1 and HTML2 are both valid HTML, then
	 * HTML1HTML2 is valid HTML. For example, <div>
	 * <p>
	 * <img />
	 * </p>
	 * <b></b></div> is valid HTML, but <div>
	 * <p>
	 * </div> is invalid.
	 * 
	 * The conversion of each tag is performed as follows:
	 * 
	 * <div><arg1><arg2>...</div> → DIV([arg1, arg2, arg3, ... ]);
	 * <p>
	 * <arg1><arg2>...
	 * </p>
	 * → P([arg1, arg2, arg3, ... ]); <b><arg1><arg2>...</b> → B([arg1, arg2,
	 * arg3, ... ]); <img /> → IMG({}) Example
	 * 
	 * htmlToLuna("<div><img /></div>") = "DIV([IMG({})])" htmlToLuna("<div>
	 * <p>
	 * <img />
	 * </p>
	 * <b></b></div>") = "DIV([P([IMG({})]), B([])])" htmlToLuna("<div>
	 * <p>
	 * </p>
	 * <p>
	 * </p>
	 * <p>
	 * </p>
	 * </div>") = "DIV([P([]), P([]), P([])])" [input] string html
	 * 
	 * Valid HTML, containing only these 4 tags: div, p, b, img.
	 * 
	 * html.length ≤ 60000 [output] string
	 * 
	 * The given HTML converted into the Luna format.
	 * 
	 * @param html
	 * @return
	 */
	public static String htmlToLuna(String html) {
		String l = "";
		Stack<String> s = new Stack<>();
		if (html.length() > 0) {
			for (int i = 0; i < html.length(); i++) {
				int b = html.indexOf("<");
				int e = html.indexOf(">");
				String t = html.substring(b + 1, e).toUpperCase();
				if (t.startsWith("/")) {
					t = t.substring(1).trim();
					if (s.peek().equals(t)) {
						t = "]";
					}
				} else if ("DIV".equals(t) || "P".equals(t) || "B".equals(t)
						|| "IMG".equals(t)) {
					l += t;
					l += "([";
					s.push(t);
				} else {
					t = t.replace("/", "{})");
					l += t;
				}

				html = html.substring(e + 1);
			}
		}
		return l;
	}
}
