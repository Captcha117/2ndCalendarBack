package io.oken1.modules.calendar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.calendar.entity.CalendarEventEntity;
import io.oken1.modules.calendar.model.EventModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
public interface CalendarEventService extends IService<CalendarEventEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils getPageList(Map<String, Object> params);

    List<EventModel> getByIds(String[] ids);
}

