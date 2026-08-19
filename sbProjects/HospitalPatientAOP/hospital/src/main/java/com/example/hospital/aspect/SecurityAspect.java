package com.example.hospital.aspect;

import com.example.hospital.annotation.RequiresRole;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {

    private String currentUserRole = "ADMIN";   // DOCTOR, ADMIN, RECEPTIONIST

    @Before(
            "execution(* com.example.hospital.service.*.*(..)) " +
                    "&& @annotation(requiresRole)"
    )
    public void checkRole(JoinPoint joinPoint, RequiresRole requiresRole) {
        String requiredRole = requiresRole.value();
        System.out.println("[SECURITY] " + joinPoint.getSignature().getName() + " requires " + requiredRole);
        if(!currentUserRole.equals(requiredRole)) {
            throw new SecurityException("Access Denied. Required role: " + requiredRole + ", Current role: " + currentUserRole);
        }
        System.out.println("[SECURITY] Access Granted.");
    }

}
