package com.devsuperior.dsvendas.infrastructure.repository;

import com.devsuperior.dsvendas.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
