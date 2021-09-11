package com.devsuperior.dsvendas.domain.service;

import com.devsuperior.dsvendas.domain.entity.Seller;
import com.devsuperior.dsvendas.domain.dto.SellerDTO;
import com.devsuperior.dsvendas.infrastructure.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerDTO> findAll() {
        List<Seller> result = sellerRepository.findAll();
        return result.stream().map(SellerDTO::new).collect(Collectors.toList());
    }

}
