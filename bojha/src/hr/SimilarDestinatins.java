package hr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class SimilarDestinatins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int minimumNumbOfTags = scanner.nextInt();
			scanner.nextLine();

			List<Destination> destinationList = new ArrayList<>();
			try {
				while (true) {
					String description = scanner.nextLine();
					if (description != null && description.trim().length() > 0) {
						Destination destination = new Destination();
						destination.processDestination(description);
						destinationList.add(destination);
					} else {
						break;
					}
				}
			} catch (Throwable th) {
				// ignore
			}

			DestinationComparator comparator = new DestinationComparator();
			List<Group> groups = comparator.compare(destinationList,
					minimumNumbOfTags);

			for (Group each : groups) {
				System.out.println(each);
			}

		}

	}

	static class Destination {

		String destination;

		ArrayList<String> tagList = null;

		void processDestination(String description) {
			String[] values = description.split(":");
			destination = values[0];
			tagList = new ArrayList<String>(Arrays.asList(values[1].split(",")));
			Collections.sort(tagList);

		}
	}

	static class DestinationComparator {
		List<Group> compare(List<Destination> destinationList,
				int minimumNumbOfTags) {

			List<Group> groups = new ArrayList<>();
			SortedMap<String, Group> similarDestinations = new TreeMap<>();

			for (int i = 0; i < destinationList.size() - 1; i++) {
				for (int j = i + 1; j < destinationList.size(); j++) {

					Destination destination1 = destinationList.get(i);
					Destination destination2 = destinationList.get(j);

					List<String> union = new ArrayList<String>();
					for (String each : destination1.tagList) {
						union.add(each);
					}
					union.retainAll(destination2.tagList);
					if (union.size() >= minimumNumbOfTags) {
						// needs to be added in the group
						addToGroup(similarDestinations, destination1,
								destination2, union,destinationList);

					}

					List<String> union2 = new ArrayList<String>();
					for (String each : destination2.tagList) {
						union2.add(each);
					}
					union2.retainAll(destination1.tagList);

					if (union2.size() >= minimumNumbOfTags) {
						// needs to be added in the group
						addToGroup(similarDestinations, destination1,
								destination2, union2,destinationList);

					}

				}
			}

			// System.out.println(similarDestinations);
			Set<Entry<String, Group>> entrySet = similarDestinations.entrySet();
			Iterator<Entry<String, Group>> entrySetIterator = entrySet
					.iterator();

			while (entrySetIterator.hasNext()) {
				groups.add(entrySetIterator.next().getValue());
			}
			Collections.sort(groups);
			return groups;

		}

		private void addToGroup(SortedMap<String, Group> similarDestinations,
				Destination destination1, Destination destination2,
				List<String> union,List<Destination> destinationList) {
			Group group = createGroup(union);
			Group existingGroup = similarDestinations.get(group.getTags());
			if (existingGroup == null) {
				existingGroup = group;
			}
			existingGroup.addCities(destination1.destination);
			existingGroup.addCities(destination2.destination);
			
			for (Destination destination: destinationList) {
				if (!existingGroup.cities.contains(destination.destination)) {
					// check whether all the tags of union is there in the destination or not
					boolean canBeAdded = true;
					for (int i = 0; i < union.size(); i++) {
						if (!destination.tagList.contains(union.get(i))) {
							canBeAdded = false;
							break;
						}
					}
					
					if (canBeAdded) {
						existingGroup.addCities(destination.destination);
					}
				}
			}
			
			similarDestinations.put(existingGroup.getTags(), existingGroup);

		}

		/**
		 * @param union
		 * @return
		 */
		private Group createGroup(List<String> union) {
			Group group = new Group();
			for (String each : union) {
				group.addTags(each);
			}
			return group;
		}

	}

	static class Group implements Comparable<Group> {
		SortedSet<String> tags = new TreeSet<>();

		SortedSet<String> cities = new TreeSet<>();

		public String getCities() {
			String[] myCities = cities.toArray(new String[0]);
			return Arrays.toString(myCities);
		}

		/**
		 * @param destination
		 */
		public void addCities(String destination) {
			cities.add(destination);

		}

		public void addTags(String tag) {
			tags.add(tag);
		}

		public String getTags() {
			String[] myTags = tags.toArray(new String[0]);
			return Arrays.toString(myTags);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(Group o) {
			if (tags.size() < o.tags.size()) {
				return 1;
			} else if (tags.size() > o.tags.size()) {
				return -1;
			} else {
				// same number of tag lists
				if (getCities().compareTo(o.getCities()) > 0) {
					return 1;
				} else if (getCities().compareTo(o.getCities()) < 0) {
					return -1;
				}

			}
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			String cities = getCities().replace("[", "").replace("]", "")
					.replace(" ", "");
			String tags = getTags().replace("[", "").replace("]", "")
					.replace(" ", "");

			return cities + ":" + tags;
		}

	}
}
