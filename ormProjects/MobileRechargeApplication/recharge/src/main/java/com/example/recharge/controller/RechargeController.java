package com.example.recharge.controller;

import com.example.recharge.dto.RechargeDTO;
import com.example.recharge.service.RechargeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recharge")
@Validated
public class RechargeController {

    private RechargeService service;

    public RechargeController(RechargeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<RechargeDTO> createRecharge(@Valid @RequestBody RechargeDTO rechargeDTO){
        return ResponseEntity.ok(service.createRecharge(rechargeDTO));
    }

    @GetMapping("/{rechargeId}")
    public RechargeDTO getRechargeById(@PathVariable Long rechargeId) {
        return service.getRechargeById(rechargeId);
    }

    @GetMapping
    public List<RechargeDTO> getAllRecharges() {
        return service.getAllRecharges();
    }

    @PutMapping("/update/{rechargeId}")
    public ResponseEntity<RechargeDTO> updateRecharge(@PathVariable Long rechargeId, @Valid @RequestBody RechargeDTO rechargeDTO) {
        return service.updateRecharge(rechargeId, rechargeDTO);
    }

    @DeleteMapping("/remove/{rechargeId}")
    public ResponseEntity<String> deleteRechargeById(@PathVariable Long rechargeId) {
        return service.deleteRechargeById(rechargeId);
    }

    @GetMapping("/get/operator/{operator}")
    public List<RechargeDTO> getByOperator(@PathVariable String operator) {
        return service.getByOperator(operator);
    }

    @GetMapping("/get/plan-type/{planType}")
    public List<RechargeDTO> getByPlanType(@PathVariable String planType) {
        return service.getByPlanType(planType);
    }

    @GetMapping("/get/operator-and-planType/{operator}/{planType}")
    public List<RechargeDTO> getOperatorAndPlanType(@PathVariable String operator, @PathVariable String planType) {
        return service.getOperatorAndPlanType(operator, planType);
    }

    @GetMapping("/get/amount/high/{amount}")
    public List<RechargeDTO> getByAmountGreaterThan(@PathVariable Double amount) {
        return service.getByAmountGreaterThan(amount);
    }

    @GetMapping("/get/amount/low/{amount}")
    public List<RechargeDTO> getByAmountLessThan(@PathVariable Double amount) {
        return service.getByAmountLessThan(amount);
    }

    @GetMapping("/get/amount/between/{minAmount}/{maxAmount}")
    public List<RechargeDTO> getByAmountBetween(@PathVariable Double minAmount, @PathVariable Double maxAmount) {
        return service.getByAmountBetween(minAmount, maxAmount);
    }

    @GetMapping("/search/mobile/{mobileNumber}")
    public List<RechargeDTO> searchByMobileNumber(@PathVariable String mobileNumber) {
        return service.searchByMobileNumber(mobileNumber);
    }

    @GetMapping("/search/operator/{operator}")
    public List<RechargeDTO> searchByOperator(@PathVariable String operator) {
        return service.searchByOperator(operator);
    }

    @GetMapping("/count/operator/{operator}")
    public long countByOperator(@PathVariable String operator) {
        return service.countByOperator(operator);
    }

    @GetMapping("/count/plan-type/{planType}")
    public long countByPlanType(@PathVariable String planType) {
        return service.countByPlanType(planType);
    }

    @GetMapping("/get/maximum/recharge")
    public Double getMaximumRechargeAmount() {
        return service.getMaximumRechargeAmount();
    }

    @GetMapping("/get/minimum/recharge")
    public Double getMinimumRechargeAmount() {
        return service.getMinimumRechargeAmount();
    }

    @GetMapping("/get/totalRechargeAmount")
    public Double getTotalRechargeAmount() {
        return service.getTotalRechargeAmount();
    }

    @GetMapping("/sort/amount")
    public List<RechargeDTO> getRechargesSortedByAmount() {
        return service.getRechargesSortedByAmount();
    }

    @GetMapping("/amount/greater/{amount}")
    public List<RechargeDTO> getRechargesAboveAmountUsingStream(@PathVariable Double amount) {
        return service.getRechargesAboveAmountUsingStream(amount);
    }

    @GetMapping("/count/operator")
    public Map<String, Long> getRechargeCountByOperator() {
        return service.getRechargeCountByOperator();
    }

    @GetMapping("/totalAmount/operator")
    public Map<String, Double> getTotalAmountByOperator() {
        return service.getTotalAmountByOperator();
    }

    @GetMapping("/highest/recharge")
    public ResponseEntity<RechargeDTO> getHighestRechargeUsingStream() {
        return ResponseEntity.ok(service.getHighestRechargeUsingStream());
    }


}
