package com.dalmia.greenfuel;

import com.dalmia.greenfuel.manyToMany.Category;
import com.dalmia.greenfuel.manyToMany.Product;
import com.dalmia.greenfuel.repo.ICategoryRepo;
import com.dalmia.greenfuel.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GreenfuelApplication implements CommandLineRunner {

	@Autowired
	private ICategoryRepo categoryRepo;

	@Autowired
	private IProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(GreenfuelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Product newProduct1 = new Product();
		newProduct1.setpId("pid1");
		newProduct1.setProductName("Iphone 14 Max pro");

		Product newProduct2 = new Product();
		newProduct2.setpId("pid2");
		newProduct2.setProductName("Samsung s22 ultra");

		Product newProduct3 = new Product();
		newProduct3.setpId("pid3");
		newProduct3.setProductName("Samsung Tv12312");

		Category newCategory1 = new Category();
		newCategory1.setcId("cid1");
		newCategory1.setTitle("Electronics");

		Category newCategory2 = new Category();
		newCategory2.setcId("cid2");
		newCategory2.setTitle("MobilePhones");

		List<Product> category1Products = newCategory1.getProducts();
		category1Products.add(newProduct1);
		category1Products.add(newProduct2);
		category1Products.add(newProduct3);

		List<Product> category2Products = newCategory1.getProducts();
		category2Products.add(newProduct1);
		category2Products.add(newProduct2);

		categoryRepo.save(newCategory1);
		categoryRepo.save(newCategory2);*/
	}
}
