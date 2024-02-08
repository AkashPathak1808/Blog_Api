package com.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.blog.config.AppConstant;
import com.blog.entities.Role;
import com.blog.repository.RoleRepo;

@SpringBootApplication
public class BlogAppApiApplication implements CommandLineRunner {
	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Role role1 = new Role(AppConstant.ADMIN_USER, "ROLE_ADMIN");
			Role role2 = new Role(AppConstant.NORMAL_USER, "ROLE_NORMAL");

			List<Role> roles = List.of(role1, role2);
			this.roleRepo.saveAll(roles);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
