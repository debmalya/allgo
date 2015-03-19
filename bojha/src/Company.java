
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Company
{

  // IMPORTANT: DO NOT MODIFY THIS CLASS
  public static class Employee
  {

    private final int id;

    private final String name;

    private List<Employee> reports;



    public Employee (int id, String name)
    {
      this.id = id;
      this.name = name;
      this.reports = new ArrayList<Employee> ();
    }



    public int getId ()
    {
      return id;
    }



    public String getName ()
    {
      return name;
    }



    public List<Employee> getReports ()
    {
      return reports;
    }



    public void addReport (Employee employee)
    {
      reports.add (employee);
    }



    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
      StringBuilder aboutMe = new StringBuilder ();
      aboutMe.append ("id :");
      aboutMe.append (id);
      aboutMe.append (" name :");
      aboutMe.append (name);
      aboutMe.append (" Reports :");
      aboutMe.append (reports);

      return aboutMe.toString ();
    }


  }



  /*
   * Read the attached PDF for more explanation about the problem Note: Don't
   * modify the signature of this function
   * 
   * @param ceo
   * 
   * @param firstEmployee
   * 
   * @param secondEmployee
   * 
   * @return common manager for both employees that is closest to them.
   * 
   * Time complexity : Best Case : 1 (Directly reporting) Worst Case : O(V**2) V
   * is the cardinality of the vertices. Breadth first search is used here.
   * breadth of the tree.
   * 
   * Space complexity : This is tree type structure. CEO is the root. All others
   * are like branches. Not introduced any new data structure. Utilized existing
   * data. No additional space.
   * 
   * Assumption : id is unique. It is used as Primary key.
   */
  @SuppressWarnings("unused")
  public static Employee closestCommonManager (Employee ceo, Employee firstEmployee, Employee secondEmployee)
  {
    // Implement me
    Employee boss = getCommonBoss (ceo, firstEmployee, secondEmployee);
    if (boss == null)
    {
      boss = ceo;
    }
    return boss;
  }



  /**
   * Get nearest common boss.
   * 
   * @param ceo
   *          - CEO of the company.
   * @param firstEmployee
   *          - First employee
   * @param secondEmployee
   *          - Second employee
   * @return - Nearest common boss of the employees.
   */
  private static Employee getCommonBoss (Employee ceo, Employee firstEmployee, Employee secondEmployee)
  {

    Employee firstEmployeeBoss = getBoss (ceo, firstEmployee);
    Employee secondEmployeeBoss = getBoss (ceo, secondEmployee);

    if (firstEmployeeBoss.getId () == secondEmployee.getId ())
    {
      return secondEmployee;
    }
    if (secondEmployeeBoss.getId () == firstEmployee.getId ())
    {
      return firstEmployee;
    }

    while (firstEmployeeBoss != null && secondEmployeeBoss != null && firstEmployeeBoss.getId () != secondEmployeeBoss.getId ())
    {
      firstEmployeeBoss = getBoss (ceo, firstEmployeeBoss);
      if (firstEmployeeBoss == null)
      {
        return firstEmployeeBoss;
      }
      if (firstEmployeeBoss.getId () == secondEmployeeBoss.getId ())
      {
        break;
      }
      secondEmployeeBoss = getBoss (ceo, secondEmployeeBoss);
      if (secondEmployeeBoss == null)
      {
        return null;
      }

    }
    return firstEmployeeBoss;
  }



  /**
   * Get boss of the employee
   * 
   * @param ceo
   *          - CEO of the company
   * @param employee
   *          - any employee of the company.
   * @return Boss of the employee.
   */
  private static Employee getBoss (Employee ceo, Employee employee)
  {
    if (ceo.getReports ().contains (employee))
    {
      return ceo;
    }
    else
    {
      List<Employee> employeeList = ceo.getReports ();
      int noOfEmployees = employeeList.size ();
      for (int i = 0; i < noOfEmployees; i++)
      {
        Employee boss = getBoss (employeeList.get (i), employee);
        if (boss != null)
        {
          return boss;
        }
      }
    }
    return null;
  }



  public static void main (String[] args)
  {
    Employee nina = new Company.Employee (1, "Nina");
    Employee milton = new Company.Employee (2, "Milton");
    Employee porter = new Company.Employee (3, "Porter");

    Employee peter = new Company.Employee (4, "Peter");
    peter.addReport (milton);
    peter.addReport (nina);


    Employee bob = new Company.Employee (5, "Bob");

    Employee dom = new Company.Employee (6, "Dom");
    dom.addReport (bob);
    dom.addReport (peter);
    dom.addReport (porter);

    Employee samir = new Company.Employee (7, "Samir");
    Employee michael = new Company.Employee (8, "Michael");
    Employee ceo = new Company.Employee (9, "Bill");
    ceo.addReport (dom);
    ceo.addReport (samir);
    ceo.addReport (michael);

    Employee manager = Company.closestCommonManager (ceo, milton, nina);
    // Peter
    assert (manager.getName ().equals ("Peter"));

    manager = Company.closestCommonManager (ceo, nina, porter);
    // dom
    assert (manager.getName ().equals ("Dom"));


    manager = Company.closestCommonManager (ceo, nina, samir);
    // bill
    assert (manager.getName ().equals ("Bill"));
    // System.out.println (ceo);

    manager = Company.closestCommonManager (ceo, peter, nina);
    // Peter
    assert (manager.getName ().equals ("Peter"));

    printHierarchy (ceo);
//    printHierarchy (dom);
//    printHierarchy (samir);
//    printHierarchy (michael);
    System.out.println ("\nGame Over");

  }



  private static void printHierarchy (Employee ceo)
  {
    List<Employee> reportList = ceo.getReports ();
    Stack<Employee> employeeStack = new Stack<Employee> ();
    if (reportList.size () > 0)
    {
      System.out.println ("\n"+ ceo.getName () + " manager of ");
      for (int i = 0; i < reportList.size (); i++)
      {
        System.out.print (reportList.get (i).name + "\t");
        employeeStack.push (reportList.get (i));
      }
      while (!employeeStack.empty ()) {
        printHierarchy(employeeStack.pop ());
      }
    }

  }


}