import java.util.ArrayList;
import java.util.SortedMap;

abstract class employee{
    private String name ;
    private int id ;

    public employee(String name , int id ){
        this.name = name;
        this.id =id;

    }
    public String getName(){
        return name;
    }
    public int getId(){
       return id;
    }
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name"+ name +", id =" + id + "salary = " + calculateSalary() + "]";
    }




}
class FullTimeEmployee extends employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class PartTImeEmployee extends employee{

   private int hoursWorked;
   private int hourlyRate;

   public PartTImeEmployee(String name ,int id , int hoursWorked, int hourlyRate) {
       super(name, id);
       this.hoursWorked = hoursWorked;
       this.hourlyRate = hourlyRate;
   }
   @Override
    public double calculateSalary(){
       return hoursWorked * hourlyRate;
   }

}
class payRollSystem{
    private ArrayList<employee> employeeList;

    public payRollSystem(){
        employeeList = new ArrayList<>();
    }
    public void addEmployee(employee employee){
        employeeList.add(employee);

    }
    public void removeEmployee(int id){
        employee employeeToRemove =null;
        for(employee employee : employeeList){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployee(){
        for(employee employee : employeeList){
            System.out.println(employee);
        }
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
           payRollSystem payRollSystem = new payRollSystem();
           FullTimeEmployee emp1 = new FullTimeEmployee("Arpit" , 1 ,4000);
           PartTImeEmployee emp2 = new PartTImeEmployee("Anurag", 2, 40 ,100);

           payRollSystem.addEmployee(emp1);
           payRollSystem.addEmployee(emp2);
        System.out.println("Intial Employee Details");
        payRollSystem.displayEmployee();
        System.out.println("Removing employee");
        payRollSystem.removeEmployee(2);
        System.out.println("Remaining employee");
        payRollSystem.displayEmployee();
        }
    }
