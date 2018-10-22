public interface IEmployee {
  int getSalary();

  int getVacationBalance();

  int getAnnualBonus();

  void editSalary(int newSalary);

  void editVacationBalance(int newVacationBalance);

  void editAnnualBonus(int newAnnualBonus);

  boolean isHR();

}
