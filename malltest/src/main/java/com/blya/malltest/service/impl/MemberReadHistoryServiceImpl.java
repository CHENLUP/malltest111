package com.blya.malltest.service.impl;

import com.blya.malltest.nosql.mongodb.document.MemberReadHistory;
import com.blya.malltest.nosql.mongodb.repository.MemberReadHistoryRepository;
import com.blya.malltest.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Chenlup
 * Date 2020/7/10 14:32
 **/
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository readHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        readHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {

        List<MemberReadHistory> delateList = new ArrayList<>();
        for (String id : ids) {
            MemberReadHistory readHistory = new MemberReadHistory();
            readHistory.setId(id);
            delateList.add(readHistory);
        }
        readHistoryRepository.deleteAll(delateList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> list(Long memberId) {
        return readHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
