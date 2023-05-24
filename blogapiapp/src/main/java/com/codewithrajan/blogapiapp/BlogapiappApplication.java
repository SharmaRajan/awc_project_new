package com.codewithrajan.blogapiapp;

import com.codewithrajan.blogapiapp.entities.Role;
import com.codewithrajan.blogapiapp.helper.AppConstants;
import com.codewithrajan.blogapiapp.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogapiappApplication implements CommandLineRunner {

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BlogapiappApplication.class, args);
	}

	@Autowired
	private IRoleRepo roleRepo;

	@Override
	public void run(String... args) throws Exception {

//		System.out.println(this.passwordEncoder.encode("abcd@123"));

		try{
			Role role1 = new Role();
			role1.setRoleId(AppConstants.ADMIN_USER);
			role1.setRoleName("ROLE_ADMIN");

			Role role2 = new Role();
			role2.setRoleId(AppConstants.NORMAL_USER);
			role2.setRoleName("ROLE_NORMAL");

			Role role3 = new Role();
			role3.setRoleId(AppConstants.ROLE_USER);
			role3.setRoleName("ROLE_USER");

			List<Role> roles = List.of(role1,role2,role3);

			List<Role> result = this.roleRepo.saveAll(roles);

			result.forEach(role ->  {
				System.out.println("Role name: " + role.getRoleName());
			});
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
