package io.oken1.modules.calendar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.calendar.entity.CalendarEventPlatformEntity;

import java.util.Map;

/**
 * 活动平台
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
public interface CalendarEventPlatformService extends IService<CalendarEventPlatformEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

