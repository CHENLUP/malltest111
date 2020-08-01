package com.blya.malltest.nosql.elasticserach.repository;

import com.blya.malltest.nosql.elasticserach.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/16 10:55
 **/
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, String> {


    /**
     * 搜索查询
     *
     * @param name              商品名称
     * @param subTitle          商品标题
     * @param keywords          商品关键字
     * @param page              分页信息
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
