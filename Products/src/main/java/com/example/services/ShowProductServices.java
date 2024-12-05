package com.example.services;

import java.time.LocalDate;
import java.util.List;

import com.example.beans.Product;

public interface ShowProductServices {

	boolean addProduct(Product p);

	List<Product> GetAll();

	Product getById(int pid);

	boolean updateProduct(Product p);

	boolean deleteProduct(int pid);


}
