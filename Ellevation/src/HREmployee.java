/**
 * An HR Employee is an Employee that can access information about other Employees that are not
 * HR Employees.
 */
public class HREmployee implements IEmployee {

  private int salary;
  private int vacationBalance;
  private int annualBonus;
  public boolean isHR;

  /**
   * Constructor that takes in salary, vacation balance, annual bonus,
   * and initializes everything.
   *
   * @param salary     employee's salary
   * @param vb         vacation balance
   * @param ab         annual bonus
   */
  public HREmployee(int salary, int vb, int ab) {
    this.salary = salary;
    this.vacationBalance = vb;
    this.annualBonus = ab;
    this.isHR = true;
  }

  /**
   * HR employees can only view Employee info if they are not in the HR dept.
   * @param e        Employee to view
   * @return bool    If they can view given employee's info
   */
  public boolean canViewEmployeeInfo(IEmployee e) {
    return !e.isHR();
  }

  //HR employees can access all employee info, unless the employee is also in HR.

  /**
   * HR Employee can view other Employee salaries, but not HR Employee's salaries.
   * @param e       Employee
   * @return int    salary
   * @throws UnsupportedOperationException if trying to view an HR's salary
   */
  public int getEmployeeSalary(IEmployee e) {
    if (canViewEmployeeInfo(e)) {
      return e.getSalary();
    }
    else {
      throw new UnsupportedOperationException("Cannot view another HR person's salary.");
    }
  }

  /**
   * HR Employee can view other Employee vacation balances, but not HR Employee's vacation
   * balances.
   * @param e       Employee
   * @return int    vacation balance
   * @throws UnsupportedOperationException if trying to view an HR's vacation balance
   */
  public int getEmployeeVacationBalance(IEmployee e) {
    if (canViewEmployeeInfo(e)) {
      return e.getVacationBalance();
    }
    else {
      throw new UnsupportedOperationException("Cannot view another HR person's vacation balance.");
    }
  }

  /**
   * HR Employee can view other Employee annual bonus, but not HR Employee's annual bonus.
   * @param e       Employee
   * @return int    salary
   * @throws UnsupportedOperationException if trying to view an HR's annual bonus
   */
  public int getEmployeeAnnualBonus(IEmployee e) {
    if (canViewEmployeeInfo(e)) {
      return e.getAnnualBonus();
    }
    else {
      throw new UnsupportedOperationException("Cannot view another HR person's annual bonus.");
    }
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
    return true;
  }
}
