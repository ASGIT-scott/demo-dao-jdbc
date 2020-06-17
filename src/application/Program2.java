package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Teste 1: Department findById ====");
		System.out.print("Informe o Id do Departamento p/ consulta: ");
		int id = sc.nextInt();
		Department department = departmentDao.findById(id);
		System.out.println(department);
		
		System.out.println("\n==== Teste 2: Department findAll ====");
		List<Department> list = departmentDao.findAll();
		for (Department dep : list) {
			System.out.println(dep);
		}

		System.out.println("\n==== Teste 3: Department insert ====");
		Department newDepartment = new Department(null, "teste insert");
		departmentDao.insert(newDepartment);
		System.out.println("Departamento inserido! Id: " + newDepartment.getId());
		
		System.out.println("\n==== Teste 4: Department update ====");
		newDepartment = new Department(7, "Teste Update");
		departmentDao.update(newDepartment);
		System.out.println("Update executado!");

		System.out.println("\n==== Teste 5: Seller delete ====");
		System.out.print("Informe o ID do Departamento p/ exclusao: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Departamento excluído!");

		sc.close();

	}
}
