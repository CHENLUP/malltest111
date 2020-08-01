package com.blya.malltest.service.impl;

import com.blya.malltest.mapper.BrandMapper;
import com.blya.malltest.mbg.mapper.PmsBrandMapper;
import com.blya.malltest.mbg.model.PmsBrand;
import com.blya.malltest.mbg.model.PmsBrandExample;
import com.blya.malltest.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/8 13:12
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private static final Logger log = LoggerFactory.getLogger(PmsBrandServiceImpl.class);

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {

        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrandDto) {
        pmsBrandDto.setId(id);
        return pmsBrandMapper.updateByExampleSelective(pmsBrandDto, new PmsBrandExample());
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }
}
