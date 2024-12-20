package io.oken1.modules.calendar.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.oken1.modules.calendar.entity.CalendarEventEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.calendar.model.EventModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 活动
 *
 * @author oken1
 * @email /
 * @date 2024-11-24 00:49:42
 */
@Mapper
public interface CalendarEventDao extends BaseMapper<CalendarEventEntity> {
    IPage<EventModel> getPageEventList(Page<EventModel> page, @Param(Constants.WRAPPER) QueryWrapper<EventModel> wrapper);

    List<EventModel> getEventListByGameIds(String[] ids);
}
