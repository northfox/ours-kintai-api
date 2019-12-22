package com.github.northfox.ours.kintai.kintai.api.repository;

import com.github.northfox.ours.kintai.kintai.api.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
