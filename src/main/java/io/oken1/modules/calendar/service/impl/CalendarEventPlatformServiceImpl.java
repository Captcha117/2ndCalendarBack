package io.oken1.modules.calendar.service.impl;

import io.oken1.modules.calendar.dao.CalendarGameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarEventPlatformDao;
import io.oken1.modules.calendar.entity.CalendarEventPlatformEntity;
import io.oken1.modules.calendar.service.CalendarEventPlatformService;


@Service("calendarEventPlatformService")
public class CalendarEventPlatformServiceImpl extends ServiceImpl<CalendarEventPlatformDao, CalendarEventPlatformEntity> implements CalendarEventPlatformService {

    @Autowired
    CalendarEventPlatformDao calendarEventPlatformDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventPlatformEntity> page = this.page(
                new Query<CalendarEventPlatformEntity>().getPage(params),
                new QueryWrapper<CalendarEventPlatformEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LinkedHashMap> getPlatformList() {
        return calendarEventPlatformDao.getPlatformList();
    }
}