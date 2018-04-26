package com.dx.system.controller;

import com.dx.system.domain.MicroSort;
import com.dx.system.service.MicroSortService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiewx on 2018/4/19.
 */
@RestController
@RequestMapping(value = "/microsort")
public class MicroSortController {
    @Autowired
    private MicroSortService microSortService;

    @ApiOperation(value = "保存MicroSort",notes = "保存MicroSort")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public int  save(@RequestBody MicroSort microSort){
        return microSortService.save(microSort);
    }
}
