package site.metacoding.firstapp.domain.product;

import java.util.List;

public interface ProductDao {
    public Product findById(Integer productId);

    public List<Product> findAll();

    public void insert(Product product);

    public void update(Product product);

    public void deleteById(Integer productId);
}