package io.oken1.modules.game.controller;

import io.oken1.common.utils.R;
import io.oken1.modules.game.dao.GameDao;
import io.oken1.modules.game.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;


@Api(value = "游戏数据", tags = {"游戏数据"})
@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

    @Autowired
    GameDao gameDao;

    /**
     * 获取简要游戏列表
     *
     * @return 分类结果
     */
    @ApiOperation("获取游戏列表")
    @GetMapping("/gameList")
    public R gameList() {
        List<LinkedHashMap> result = gameService.getGameList();
        return R.ok().put("result", result);
    }

}
