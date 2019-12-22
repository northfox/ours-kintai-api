package com.github.northfox.ours.kintai.kintai.api.service;

import com.github.northfox.ours.kintai.api.model.UserResource;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  public List<UserResource> findAll() {
    return Arrays.asList(new UserResource());
  }
}
