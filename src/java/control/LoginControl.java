/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.sun.org.apache.xpath.internal.operations.Mult;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;
import model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@RequestMapping(value ="/Admin")
public class LoginControl {

    private Product pr = new Product();
    private ArrayList<Product> listProducts;
    private ApplicationContext context = null;
    private UserJDBCTemplate userJDBCTemplate = null;
    //private AccountJDBCTemplate accountJDBCTemplate = null;

    public LoginControl() {
        context = new ClassPathXmlApplicationContext("Beans.xml");
        userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
        //accountJDBCTemplate = (AccountJDBCTemplate) context.getBean("accountJDBCTemplate");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String userLogin(ModelMap model) {
        model.put("user", new User());
        return "login";
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String checkUser(@ModelAttribute User user, ModelMap model, HttpSession session) {
        if (userJDBCTemplate.checkLogin(user)) {
            String bro = (String) session.getAttribute("username");
            model.put("listProduct", pr.getList(bro));
            model.put("product", pr);
            session.setAttribute("username", user.getUsername());
            return "home";
        }
        return "loginerror";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getIndex(ModelMap model, HttpSession session) {
        String bro = (String) session.getAttribute("username");
        model.put("product", pr);
        model.put("listProduct", pr.getList(bro));
        return "home";
    }

//    @RequestMapping(value = "/user.do", method = RequestMethod.POST)
//    public String doActions(@ModelAttribute User user, @RequestParam String action, ModelMap model) {
//        String work = action.toLowerCase().toString();
//        if (work.equals("search") && !user.getUsername().equals("")) {
//            model.put("userList", userJDBCTemplate.listUsers(user.getUsername()));
//            model.put("product", pr);
//        } else {
//            model.put("userList", userJDBCTemplate.listUsers());
//            model.put("product", pr);
//        }
//        return "home";
//    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String userAdd(ModelMap model) {
        model.put("user", new User());
        model.put("actions", "addUser");
        return "add";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user, ModelMap model) {
        if (userJDBCTemplate.create(user)) {
//            model.put("user", new User());
//            model.put("product", pr);
//            model.put("userList", userJDBCTemplate.listUsers());
            return "addsuccess";
        }
        return "adderror";
    }

    @RequestMapping(value = "/editUser/{username}", method = RequestMethod.GET)
    public String editKhachHang(@PathVariable(value = "username") String username, ModelMap model) {
        User user = userJDBCTemplate.getUser(username);
        model.put("user", user);
        model.put("actions", "doEditUser");
        return "EditUser";
    }

    @RequestMapping(value = "/doEditUser", method = RequestMethod.POST)
    public String doEditUser(@ModelAttribute User user, ModelMap model) {
        userJDBCTemplate.updateFullName(user);
        return "addProductsuccess";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "id") String id, ModelMap model) {
        userJDBCTemplate.delete(id);
        model.put("user", new User());
        model.put("userList", userJDBCTemplate.listUsers());
        return "home";
    }
    /// product controller

    @RequestMapping(value = "/product.do", method = RequestMethod.POST)
    public String doAction2s(@ModelAttribute Product product, @RequestParam String action, ModelMap model, HttpSession session) {
        String work = action.toLowerCase().toString();
        String bro = (String) session.getAttribute("username");
        if (work.equals("search") && !product.getProductName().equals("")) {
            User user = new User();
            model.put("user", user);
            model.put("product", pr);
            model.put("listProduct", pr.getListByName(product.getProductName()));
        } else {
            User user = new User();
            model.put("user", user);
            model.put("product", pr);
            model.put("listProduct", pr.getList(bro));
        }
        return "home";
    }

    // controller Product( yourProduct)
    @RequestMapping(value = "/product.do2", method = RequestMethod.GET)
    public String doGetProduct(@ModelAttribute Product product, ModelMap model, HttpSession session) {
        String bro = (String) session.getAttribute("username");
        model.put("product", pr);
        model.put("listProduct", pr.getListYourProduct(bro));
        return "yourProduct";
    }

    @RequestMapping(value = "/product.do2", method = RequestMethod.POST)
    public String doPostActionYourProduct(@ModelAttribute Product product, @RequestParam String action, ModelMap model, HttpSession session) {
        String bro = (String) session.getAttribute("username");
        String work = action.toLowerCase().toString();
        if (work.equals("search") && !product.getProductName().equals("")) {
            model.put("product", pr);
            model.put("listProduct", pr.getListByName2(product.getProductName(), bro));
        } else {
            model.put("product", pr);
            model.put("listProduct", pr.getListYourProduct(bro));
        }
        return "yourProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String productAdd(ModelMap model) {
        model.put("product", new Product());
        model.put("actions", "addProductDo");
        return "addProduct";
    }

    @RequestMapping(value = "/addProductDo", method = RequestMethod.POST)//, @RequestParam("image") MultipartFile image
    public String AddProduct(@ModelAttribute Product product, ModelMap model, HttpSession session) throws IOException {
//        byte[] bytes = image.getBytes();
//        product.setImage(bytes);
        String bro = (String) session.getAttribute("username");
        product.setProductCreateBy(bro);
//System.out.println(product.getProductCreateBy()+product.getDetail()+product.getUnit()+product.getProductName()+product.getPrice());
        product.create();

//        model.put("user", new User());
//        model.put("product", pr);
//        model.put("userList", userJDBCTemplate.listUsers());
//        model.put("listProduct", pr.getList());
        return "addProductsuccess";

    }

    //COntrolller Edit Product
    @RequestMapping(value = "/editProduct/{username}", method = RequestMethod.GET)
    public String editProduct(@PathVariable(value = "username") int username, ModelMap model) {
        Product product = pr.getProduct(username);
        model.put("product", product);
        model.put("actions", "doEditProduct");
        return "editProduct";
    }

