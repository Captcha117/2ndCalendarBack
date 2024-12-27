package io.oken1.modules.calendar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.oken1.modules.calendar.entity.CalendarGameRewardEntity;

import java.util.List;
import java.util.Map;

/**
 * 游戏奖励
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
public interface CalendarGameRewardService extends IService<CalendarGameRewardEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CalendarEventRewardEntity> getRewardListByGameId(String gameId);
}

