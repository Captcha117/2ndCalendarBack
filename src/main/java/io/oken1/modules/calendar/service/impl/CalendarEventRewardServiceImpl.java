package io.oken1.modules.calendar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.oken1.common.utils.PageUtils;
import io.oken1.common.utils.Query;

import io.oken1.modules.calendar.dao.CalendarEventRewardDao;
import io.oken1.modules.calendar.entity.CalendarEventRewardEntity;
import io.oken1.modules.calendar.service.CalendarEventRewardService;


@Service("calendarEventRewardService")
public class CalendarEventRewardServiceImpl extends ServiceImpl<CalendarEventRewardDao, CalendarEventRewardEntity> implements CalendarEventRewardService {

    @Autowired
    CalendarEventRewardDao calendarEventRewardDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventRewardEntity> page = this.page(
                new Query<CalendarEventRewardEntity>().getPage(params),
                new QueryWrapper<CalendarEventRewardEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CalendarEventRewardEntity> getRewardListByEventId(String eventId) {
        return calendarEventRewardDao.getRewardListByEventId(eventId);
    }

}