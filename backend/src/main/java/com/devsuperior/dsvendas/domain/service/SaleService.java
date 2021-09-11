package com.devsuperior.dsvendas.domain.service;

import com.devsuperior.dsvendas.domain.dto.SaleDTO;
import com.devsuperior.dsvendas.domain.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.domain.dto.SaleSumDTO;
import com.devsuperior.dsvendas.domain.entity.Sale;
import com.devsuperior.dsvendas.infrastructure.repository.SaleRepository;
import com.devsuperior.dsvendas.infrastructure.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return saleRepository.successGroupedBySeller();
    }
}
