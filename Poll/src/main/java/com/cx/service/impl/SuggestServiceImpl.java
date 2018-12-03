package com.cx.service.impl;

import com.cx.dao.ISuggestDao;
import com.cx.entity.Suggest;
import com.cx.service.ISuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
@Service
@Transactional
public class SuggestServiceImpl implements ISuggestService{

    @Autowired
    private ISuggestDao suggestDao;

    @Override
    public void save(Suggest suggest) {
        suggestDao.save(suggest);
    }

    @Override
    public long countPoll(String clazzName) {
        return suggestDao.countPoll(clazzName);
    }

    @Override
    public List<String> distinctUniqueKey(String clazzName) {
        //获取所有包含重复的...
        List<String> ukeys = suggestDao.getUniqueKeys(clazzName);

        /**
         * [f2858214-3e3b-40de-a970-a21a09156fbf, b6165153-5e74-472a-8ff0-60f83e1cd23b,
         * a2a02303-26ea-4684-9beb-d6fd7f73be0c, 8b64fc33-afdb-4068-9462-99ef75935c23,
         * 8b64fc33-afdb-4068-9462-99ef75935c23]
         */

        for(int i=0;i<ukeys.size();i++){
            for(int j=i+1;j<ukeys.size();j++){
                if(ukeys.get(i).equals(ukeys.get(j))){
                    ukeys.remove(j);
                    j--;
                }
            }
        }
        return ukeys;
    }

    @Override
    public long countJoinNum(String ukey) {

        return suggestDao.countJoinNum(ukey);
    }

    @Override
    public List<String> getContentsByUkey(String ukey) {
        return suggestDao.getContentsByUkey(ukey);
    }
}
