package io.oken1.modules.calendar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.calendar.entity.CalendarCustomEntity;
import io.oken1.modules.calendar.entity.CalendarGameEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 游戏
 *
 * @author oken1
 * @email /
 * @date 2025-05-14 10:38:02
 */
public interface CalendarCustomService extends IService<CalendarCustomEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<LinkedHashMap> getCustomList(Long userId);
}

