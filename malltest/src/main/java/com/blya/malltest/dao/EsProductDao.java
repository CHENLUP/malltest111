package com.blya.malltest.dao;

import com.blya.malltest.nosql.elasticserach.document.EsProduct;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllEsProductList(Object o);
}
