package com.lcwd.electroinc.store.ElectronicStore.repostories;

import com.lcwd.electroinc.store.ElectronicStore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReopsitory extends JpaRepository<User, String> {




}
