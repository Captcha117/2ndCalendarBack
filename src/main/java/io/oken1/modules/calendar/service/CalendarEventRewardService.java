package io.oken1.modules.calendar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;

import java.util.Map;

/**
 * 活动奖励
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
public interface CalendarEventRewardService extends IService<CalendarEventRewardEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

