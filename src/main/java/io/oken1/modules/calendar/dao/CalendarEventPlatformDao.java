package io.oken1.modules.calendar.dao;

import io.oken1.modules.calendar.entity.CalendarEventPlatformEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 活动平台
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Mapper
public interface CalendarEventPlatformDao extends BaseMapper<CalendarEventPlatformEntity> {
    List<LinkedHashMap> getPlatformList();
}
