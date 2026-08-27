package com.example.recharge.repository;

import com.example.recharge.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Long> {

    // 1. find recharge by mobile number
    Recharge getByMobileNumber(String mobileNumber);

    // 2. find all recharges by operator
    List<Recharge> findByOperator(String operator);

    // 3. find all recharges by plan type
    List<Recharge> findByPlanType(String planType);

    // 4. find recharges by operator and plan type
    List<Recharge> findByOperatorAndPlanType(String operator, String planType);

    // 5. find recharges greater than particular amount
    List<Recharge> findByAmountGreaterThan(Double amount);

    // 6. find recharges less than particular amount
    List<Recharge> findByAmountLessThan(Double amount);

    // 7. find recharges between two amounts
    List<Recharge> findByAmountBetween(Double minAmount, Double maxAmount);

    // 8. count recharges by operator
    long countByOperator(String operator);

    // 9. count recharges by plan type
    long countByPlanType(String planType);

    // 10. check whether mobile number already exists
    boolean existsByMobileNumber(String mobileNumber);

    // 11. find mobile numbers containing a particular value
    List<Recharge> findByMobileNumberContaining(String mobileNumber);

    // 12. find recharges where operator contains given text
    List<Recharge> findByOperatorContainingIgnoreCase(String operator);

    // 13. find the highest recharge amount
    @Query("select max(r.amount) from Recharge r")
    Double findMaximumRechargeAmount();

    // 14. find the lowest recharge amount
    @Query("select min(r.amount) from Recharge r")
    Double findMinimumRechargeAmount();

    // 15. calculate total recharge amount
    @Query(value = "select sum(amount) from basic_recharges", nativeQuery = true)
    Double findTotalRechargeAmount();


}
