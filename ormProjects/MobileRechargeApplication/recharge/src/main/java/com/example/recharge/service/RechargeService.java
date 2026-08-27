package com.example.recharge.service;

import com.example.recharge.dto.RechargeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RechargeService {

    RechargeDTO createRecharge(RechargeDTO rechargeDTO);

    RechargeDTO getRechargeById(Long rechargeId);

    List<RechargeDTO> getAllRecharges();

    ResponseEntity<RechargeDTO> updateRecharge(Long rechargeId, RechargeDTO rechargeDTO);

    ResponseEntity<String> deleteRechargeById(Long rechargeId);

    List<RechargeDTO> getByOperator(String operator);

    List<RechargeDTO> getByPlanType(String planType);

    List<RechargeDTO> getOperatorAndPlanType(String operator, String planType);

    List<RechargeDTO> getByAmountGreaterThan(Double amount);

    List<RechargeDTO> getByAmountLessThan(Double amount);

    List<RechargeDTO> getByAmountBetween(Double minAmount, Double maxAmount);

    List<RechargeDTO> searchByMobileNumber(String mobileNumber);

    List<RechargeDTO> searchByOperator(String operator);

    long countByOperator(String operator);

    long countByPlanType(String planType);

    Double getMaximumRechargeAmount();

    Double getMinimumRechargeAmount();

    Double getTotalRechargeAmount();

    List<RechargeDTO> getRechargesSortedByAmount();

    List<RechargeDTO> getRechargesAboveAmountUsingStream(Double amount);

    Map<String, Long> getRechargeCountByOperator();

    Map<String, Double> getTotalAmountByOperator();

    RechargeDTO getHighestRechargeUsingStream();

}
