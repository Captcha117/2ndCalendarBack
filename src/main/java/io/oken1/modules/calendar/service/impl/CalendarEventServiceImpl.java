package io.oken1.modules.calendar.service.impl;

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

import io.oken1.modules.calendar.dao.CalendarEventDao;
import io.oken1.modules.calendar.entity.CalendarEventEntity;
import io.oken1.modules.calendar.service.CalendarEventService;


@Service("calendarEventService")
public class CalendarEventServiceImpl extends ServiceImpl<CalendarEventDao, CalendarEventEntity> implements CalendarEventService {

    @Autowired
    private CalendarEventDao calendarEventDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventEntity> page = this.page(
                new Query<CalendarEventEntity>().getPage(params),
                new QueryWrapper<CalendarEventEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LinkedHashMap> getByIds(String[] ids) {
        return calendarEventDao.getEventList(ids);
    }

}