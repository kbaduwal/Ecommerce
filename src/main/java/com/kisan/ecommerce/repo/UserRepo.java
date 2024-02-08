package com.kisan.ecommerce.repo;

import com.kisan.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Customer, Long> {
}
