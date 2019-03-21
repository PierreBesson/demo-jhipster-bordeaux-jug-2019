package com.jhipster.demo.crm.service;

import com.jhipster.demo.crm.domain.ProductOrder;
import com.jhipster.demo.crm.repository.ProductOrderRepository;
import com.jhipster.demo.crm.repository.search.ProductOrderSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing ProductOrder.
 */
@Service
@Transactional
public class ProductOrderService {

    private final Logger log = LoggerFactory.getLogger(ProductOrderService.class);

    private final ProductOrderRepository productOrderRepository;

    private final ProductOrderSearchRepository productOrderSearchRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository, ProductOrderSearchRepository productOrderSearchRepository) {
        this.productOrderRepository = productOrderRepository;
        this.productOrderSearchRepository = productOrderSearchRepository;
    }

    /**
     * Save a productOrder.
     *
     * @param productOrder the entity to save
     * @return the persisted entity
     */
    public ProductOrder save(ProductOrder productOrder) {
        log.debug("Request to save ProductOrder : {}", productOrder);
        ProductOrder result = productOrderRepository.save(productOrder);
        productOrderSearchRepository.save(result);
        return result;
    }

    /**
     * Get all the productOrders.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ProductOrder> findAll(Pageable pageable) {
        log.debug("Request to get all ProductOrders");
        return productOrderRepository.findAll(pageable);
    }


    /**
     * Get one productOrder by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<ProductOrder> findOne(Long id) {
        log.debug("Request to get ProductOrder : {}", id);
        return productOrderRepository.findById(id);
    }

    /**
     * Delete the productOrder by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete ProductOrder : {}", id);
        productOrderRepository.deleteById(id);
        productOrderSearchRepository.deleteById(id);
    }

    /**
     * Search for the productOrder corresponding to the query.
     *
     * @param query the query of the search
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<ProductOrder> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of ProductOrders for query {}", query);
        return productOrderSearchRepository.search(queryStringQuery(query), pageable);    }
}
