package com.example.emp.service;

import com.example.emp.dto.LoginRequestDTO;
import com.example.emp.dto.LoginResponseDTO;
import com.example.emp.dto.RequestDTO;
import com.example.emp.dto.ResponseDTO;
import com.example.emp.entity.NormalEmpEntity;
import com.example.emp.repo.NormalEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NormalEmpService {

    @Autowired
    private NormalEmpRepository repo;

    public ResponseDTO saveEmployee(RequestDTO requestDTO) {
        NormalEmpEntity employee = new NormalEmpEntity();

        employee.setEmpName(requestDTO.getEmpName());
        employee.setEmail(requestDTO.getEmail());
        employee.setDepartment(requestDTO.getDepartment());
        employee.setSalary(requestDTO.getSalary());
        employee.setPassword(requestDTO.getPassword());

        NormalEmpEntity savedEmployee = repo.save(employee);

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setEmpId(savedEmployee.getEmpId());
        responseDTO.setEmpName(savedEmployee.getEmpName());
        responseDTO.setDepartment(savedEmployee.getDepartment());
        responseDTO.setMessage("Employee saved successfully.");

        return responseDTO;
    }


    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        NormalEmpEntity employee = repo.findByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()).orElse(null);
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setEmpName(employee.getEmpName());
        loginResponseDTO.setMessage("Loging successful.");
        return loginResponseDTO;
    }

}
