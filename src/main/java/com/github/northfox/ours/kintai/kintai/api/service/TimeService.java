package com.github.northfox.ours.kintai.kintai.api.service;

import com.github.northfox.ours.kintai.api.model.TimeResource;
import com.github.northfox.ours.kintai.api.model.TimesResource;
import com.github.northfox.ours.kintai.kintai.api.domain.TimeEntity;
import com.github.northfox.ours.kintai.kintai.api.repository.TimeRepository;
import com.github.northfox.ours.kintai.kintai.api.service.factory.TimeFactory;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    if (timeResource.getUserId().equals(userId)) {
      TimeEntity time = timeFactory.parse(timeResource);
      timeRepository.save(time);
      return timeFactory.generateTime(time);
    }
    throw new RuntimeException("ユーザが存在しないか、登録情報がユーザと一致しません。");
  }

  public TimeResource updateForUserById(Integer userId, Integer timeId, TimeResource timeResource) {
    if (timeResource.getUserId().equals(userId)) {
      TimeEntity found = findOrThrow(timeId);

      Optional<LocalDateTime> inTime = Optional.ofNullable(timeResource.getInTime())
          .map(t -> t.toLocalDateTime());
      Optional<LocalDateTime> outTime = Optional.ofNullable(timeResource.getOutTime())
          .map(t -> t.toLocalDateTime());

      found.setCategory(timeResource.getCategory());
      found.setInTime(inTime.orElse(null));
      found.setOutTime(outTime.orElse(null));
      found.setUpdatedAt(LocalDateTime.now());
      found.setUpdatedBy("api"); // TODO want requester
      TimeEntity updated = timeRepository.save(found);
      return timeFactory.generateTime(updated);
    }
    throw new RuntimeException("ユーザが存在しないか、登録情報がユーザと一致しません。");
  }

  private TimeEntity findOrThrow(Integer timeId) {
    return timeRepository.findById(timeId)
        .orElseThrow(() -> new RuntimeException("記録時間が存在しないか、不正なアクセスです。"));
  }
}