    @RequestMapping(value = "/doEditProduct", method = RequestMethod.POST)
    public String doEditProduct(@ModelAttribute Product product, ModelMap model) {
        System.out.println(product.getProductID() + product.getProductName() + product.getUnit() + product.getPrice());
        pr.UpdateProduct(product.getProductID(), product.getProductName(), product.getUnit(), product.getPrice());
        return "addProductsuccess";
    }

    @RequestMapping(value = "/deleteProduct/{username}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "username") String username, ModelMap model) {

        pr.deledteProduct(Integer.parseInt(username));
        return "addProductsuccess";

    }

    @RequestMapping(value = "/doDeleteProduct", method = RequestMethod.POST)
    public String doDeleteProduct(@ModelAttribute Product user, ModelMap model) {
        user.deledteProduct(user.getProductID());
        return "addProductsuccess";
    }

    //Controller add to Card
    @RequestMapping(value = "/addtoCart/{username}", method = RequestMethod.GET)
    public String addtoCart(@PathVariable(value = "username") int username, ModelMap model, HttpSession session) {
        Cart cart = new Cart();
        cart.setProductID(username);
        String bro = (String) session.getAttribute("username");
        if (cart.checkCart(bro, username)) {
            cart.setUsername(bro);
            cart.create();
            model.put("listProduct", pr.getList(bro));
            model.put("product", pr);
            return "home";
        }

        return "yourCartError";

    }

    @RequestMapping(value = "/yourCart", method = RequestMethod.GET)
    public String yourCart(ModelMap model, HttpSession session) {
        Cart cart = new Cart();
        String bro = (String) session.getAttribute("username");
        model.put("listProduct", cart.getProducttoCart(bro));
        model.put("product", pr);
        return "yourCart";
    }

    @RequestMapping(value = "/yourCart", method = RequestMethod.POST )
    public String DoYourCart(ModelMap model, HttpSession session) {
        String bro = (String) session.getAttribute("username");
        model.put("listProduct", pr.getList(bro));
        model.put("product", pr);
        return "home";
    }

    @RequestMapping(value = "/deleteYourCart/{username}", method = RequestMethod.GET)
    public String deleteCart(@PathVariable(value = "username") int username, ModelMap model, HttpSession session) {
        Cart cart = new Cart();
        cart.setProductID(username);
        String bro = (String) session.getAttribute("username");
        cart.deleteCart(username, bro);
        model.put("listProduct", cart.getProducttoCart(bro));
        model.put("product", pr);
        return "yourCart";
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.GET)
    public String BuyProduct(ModelMap model, HttpSession session) {
        Cart cart = new Cart();
        String bro = (String) session.getAttribute("username");
        model.put("listProduct", cart.getProducttoCart(bro));
        return "yourProductBuy";
    }

    ///xu ly Product
    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    public String doBuyProduct(ModelMap model, HttpSession session, HttpServletRequest request) {

        Cart cart = new Cart();
        Order order = new Order();
        OrderItem orderitem = new OrderItem();
        String bro = (String) session.getAttribute("username");
        ArrayList<Product> list = cart.getProducttoCart(bro);
        int[] array1;
        array1 = new int[100];
        User user = userJDBCTemplate.getUser(bro);
        float Description = Float.parseFloat(user.getDescription());
        //System.out.println(request.getParameter("1"));
        for (int i = 0; i < list.size(); i++) {
            if(request.getParameter("" + i).isEmpty()||request.getParameter("" + i).length()==0){
              model.put("msg", "You must insert your quantity");
                model.put("listProduct", list);
                return "yourProductBuy";  
            }
            array1[i] = Integer.parseInt(request.getParameter("" + i));
        }
        float total1 = 0;
        float total = 0;
        for (int i = 0; i < list.size(); i++) {
            float price = list.get(i).getPrice();
            int unit = list.get(i).getUnit();
            total = price * array1[i];
            // String usercreateby = list.get(i).getProductCreateBy();
            if (unit < array1[i] || array1[i] < 0) {
                model.put("msg", "quanity order smaller than unit product");
                model.put("listProduct", list);
                return "yourProductBuy";
            }
        }
        if (total > Description) {
            model.put("msg", "You dont have enough money, you need pay in your Account or reduce number Product!!!");
            model.put("listProduct", list);
            return "yourProductBuy";
        }
        String dob = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        int orderID = order.getNumberOfOrder();
        order.UpdateNumberOfOrder((orderID+1));
        for (int i = 0; i < list.size(); i++) {
            total1 = 0;
            float price = list.get(i).getPrice();
            total1 = price * array1[i];
            String usercreateby = list.get(i).getProductCreateBy();
            User user1 = userJDBCTemplate.getUser(usercreateby);
            //
            pr.UpdateProductUnit(list.get(i).getUnit() - array1[i], list.get(i).getProductID());
            float balance = Float.parseFloat(user1.getDescription());
            balance += total1;
            user1.setDescription("" + balance);
            //create order
            if (i == 0) {
                order.setCustomerIDbuy(bro);
                order.setCustomerIDsell(usercreateby);
                order.setOrderDate(dob);
                order.create();
            }
            //create orderitem
            userJDBCTemplate.updateFullName(user1);
            orderitem.setOrderID(orderID);
            orderitem.setProductID(list.get(i).getProductID());
            orderitem.setQuantity(array1[i]);
            orderitem.create();

            cart.deleteCart(list.get(i).getProductID(), bro);
        }
        //update description khi thanh toan
        Description -= total;
        user.setDescription("" + Description);
        userJDBCTemplate.updateFullName(user);
        model.put("msg","order sucsss");
        model.put("listProduct",cart.getProducttoCart(bro));
        return "yourProductBuy";
    }

}
