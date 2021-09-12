package com.anitesh.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.anitesh.bean.Cart;
import com.anitesh.bean.CartItem;
import com.anitesh.bean.OrderTable;
import com.anitesh.bean.Product;
import com.anitesh.bean.UserAccount;
import com.anitesh.service.AddToCart;
import com.anitesh.service.InventoryService;
import com.anitesh.service.OrderService;
import com.anitesh.service.ProductService;
import com.anitesh.service.UserService;

@Controller
@SessionAttributes({ "user" })
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;

	@Autowired
	InventoryService inventoryService;

	@Autowired
	AddToCart addToCart;

	@Autowired
	OrderService orderService;

	@RequestMapping("/")
	public ModelAndView loginPageController() {
		return new ModelAndView("login", "user", new UserAccount());
	}

	@RequestMapping("/login")
	public ModelAndView logInCheck(@ModelAttribute("user") UserAccount usr) {
		ModelAndView modelAndView = new ModelAndView();
		UserAccount userAccount = userService.getUserByCredentials(usr);
		String message;
		if (userAccount == null) {
			message = "invalid login details";

			modelAndView.addObject("message", message);
			modelAndView.setViewName("loginfailure");

		} else {
			modelAndView.addObject("user", userAccount);
			modelAndView.setViewName("index");
		}
		return modelAndView;

	}

	@RequestMapping("/products")
	public ModelAndView getAllProductsController() {
		List<Product> products = Arrays.asList(productService.getAllProducts());

		return new ModelAndView("productsPage", "products", products);
	}

	@RequestMapping("/addQuantity")
	public ModelAndView addQuantityController(@RequestParam("productId") String idString) {
		int id = Integer.parseInt(idString);
		return new ModelAndView("addQuantity", "inventoryItem", inventoryService.getInventoryById(id));
	}

	@RequestMapping("/addToCart")
	public ModelAndView addToCartController(@RequestParam("productId") String idString,
			@RequestParam("quantity") String qunatityString, HttpServletRequest request) {
		int id = Integer.parseInt(idString);
		int quantity = Integer.parseInt(qunatityString);
		String message;
		if (addToCart.checkAddToCart(id, quantity)) {
			message = "Success adding to cart";
			@SuppressWarnings("unchecked")
			List<CartItem> cartItems = (List<CartItem>) request.getSession().getAttribute("MY_CART");
			if (cartItems == null) {
				cartItems = new ArrayList<CartItem>();
				request.getSession().setAttribute("MY_CART", cartItems);
			}
			cartItems.add(new CartItem(id, quantity));
			request.getSession().setAttribute("MY_CART", cartItems);
			return new ModelAndView("addToCart", "message", message);
		}
		message = "Added quantity should be less than available";
		return new ModelAndView("addToCart", "message", message);

	}

	@RequestMapping("/cart")
	public ModelAndView cartController(HttpSession session) {
		@SuppressWarnings("unchecked")
		List<CartItem> cartItems = (List<CartItem>) session.getAttribute("MY_CART");
		if (cartItems == null) {
			cartItems = new ArrayList<>();
		}
		return new ModelAndView("cartPage", "cartProducts", cartItems);
	}

	@RequestMapping("/fillAdress")
	public ModelAndView fillAdressController() {
		return new ModelAndView("adressPage");
	}

	@RequestMapping("/placeOrder")
	public ModelAndView placeOrderController(@RequestParam("adress") String adressString, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<CartItem> cartItems = (List<CartItem>) session.getAttribute("MY_CART");
		if (cartItems == null) {
			cartItems = new ArrayList<>();
		}
		if (orderService.placeOrderService(new OrderTable(adressString, adressString, cartItems)))
			return new ModelAndView("placeOrderPage", "message",
					"Order Placed succesfully to ========	" + adressString);

		return new ModelAndView("placeOrderPage", "message", "Order placing failed");

	}

}
