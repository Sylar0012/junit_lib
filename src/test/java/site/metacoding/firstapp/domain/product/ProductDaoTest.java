package site.metacoding.firstapp.domain.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
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

}
