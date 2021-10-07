package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		//PART 1
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		System.out.println("------------------------------------------");
		System.out.println();
		
		Employee [] vect = new Employee [n];
		List <Employee> list = new ArrayList<>();
		
		for (int i = 1; i<=n; i++) {
			System.out.println("Employee #"+i+": ");
			System.out.print("Id: ");			
			int id = sc.nextInt();	
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			System.out.println();
			
			Employee employee = new Employee(id, name, salary);
			list.add (employee);
			
		}
		
		//PART 2
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int empId = sc.nextInt();
		Employee employee = list.stream().filter(x -> x.getId() == empId).findFirst().orElse(null);
		if (employee == null) {
			System.out.println("This id does not exist!");
		}
		else {		
		System.out.print("Enter the percentage: ");
		double percent = sc.nextDouble();
		employee.increaseSalary(percent);
		}
		
		// PART 3
		
		System.out.println();
		System.out.println("List of employees: ");
		for (Employee obj : list) {
			System.out.println(obj);			
		}
			
		sc.close();
		
	}

}
