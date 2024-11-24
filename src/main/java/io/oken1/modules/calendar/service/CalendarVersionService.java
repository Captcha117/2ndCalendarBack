package io.oken1.modules.calendar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.oken1.common.utils.PageUtils;
import io.oken1.modules.calendar.entity.CalendarVersionEntity;

import java.util.Map;

/**
 * 版本
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
public interface CalendarVersionService extends IService<CalendarVersionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

