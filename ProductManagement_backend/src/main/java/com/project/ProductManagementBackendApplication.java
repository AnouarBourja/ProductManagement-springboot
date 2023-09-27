package com.project;

import com.project.service.ProductService;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProductManagementBackendApplication implements CommandLineRunner
{
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    //@Autowired
    //PasswordEncoder passwordEncoder;

    public static void main(String[] args)
    {
        SpringApplication.run(ProductManagementBackendApplication.class, args);
    }


	/*
    @PostConstruct
	void init_users()
	{
		//add roles
		userService.addRole(new Role(null,"ADMIN"));
		userService.addRole(new Role(null,"AGENT"));
		userService.addRole(new Role(null,"USER"));

		//add users
		userService.saveUser(new User(null,"admin","123",true,null));
		userService.saveUser(new User(null,"anouar","123",true,null));
		userService.saveUser(new User(null,"user1","123",true,null));

		//assigning roles to users
		userService.addRoleToUser("admin", "ADMIN");

		userService.addRoleToUser("anouar", "USER");
		userService.addRoleToUser("anouar", "AGENT");

		userService.addRoleToUser("user1", "USER");
	}
	*/




    @Override
    public void run(String... args) throws Exception
    {

        //System.out.println("Password Encoded BCRYPT :******************** ");
        //System.out.println(passwordEncoder.encode("123"));
        //productService.saveProduct(new Product("PC Dell", 2600.0, new Date()));
        //productService.saveProduct(new Product("PC Asus", 2800.0, new Date()));
        //productService.saveProduct(new Product("Imp Epson", 900.0, new Date()));

    }


}
