
public class EnumTest {
	
	private enum Company {
		gradle, internet_org, memom, people_worldwide;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Usage: EnumTest <<company name>>");
			
		} else {
			switch(Company.valueOf(args[0])) {
			case gradle:
				System.out.println("Gradle");
				break;
			case internet_org:
				System.out.println("Internet.org");
				break;	
			case memom:
				System.out.println("memom");
				break;		
			default:
				System.err.println("Unknown company");
			}
		}

	}

}
