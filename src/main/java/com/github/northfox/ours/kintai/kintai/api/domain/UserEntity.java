package com.github.northfox.ours.kintai.kintai.api.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kintai_user")
public class UserEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(name = "created_by")
  private String createdBy;
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
  @Column(name = "updated_by")
  private String updatedBy;
  @Column(name = "deleted_at")
  private LocalDateTime deletedAt;
  @Column(name = "deleted_by")
  private String deletedBy;
}