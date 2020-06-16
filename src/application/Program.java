package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== Teste 1: Seller findById ====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n==== Teste 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n==== Teste 3: Seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

/*		System.out.println("\n==== Teste 4: Seller insert ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Registro inserido! Id = " + newSeller.getId());

		System.out.println("\n==== Teste 5: Seller update ====");
		newSeller = sellerDao.findById(7);
		newSeller.setName("Martha Weine");
		sellerDao.update(newSeller);
		System.out.println("Registro alterado!"); */

		System.out.println("\n==== Teste 6: Seller delete ====");
		System.out.print("Entre com o Id para deletar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Id deletado!");
		sc.close();
}

}
