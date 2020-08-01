package com.blya.malltest.controller;

import com.blya.malltest.comm.api.CommonPage;
import com.blya.malltest.comm.api.CommonResult;
import com.blya.malltest.mbg.model.PmsBrand;
import com.blya.malltest.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/8 10:27
 **/
@Api(tags = "PmsBrandController", description = "商品品牌管理")
@Validated
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService demoService;

    private static final Logger log = LoggerFactory.getLogger(PmsBrandController.class);

    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(demoService.listAllBrand());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult<List<PmsBrand>> createBrand(@Valid @RequestBody PmsBrand pmsBrand, BindingResult bindingResult) {
        CommonResult commonResult;

        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                //日志打印不符合校验的字段名和错误提示
                log.error("error field is : {} ,message is : {}", fieldError.getField(), fieldError.getDefaultMessage());
                CommonResult<Object> failed = CommonResult.failed(fieldError.getDefaultMessage().toString());
            });
        }
        int addCode = demoService.createBrand(pmsBrand);
        if (addCode > 0){
            commonResult = CommonResult.success(pmsBrand);
            log.info("createBrand:{}", pmsBrand);
        }else {
            commonResult = CommonResult.failed("交易失败");
            log.info("createBrand:{}", pmsBrand);
        }
        return commonResult;

    }

    @ApiOperation(value = "更新商品品牌")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){

        CommonResult commonResult;

        int code = demoService.updateBrand(id, pmsBrandDto);
        if (code > 0){
            commonResult = CommonResult.success(pmsBrandDto);
        }else {
            commonResult = CommonResult.failed("失败");
        }
        return commonResult;
    }

    @ApiOperation(value = "分页查询所有数据")
    @RequestMapping(value = "/listBrand", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {


        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

}
