package com.github.northfox.ours.kintai.kintai.api.service;

import com.github.northfox.ours.kintai.api.model.TimeResource;
import com.github.northfox.ours.kintai.api.model.TimesResource;
import com.github.northfox.ours.kintai.kintai.api.domain.TimeEntity;
import com.github.northfox.ours.kintai.kintai.api.repository.TimeRepository;
import com.github.northfox.ours.kintai.kintai.api.service.factory.TimeFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeService {

  private final TimeFactory timeFactory;
  private final TimeRepository timeRepository;

  public TimesResource findAllByUserId(Integer userId) {
    TimeEntity criteria = new TimeEntity();
    criteria.setUserId(userId);
    List<TimeEntity> times = timeRepository.findAll(Example.of(criteria));
    return timeFactory.generateTimes(times);
  }

  public TimeResource findByIdForUserById(Integer userId, Integer timeId) {
    TimeEntity found = findOrThrow(timeId);
    if (found.getUserId().equals(userId)) {
      throw new RuntimeException("記録時間が存在しないか、不正なアクセスです。");
    }
    return timeFactory.generateTime(found);
  }

  public TimeResource createForUserById(Integer userId, TimeResource timeResource) {
    return null;
  }

  public TimeResource updateForUserById(Integer userId, Integer timeId, TimeResource timeResource) {
    return null;
  }

  private TimeEntity findOrThrow(Integer timeId) {
    return timeRepository.findById(timeId)
        .orElseThrow(() -> new RuntimeException("記録時間が存在しないか、不正なアクセスです。"));
  }
}
