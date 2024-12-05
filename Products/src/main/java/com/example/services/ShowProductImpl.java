package com.example.services;

import java.time.LocalDate;
import java.util.List;

import com.example.beans.Product;
import com.example.dao.ShowProductDao;
import com.example.dao.ShowProductDaoImpl;

public class ShowProductImpl implements ShowProductServices {
	ShowProductDao sdao;
	public ShowProductImpl() {
		sdao = new ShowProductDaoImpl();
	}

	@Override
	public boolean addProduct(Product p) {
		return sdao.AddProduct(p); 
	}

	@Override
	public List<Product> GetAll() {
		return sdao.DisplayProduct();
	}

	@Override
	public Product getById(int pid) {
		return sdao.getById(pid);
	}

	@Override
	public boolean updateProduct(Product p) {
		return sdao.modifyProduct(p);
	}

	@Override
	public boolean deleteProduct(int pid) {
		System.out.println(pid);
		return sdao.delete(pid);
	}




}
