public class Employee implements IEmployee {
  int salary;
  int vacationBalance;
  int annualBonus;
  IEmployee manager;
  boolean isHR;

  /**
   * Constructor that takes in salary, vacation balance, annual bonus, and an IEmployee (manager)
   * and initializes everything.
   *
   * @param salary     employee's salary
   * @param vb         vacation balance
   * @param ab         annual bonus
   * @param manager    employee's manager
   */
  public Employee(int salary, int vb, int ab, IEmployee manager) {
    this.salary = salary;
    this.vacationBalance = vb;
    this.annualBonus = ab;
    this.manager = manager;
    this.isHR = false;
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

  //make the salary of this employee the new given salary
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

  //Who is this Employee's Manager?
  public IEmployee getManager() {
    return this.manager;
  }
}
