package com.example.dao;

import java.util.List;

import com.example.beans.Product;

public interface ShowProductDao {

	boolean AddProduct(Product p);

	List<Product> DisplayProduct();

	Product getById(int pid);

	boolean modifyProduct(Product p);

	boolean delete(int pid);


}
