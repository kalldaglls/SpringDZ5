package com.forgeeks.SpringDZ5.service;

import com.forgeeks.SpringDZ5.entities.Role;
import com.forgeeks.SpringDZ5.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
