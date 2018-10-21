
public class HREmployee implements IEmployee {

  int salary;
  int vacationBalance;
  int annualBonus;

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
  }

  //HR employees can only view Employee info if they are not in the HR dept.
  public boolean canViewEmployeeInfo(IEmployee e) {
    return !e.isHR();
  }

  //HR employees can access all employee info, unless the employee is also in HR.

  public int getEmployeeSalary(IEmployee e) {
    if (canViewEmployeeInfo(e)) {
      return e.getSalary();
    }
    else {
      throw new UnsupportedOperationException("Cannot view another HR person's salary.");
    }
  }

  public int getEmployeeVacationBalance(IEmployee e) {
    if (canViewEmployeeInfo(e)) {
      return e.getVacationBalance();
    }
    else {
      throw new UnsupportedOperationException("Cannot view another HR person's vacation balance.");
    }
  }

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
