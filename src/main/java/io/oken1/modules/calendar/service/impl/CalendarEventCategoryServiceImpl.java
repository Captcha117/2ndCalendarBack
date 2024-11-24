package io.oken1.modules.calendar.service.impl;

import org.springframework.stereotype.Service;
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

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CalendarEventCategoryEntity> page = this.page(
                new Query<CalendarEventCategoryEntity>().getPage(params),
                new QueryWrapper<CalendarEventCategoryEntity>()
        );

        return new PageUtils(page);
    }

}