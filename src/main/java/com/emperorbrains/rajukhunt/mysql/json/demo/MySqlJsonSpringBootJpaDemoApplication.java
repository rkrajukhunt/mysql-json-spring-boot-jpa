package com.emperorbrains.rajukhunt.mysql.json.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emperorbrains.rajukhunt.mysql.json.demo.entity.Book;
import com.emperorbrains.rajukhunt.mysql.json.demo.entity.Car;
import com.emperorbrains.rajukhunt.mysql.json.demo.entity.Store;
import com.emperorbrains.rajukhunt.mysql.json.demo.repository.IStoreRepository;

@SpringBootApplication
public class MySqlJsonSpringBootJpaDemoApplication implements CommandLineRunner {

	@Autowired
	private IStoreRepository repository;

	@Autowired
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(MySqlJsonSpringBootJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = new Book("Book title", "Book author" + new Random().nextInt(10));
		book.setType("Book");

		Car car = new Car("Golf", "Green", "Volkswagen", new Random().nextInt(10) + 2000);
		car.setType("Car");

		Car car2 = new Car("Passat", "Black", "Volkswagen", new Random().nextInt(10) + 2000);
		car2.setType("Car");

		Store store = new Store();
		store.setName("Test");
		store.getItems().add(book);
		store.getItems().add(car);

		Store store2 = new Store();
		store2.setName("Car2");
		store2.getItems().add(car2);

		System.out.println("Before save: " + store.toString() + ";" + store2.toString());
		repository.saveAll(Arrays.asList(store, store2));

		Iterable<Store> stores = repository.findAll();

		System.out.println("After save:" + stores);

		List<Store> results = entityManager
				.createNativeQuery("select * from store where JSON_SEARCH(items, 'all', 'Passat') IS NOT NULL",
						Store.class)
				.getResultList();

		System.out.println("Results:" + results);

		results = entityManager
				.createNativeQuery("select * from store where JSON_SEARCH(items, 'all', 'Book title') IS NOT NULL",
						Store.class)
				.getResultList();

		System.out.println("Results:" + results);

	}

}
