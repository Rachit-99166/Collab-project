package com.CollabFusion.COLLABFUSIONPROEJCT.repositories;

// import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import com.CollabFusion.COLLABFUSIONPROEJCT.models.customerUser;

public interface customerUserRepository extends JpaRepository<customerUser, Integer> {

    public customerUser findByEmail(String email);
}
