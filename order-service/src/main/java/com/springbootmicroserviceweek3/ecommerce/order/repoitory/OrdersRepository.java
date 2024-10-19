package com.springbootmicroserviceweek3.ecommerce.order.repoitory;

import com.springbootmicroserviceweek3.ecommerce.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
