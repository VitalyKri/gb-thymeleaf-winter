package ru.gb.gbthymeleafwinter.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbthymeleafwinter.entity.Cart;
import ru.gb.gbthymeleafwinter.entity.Product;
import ru.gb.gbthymeleafwinter.service.CartService;
import ru.gb.gbthymeleafwinter.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
//TODO нужно добавить роли для корзины
public class CartController {

    private final CartService cartService;
    private final ProductService productService;


    @GetMapping()
    @PreAuthorize("hasAuthority('cart.read')")
    public String showForm(Model model, @RequestParam(name = "id", required = false) Long id) {

        if (id==null){
            id = 1L;
        }
        Cart cart = cartService.findById(id);
        model.addAttribute("products",cart.getProducts());


        return "product-cart";
    }


    @GetMapping("/addProduct")
    @PreAuthorize("hasAuthority('cart.update')")
    public String addProduct(@RequestParam(name = "id") Long id, HttpServletRequest request) {

        Cart cart = cartService.findById(1L);

        Product product = productService.findById(id);
        if(cart.addProduct(product)){
            cartService.save(cart);
        }


        return "redirect:"+ request.getHeader("referer");
    }



    @GetMapping("/deleteProduct")
    @PreAuthorize("hasAuthority('cart.update')")
    public String deleteProduct(@RequestParam(name = "id") Long id, HttpServletRequest request) {

        Cart cart = cartService.findById(1L);

        Product product = productService.findById(id);
        if (cart.deleteProduct(product)){
            cartService.save(cart);
        };

        return "redirect:"+ request.getHeader("referer");
    }

}
