package com.esauhp.desafio1Hibernate;

import com.esauhp.desafio1Hibernate.repository.Contract;
import com.esauhp.desafio1Hibernate.repository.Customer;
import com.esauhp.desafio1Hibernate.services.ContractManagementI;
import com.esauhp.desafio1Hibernate.services.CustomerManagementI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class Desafio1HibernateApplication implements CommandLineRunner {

	@Autowired
	private CustomerManagementI customerManagementI;

	@Autowired
	private ContractManagementI contractManagementI;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1HibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*// Insertamos un nuevo cliente
		Customer c = new Customer("Raúl","González","Blanco","34567898J");
		customerManagementI.insertar(c);


		Customer obtenido = customerManagementI.findByName(c.getName(),c.getSurName1(),c.getSurName2());
		System.out.println("Nombre: "+obtenido.getName()+" "+obtenido.getSurName1()+" "+obtenido.getSurName2());

		// Actualizamos el cliente
		c.setName("Antonio");
		customerManagementI.updateCustomer(c);
		Customer actualizado = customerManagementI.findByName(c.getName(),c.getSurName1(),c.getSurName2());
		System.out.println("Nombre: "+obtenido.getName()+" "+obtenido.getSurName1()+" "+obtenido.getSurName2());

		// Mostramos clientes
		List<Customer> customerList =customerManagementI.findAll();
		for (Customer customer: customerList) {
			System.out.println("Nombre: "+customer.getName());
		}*/
		Customer c = new Customer("Raúl","González","Blanco","34567898J");
		customerManagementI.insertar(c);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Contract contract=null;
		try {
			 contract= new Contract(formatter.parse("2021-05-04"),formatter.parse("2021-05-09"),203.09,c);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contractManagementI.insert(contract);

		List<Contract> contractList =  contractManagementI.findByCustomerId(1L);
		for (Contract item: contractList) {
			System.out.println(item.getPrice());
		}

	}
}
