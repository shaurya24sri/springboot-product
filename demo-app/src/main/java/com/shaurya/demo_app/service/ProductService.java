package com.shaurya.demo_app.service;

import com.shaurya.demo_app.model.Product;
import com.shaurya.demo_app.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
       return repo.findAll();
    }

    public Product getproductbyid(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product,MultipartFile imageFile) throws IOException{
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id,Product product,MultipartFile imageFile) throws IOException{
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repo.save(product);
    }

    public void deleteById(int id) {
         repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchkeyword(keyword);
    }
}
