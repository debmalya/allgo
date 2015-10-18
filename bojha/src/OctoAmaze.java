import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class OctoAmaze {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> occurrence = new HashMap<Integer, Integer>();
		Set<Entry<Integer, Integer>> oset = occurrence.entrySet();
		Iterator<Entry<Integer, Integer>> osetIterator = oset.iterator();

		while (osetIterator.hasNext()) {
			Entry<Integer, Integer> nextEntry = osetIterator.next();
			// if (nextEntry.getValue()%2== 0)
			// occurrence.remove(key)
		}

	}

	/**
	 * // I'd like you to consider the scheduling of jobs. class Job { String
	 * name; List<String> deps; }
	 * 
	 * //Can you write a function that takes a list of Jobs //and puts them in
	 * an order that does not violate //any dependencies. // A -> B, C // B -> D
	 * // C -> [] // D -> [] // E -> [] // A valid schedule might be, EDCBA, or
	 * DBCEA, but ABCDE is not valid.
	 */

	public List<Job> schedule(List<Job> jobList) {
		List<Job> scheduledJobs = new ArrayList<Job>();
		
		// Maintain a link for the dependent jobs.
	    // Key is the job (A)
	    // Value is a list of dependent jobs (B,C).
	    Map<Job,List<String>> jobDependency = new HashMap<Job,List<String>>();

		for (Job eachJob : jobList) {
			 if (eachJob.deps != null && !eachJob.deps.isEmpty()){
				// can create some dependency tree here
	             jobDependency.put(eachJob,eachJob.deps);
			 } else {
				 scheduledJobs.add(eachJob);
			 }
		}

		 // dependent jobs
	    // issue : circular dependency
	    // O(Number of dependent jobs ) // can be quardatic  (Worst case)
	    while (!jobDependency.isEmpty()) {
	        // check each job whether their dependent job already in the list or not.
	        // if dependent jobs are scheduled. Then only add that job and remove that job 
	        // from jobDependency.
	         Set<Entry<Job, List<String>>> oset = jobDependency.entrySet();
	         Iterator<Entry<Job, List<String>>> myIterator = oset.iterator();
	        
	        while (myIterator.hasNext()){
	            Entry<Job, List<String>> nextEntry = myIterator.next();
	           // list of dependent jobs.
	           boolean canAdd = false;
	           for (String eachDep: nextEntry.getValue()){
	        	   canAdd = false;
	        	   for (Job eachScheduled : scheduledJobs) {
	        		   if (eachScheduled.name.equals(eachDep)) {	
	        			   canAdd = true;
	        			   break;
	        		   } else {
	        			   canAdd = false;
	        		   }
	        	   }
	        	   if (!canAdd) {
	        		   break;
	        	   }
	               
	           }
	           
	           if (canAdd) {
	               scheduledJobs.add(nextEntry.getKey());
	               jobDependency.remove(nextEntry.getKey());
	               break;
	           }
	           
	        }
	    }  
		
		return scheduledJobs;
	}
	
	/**
	 * You will be given a list of numbers, where numbers may be repeated.
	 * Your method will return list of numbers which has even number of occurences
	 * @param inputList list containing numbers, numbers can be repeated.
	 * @return list of numbers which have even number of occurences.
	 */
	public List<Integer> getEvenOccurences(List<Integer> inputList) {
		List<Integer> evenList = new ArrayList<Integer>();
		
		Collections.sort(inputList);
		Integer pre = 0;
		int c = 0;
		for (int i = 0; i < inputList.size(); i++) {
			Integer t = inputList.get(i);
			if (i > 0) {
				if (pre == t) {
					c++;
				} else {
					if (c%2 == 0) {
						evenList.add(pre);
					}
					c = 0;
				}
			}
			pre = t;
			
		}
		return evenList;
		
	}
	public List<Integer> getEvenOccurences0(List<Integer> inputList) {
		List<Integer> evenList = new ArrayList<Integer>();
		
		Map<Integer,Integer> occurenceCount = new HashMap<Integer,Integer>();
		
		for (Integer each:inputList) {
			Integer c = occurenceCount.get(each);
			c = (c == null) ? 1: ++c;
			occurenceCount.put(each, c);
		}
		
		Set<Entry<Integer, Integer>> entrySet = occurenceCount.entrySet();
		Iterator<Entry<Integer, Integer>> iter = entrySet.iterator();
		while (iter.hasNext()) {
			Entry<Integer, Integer> nextEntry = iter.next();
			if (nextEntry.getValue()%2==0) {
				evenList.add(nextEntry.getKey());
			}
		}
		return evenList;
		
	}
}
