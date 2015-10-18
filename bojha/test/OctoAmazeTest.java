import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class OctoAmazeTest {

	/**
	 * Test method for {@link OctoAmaze#schedule(java.util.List)}.
	 */
	@Test
	public final void testSchedule() {
		List<Job> jobList = new ArrayList<Job>();

		createJob(jobList, "A", new String[] { "B", "C" });
		createJob(jobList, "B", new String[] { "D" });
		createJob(jobList, "C", null);
		createJob(jobList, "D", null);
		createJob(jobList, "E", null);

		OctoAmaze adam = new OctoAmaze();
		List<Job> scheduledJobs = adam.schedule(jobList);
		Assert.assertNotNull(scheduledJobs);
		Assert.assertTrue(scheduledJobs.size() == 5);
	}

	@Test
	public final void testEvenList() {
		List<Integer> inputList = new ArrayList<>();
		inputList.add(2);
		inputList.add(2);
		inputList.add(4);
		
		OctoAmaze adam = new OctoAmaze();
		List<Integer> evenList = adam.getEvenOccurences(inputList);
		Assert.assertTrue(evenList.size() == 1);
		Assert.assertTrue(evenList.contains(2));
		Assert.assertTrue(!evenList.contains(4));
		
		
	}
	private void createJob(List<Job> jobList, String jobName, String[] deps) {
		Job job = new Job();
		job.name = jobName;
		if (deps != null) {
			job.deps = Arrays.asList(deps);
		}

		jobList.add(job);
	}

}
