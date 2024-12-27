package io.oken1.modules.calendar.dao;

import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 活动奖励
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Mapper
public interface CalendarEventRewardDao extends BaseMapper<CalendarEventRewardEntity> {

    List<CalendarEventRewardEntity> getRewardListByEventId(String eventId);
}
