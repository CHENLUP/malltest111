package com.blya.malltest.mapper;

import com.blya.malltest.mbg.model.PmsBrand;
import com.blya.malltest.mbg.model.PmsBrandExample;

import java.util.List;

public interface BrandMapper {


    List<PmsBrand> selectByExample(PmsBrandExample pmsBrandExample);
}
