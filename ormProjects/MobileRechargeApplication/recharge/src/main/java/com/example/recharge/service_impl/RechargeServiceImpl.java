package com.example.recharge.service_impl;

import com.example.recharge.dto.RechargeDTO;
import com.example.recharge.entity.Recharge;
import com.example.recharge.exception.Constants;
import com.example.recharge.exception.DuplicateRechargeException;
import com.example.recharge.exception.RechargeNotFoundException;
import com.example.recharge.repository.RechargeRepository;
import com.example.recharge.service.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeRepository repo;

    @Override
    public RechargeDTO createRecharge(RechargeDTO rechargeDTO) {

        String mobileNumber = normalizeMobileNumber(rechargeDTO.getMobileNumber());

        if(repo.existsByMobileNumber(mobileNumber)) {
            throw new DuplicateRechargeException(Constants.DUPLICATE_RECHARGE + ": " + mobileNumber);
        }

        Recharge recharge = new Recharge();
        recharge.setMobileNumber(mobileNumber);
        recharge.setOperator(rechargeDTO.getOperator());
        recharge.setAmount(rechargeDTO.getAmount());
        recharge.setPlanType(rechargeDTO.getPlanType());

        Recharge savedRecharge = repo.save(recharge);

        return convertToDTO(savedRecharge);

    }


    @Override
    public RechargeDTO getRechargeById(Long rechargeId) {
        Recharge recharge = findRechargeById(rechargeId);
        return convertToDTO(recharge);
    }


    @Override
    public List<RechargeDTO> getAllRecharges() {
        return repo.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public ResponseEntity<RechargeDTO> updateRecharge(Long rechargeId, RechargeDTO rechargeDTO) {
        Recharge existingRecharge = findRechargeById(rechargeId);
        String mobileNumber = normalizeMobileNumber(rechargeDTO.getMobileNumber());

        Recharge rechargeWithSameMobileNumber = repo.getByMobileNumber(mobileNumber);

        if(rechargeWithSameMobileNumber != null && rechargeWithSameMobileNumber.getRechargeId().equals(rechargeId)) {
            throw new DuplicateRechargeException(Constants.DUPLICATE_RECHARGE + ": " + mobileNumber);
        }

        existingRecharge.setMobileNumber(mobileNumber);
        existingRecharge.setOperator(rechargeDTO.getOperator());
        existingRecharge.setAmount(rechargeDTO.getAmount());
        existingRecharge.setPlanType(rechargeDTO.getPlanType());

        Recharge updatedRecharge = repo.save(existingRecharge);

        return ResponseEntity.ok(convertToDTO(updatedRecharge));
    }


    @Override
    public ResponseEntity<String> deleteRechargeById(Long rechargeId) {
        Recharge recharge = findRechargeById(rechargeId);

        if(recharge == null) {
            throw new RechargeNotFoundException("Recharge not found for the ID : " + rechargeId);
        }

        repo.deleteById(rechargeId);

        return ResponseEntity.ok("Recharge record removed successfully.");
    }


    @Override
    public List<RechargeDTO> getByOperator(String operator) {
        return repo.findByOperator(operator).stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> getByPlanType(String planType) {
        return repo.findByPlanType(planType).stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> getOperatorAndPlanType(String operator, String planType) {
        return repo.findByOperatorAndPlanType(operator, planType).stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> getByAmountGreaterThan(Double amount) {
        return repo.findByAmountGreaterThan(amount).stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> getByAmountLessThan(Double amount) {
        return repo.findByAmountLessThan(amount).stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> getByAmountBetween(Double minAmount, Double maxAmount) {
        return repo.findByAmountBetween(minAmount, maxAmount).stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> searchByMobileNumber(String mobileNumber) {
        String formattedMobileNumber = normalizeMobileNumberForSearch(mobileNumber);

        return repo.findByMobileNumberContaining(formattedMobileNumber).stream()
                .map(this::convertToDTO)
                .toList();

    }


    @Override
    public List<RechargeDTO> searchByOperator(String operator) {
        return repo.findByOperatorContainingIgnoreCase(operator)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public long countByOperator(String operator) {
        return repo.countByOperator(operator);
    }


    @Override
    public long countByPlanType(String planType) {
        return repo.countByPlanType(planType);
    }


    @Override
    public Double getMaximumRechargeAmount() {
        return repo.findMaximumRechargeAmount() != null ? repo.findMaximumRechargeAmount() : 0.0;
    }

    @Override
    public Double getMinimumRechargeAmount() {
        return repo.findMinimumRechargeAmount() != null ? repo.findMinimumRechargeAmount() : 0.0;
    }


    @Override
    public List<RechargeDTO> getRechargesSortedByAmount() {
        return repo.findAll().stream()
                .sorted(Comparator.comparingDouble(Recharge::getAmount))
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public List<RechargeDTO> getRechargesAboveAmountUsingStream(Double amount) {
        return repo.findAll().stream()
                .filter(recharge -> recharge.getAmount() > amount)
                .map(this::convertToDTO)
                .toList();
    }


    @Override
    public Map<String, Long> getRechargeCountByOperator() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(
                        Recharge::getOperator,
                        Collectors.counting()));
    }


    @Override
    public RechargeDTO getHighestRechargeUsingStream() {
        return repo.findAll().stream()
                .max(Comparator.comparingDouble(Recharge::getAmount))
                .map(this::convertToDTO)
                .orElseThrow(() -> new RechargeNotFoundException("No recharge record found."));
    }


    @Override
    public Map<String, Double> getTotalAmountByOperator() {
        return repo.findAll().stream()
                .collect(Collectors.groupingBy(
                        Recharge::getOperator,
                        Collectors.summingDouble(Recharge::getAmount)));
    }


    @Override
    public Double getTotalRechargeAmount() {
        Double total = repo.findTotalRechargeAmount();
        return total != null ? total : 0.0;
    }


    private Recharge findRechargeById(Long rechargeId) {
        return repo.findById(rechargeId)
                .orElseThrow(() -> new RechargeNotFoundException("Recharge not found with the ID : " + rechargeId));
    }


    private String normalizeMobileNumber(String mobileNumber) {
        if(mobileNumber.startsWith("+91 ")) {
            return mobileNumber;
        }
        return "+91 " + mobileNumber;
    }

    private String normalizeMobileNumberForSearch(String mobileNumber) {
        if(mobileNumber.startsWith("+91 ")) {
            return mobileNumber;
        }
        return "+91 " + mobileNumber;
    }


    private RechargeDTO convertToDTO(Recharge recharge) {
        return new RechargeDTO(
                recharge.getRechargeId(),
                recharge.getMobileNumber(),
                recharge.getOperator(),
                recharge.getAmount(),
                recharge.getPlanType()
        );
    }

}
