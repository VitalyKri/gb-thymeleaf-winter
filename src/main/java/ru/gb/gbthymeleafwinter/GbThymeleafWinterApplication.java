package ru.gb.gbthymeleafwinter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import ru.gb.gbthymeleafwinter.service.ProductService;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

public class GbThymeleafWinterApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(GbThymeleafWinterApplication.class, args);

        ProductService productService = context.getBean(ProductService.class);
//
//        productService.findAll();
//
//        final Product product = productService.save(Product.builder()
//                .cost(new BigDecimal("50.0"))
//                .status(Status.ACTIVE)
//                .title("Батон")
//                .date(LocalDate.now())
//                .build());
//
//        System.out.println("До " + productService.findById(product.getId()));
//
//        productService.deleteById(product.getId());
//        productService.deleteById(product.getId());
//
//        System.out.println("После " + productService.findById(product.getId()));
    }

}
