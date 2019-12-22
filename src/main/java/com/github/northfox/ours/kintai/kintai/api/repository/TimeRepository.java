package com.github.northfox.ours.kintai.kintai.api.repository;

import com.github.northfox.ours.kintai.kintai.api.domain.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<TimeEntity, Integer> {

}
