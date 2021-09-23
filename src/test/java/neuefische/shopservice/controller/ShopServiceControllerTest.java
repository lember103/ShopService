package neuefische.shopservice.controller;

import neuefische.shopservice.model.Product;
import neuefische.shopservice.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShopServiceControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepo productRepo;

    @Test
    public void testListAllProducts(){
        //GIVEN
        String url = "http://localhost:" + port + "/shop/allProducts";

        productRepo.addProduct(new Product(0, "apple"));
        productRepo.addProduct(new Product(1,"pears"));
        productRepo.addProduct(new Product(2, "banana"));

        //WHEN
        ResponseEntity<Product[]> response = restTemplate.getForEntity(url, Product[].class);

        //THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(
                new Product(0, "apple"),
                new Product(1, "pears"),
                new Product(2, "banana")
        ));

    }
}