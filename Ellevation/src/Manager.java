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

  //add the given employee to the manager's list of employees
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

  //return the list of employees managed
  public List<IEmployee> getEmployeesManaged() {
    return this.employeesManaged;
  }

  //Only allow managers to edit employee information if that employee is
  // in the list of employees they manage.
  public boolean canEditEmployee(IEmployee e) {
    return this.employeesManaged.contains(e);
  }


  //only allow this Manager to access the given employee's salary if that employee is in the manager's
  //list of employees
  public int getEmployeeSalary(IEmployee e) {
    if (this.canEditEmployee(e)) {
      return e.getSalary();
    }
    else {
      throw new UnsupportedOperationException("This manager cannot view this employee's information.");
    }
  }

  //only change the salary of the given employee if this Manager can edit the given Employee's salary
  public void editEmployeeSalary(IEmployee e, int newSalary) {
    if (this.canEditEmployee(e)) {
      e.editSalary(newSalary);
    }
  }


  //only allow this Manager to access the given employee's vacation if that employee is in the manager's
  //list of employees
  public int getEmployeeVacation(IEmployee e) {
    if (this.canEditEmployee(e)) {
      return e.getVacationBalance();
    }
    else {
      throw new UnsupportedOperationException("This manager cannot view this employee's information.");
    }
  }

  //only change the vacation balance of the given employee if this Manager can edit the given Employee's salary
  public void editEmployeeVacationBalace(IEmployee e, int newVacationBalance) {
    if (this.canEditEmployee(e)) {
      e.editVacationBalance(newVacationBalance);
    }
  }

  //only allow this Manager to access the given employee's bonus if that employee is in the manager's
  //list of employees
  public int getEmployeeAnnualBonus(IEmployee e) {
    if (this.canEditEmployee(e)) {
      return e.getAnnualBonus();
    }
    else {
      throw new UnsupportedOperationException("This manager cannot view this employee's information.");
    }
  }

  //only change the bonus of the given employee if this Manager can edit the given Employee's salary
  public void editEmployeeAnnualBonus(IEmployee e, int newAnnualBonus) {
    if (this.canEditEmployee(e)) {
      e.editAnnualBonus(newAnnualBonus);
    }
  }
}
