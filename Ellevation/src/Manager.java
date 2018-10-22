import java.util.ArrayList;
import java.util.List;

public class Manager implements IEmployee {
  private int salary;
  private int vacationBalance;
  private int annualBonus;
  private List<IEmployee> employeesManaged;
  public boolean isHR;

  /**
   * Constructor that takes in salary, vacation balance, annual bonus, and a list of IEmployees
   * and initializes everything.
   *
   * @param salary     employee's salary
   * @param vb         vacation balance
   * @param ab         annual bonus
   * @param e          employees managed
   */
  public Manager(int salary, int vb, int ab, List<IEmployee> e) {
    this.salary = salary;
    this.vacationBalance = vb;
    this.annualBonus = ab;
    this.employeesManaged = e;
    this.isHR = false;
  }

  /**
   * A second constructor that does not include a list of employees, initializing the list to empty.
   * @param salary     employee's salary
   * @param vb         vacation balance
   * @param ab         annual bonus
   */
  public Manager(int salary, int vb, int ab) {
    this.salary = salary;
    this.vacationBalance = vb;
    this.annualBonus = ab;
    this.employeesManaged = new ArrayList<IEmployee>();
    this.isHR = false;
  }

  /**
   * Add the given employee to this manager's list of employees.
   * @param e         Employee
   */
  public void addEmployee(IEmployee e) {
    this.employeesManaged.add(e);
  }

  @Override
  public int getSalary() {
    return this.salary;
  }

  @Override
  public int getVacationBalance() {
    return this.vacationBalance;
  }

  @Override
  public int getAnnualBonus() {
    return this.annualBonus;
  }

  @Override
  public void editSalary(int newSalary) {
    this.salary = newSalary;
  }

  @Override
  public void editVacationBalance(int newVacationBalance) {
    this.vacationBalance = newVacationBalance;
  }

  @Override
  public void editAnnualBonus(int newAnnualBonus) {
    this.annualBonus = newAnnualBonus;
  }

  @Override
  public boolean isHR() {
    return false;
  }

  /**
   * Return the list of employees that this manager manages.
   * @return    List<IEmployee></IEmployee> employees managed
   */
  public List<IEmployee> getEmployeesManaged() {
    return this.employeesManaged;
  }

  /**
   * Only allow managers to edit employee information if that employee is
   * in the list of employees they manage.
   * @param e
   * @return      boolean if employee is in employeesManaged
   */
  public boolean canEditEmployee(IEmployee e) {
    return this.employeesManaged.contains(e);
  }


  /**
   * Returns the given employees salary if this manager is eligible to view that Employee's salary.
   * @param e   IEmployee employee
   * @return    int salary
   * @throws    UnsupportedOperationException if cannot view that employee's salary
   */
  public int getEmployeeSalary(IEmployee e) {
    if (this.canEditEmployee(e)) {
      return e.getSalary();
    }
    else {
      throw new UnsupportedOperationException("This manager cannot view this employee's information.");
    }
  }

  /**
   * Changes employee's salary if this manager is eligible to change that Employee's salary.
   * @param e   IEmployee employee
   * @param newSalary new salary
   */
  public void editEmployeeSalary(IEmployee e, int newSalary) {
    if (this.canEditEmployee(e)) {
      e.editSalary(newSalary);
    }
  }


  /**
   * Returns the given employee's vacation balance if this manager is eligible to view that
   * Employee's vacation balance.
   * @param e   IEmployee employee
   * @return    int vacation balance
   * @throws    UnsupportedOperationException if cannot view that Employee's vacation balance.
   */

  public int getEmployeeVacation(IEmployee e) {
    if (this.canEditEmployee(e)) {
      return e.getVacationBalance();
    }
    else {
      throw new UnsupportedOperationException("This manager cannot view this employee's information.");
    }
  }

  /**
   * Changes employee's salary if this manager is eligible to change that Employee's salary.
   * @param e   IEmployee employee
   * @param newVacationBalance new vacation balance
   */
  public void editEmployeeVacationBalace(IEmployee e, int newVacationBalance) {
    if (this.canEditEmployee(e)) {
      e.editVacationBalance(newVacationBalance);
    }
  }

  /**
   * Returns the given employee's annual bonus if this manager is eligible to view that
   * Employee's vacation balance.
   * @param e   IEmployee employee
   * @return    int annual bonus
   * @throws    UnsupportedOperationException if cannot view that Employee's annual bonus.
   */
  public int getEmployeeAnnualBonus(IEmployee e) {
    if (this.canEditEmployee(e)) {
      return e.getAnnualBonus();
    }
    else {
      throw new UnsupportedOperationException("This manager cannot view this employee's information.");
    }
  }

  /**
   * Changes employee's annual bonus if this manager is eligible to change that Employee's annual bonus.
   * @param e   IEmployee employee
   * @param newAnnualBonus new annual bonus
   */
  public void editEmployeeAnnualBonus(IEmployee e, int newAnnualBonus) {
    if (this.canEditEmployee(e)) {
      e.editAnnualBonus(newAnnualBonus);
    }
  }
}
