package com.blya.malltest.service;

import com.blya.malltest.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrandDto);

    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);
}
