package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import site.metacoding.firstapp.config.MyBatisConfig;

@Import(MyBatisConfig.class) // MyBatisTest가 MyBatisConfig를 못읽음
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 실DB사용
@MybatisTest
public class ProductDaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void findById_test() {
        // given(받아야 할 것)
        Integer productId = 1;

        // when(테스트)
        Product productPS = productDao.findById(productId);

        // then(검증)
        assertEquals("바나나", productPS.getProductName());
    }

    @Test
    public void findAll_test() {
        // given

        // when
        List<Product> productListPS = productDao.findAll();
        System.out.println(productListPS.get(0).getProductName());

        // then
        assertEquals(2, productListPS.size());
    }

    @Test
    public void insert_test() {
        // given

        Product product = new Product("수박", 1000, 100);

        // when
        int result = productDao.insert(product);

        // then
        assertEquals(1, result);
    }

    @Test
    public void update_test() {
        // given
        Integer productId = 1;
        String productName = "수박";
        Integer productPrice = 1000;
        Integer productQty = 100;

        Product product = new Product(productName, productPrice, productQty);
        product.setProductId(productId);

        // verify
        Product productPS = productDao.findById(product.getProductId());
        assertTrue(productPS == null ? false : true);

        // when

        // product = [id=1, productName="수박", productPrice = 1000, productQty = 100]
        // productPS = [id=1, productName="바나나", productPrice = 3000, productQty = 98,
        // createdAt = 2022.09.29]
        productPS.update(product);
        // productPS = [id=1, productName="수박", productPrice = 1000, productQty = 100,
        // createdAt = 2022.09.29]
        int result = productDao.update(productPS);
        // productPS = [id=1, productName="수박", productPrice = 1000, productQty = 100,
        // createdAt = 2022.09.29] 업데이트

        // then
        assertEquals(1, result);
    }

    @Test
    public void delete_test() {
        // given
        Integer productId = 2;

        // verify
        Product productPS = productDao.findById(productId);
        assertTrue(productPS == null ? false : true);

        // when
        int result = productDao.deleteById(productId);

        // then
        assertEquals(1, result);

    }
}
