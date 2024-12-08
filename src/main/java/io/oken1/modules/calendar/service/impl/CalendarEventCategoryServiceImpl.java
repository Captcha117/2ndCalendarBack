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

import io.oken1.modules.calendar.dao.CalendarEventCategoryDao;
import io.oken1.modules.calendar.entity.CalendarEventCategoryEntity;
import io.oken1.modules.calendar.service.CalendarEventCategoryService;


@Service("calendarEventCategoryService")
public class CalendarEventCategoryServiceImpl extends ServiceImpl<CalendarEventCategoryDao, CalendarEventCategoryEntity> implements CalendarEventCategoryService {

    @Autowired
    CalendarEventCategoryDao calendarEventCategoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventCategoryEntity> page = this.page(
                new Query<CalendarEventCategoryEntity>().getPage(params),
                new QueryWrapper<CalendarEventCategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<LinkedHashMap> getCategoryList(String gameId) {
        return calendarEventCategoryDao.getCategoryList(gameId);
    }


}