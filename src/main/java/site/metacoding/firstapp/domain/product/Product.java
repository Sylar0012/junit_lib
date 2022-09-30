package site.metacoding.firstapp.domain.product;

import java.sql.Timestamp;

import lombok.Getter;

@Getter

public class Product {
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private Integer productQty;
    private Timestamp createdAt;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    private Product() {

    }

    public Product(String productName, Integer productPrice, Integer productQty) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
    }

    public void update(Product product) {
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productQty = product.getProductQty();
    }

}