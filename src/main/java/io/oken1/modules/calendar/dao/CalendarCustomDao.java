package io.oken1.modules.calendar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.oken1.modules.calendar.entity.CalendarCustomEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 自定义日历
 *
 * @author oken1
 * @email /
 * @date 2025-05-14 10:38:02
 */
@Mapper
public interface CalendarCustomDao extends BaseMapper<CalendarCustomEntity> {
    List<LinkedHashMap> getCustomList(Long userId);

    void delCustom(String id);
}
