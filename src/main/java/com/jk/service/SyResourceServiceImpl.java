package com.jk.service;

import com.jk.dao.SysresourceMapper;
import com.jk.dao.UserInfoMapper;
import com.jk.pojo.SysResource;
import com.jk.pojo.Tree;
import com.jk.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Created by 高启友 on 2017/6/28.
 */

@Service
public class SyResourceServiceImpl implements SyResourceService {
    @Autowired
    private SysresourceMapper sysresourceMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<Tree> selectMainMenu(String userId) {
        List<SysResource> resourceList =  sysresourceMapper.selectMainMenu(userId);
        resourceList = new ArrayList<SysResource>(new HashSet<SysResource>(resourceList));
        List<SysResource>   list = removeDuplicate(resourceList);
        Collections.sort(resourceList, new Comparator<SysResource>() {
            @Override
            public int compare(SysResource o1, SysResource o2) {
                if (o1.getSeq() == null) {
                    o1.setSeq(1000);
                }
                if (o2.getSeq() == null) {
                    o2.setSeq(1000);
                }
                return o1.getSeq().compareTo(o2.getSeq());
            }
        });
        ArrayList<Tree> treeList = new ArrayList<Tree>();
        Tree fjtree = null;
        Tree zjtree = null;
        List<Tree> childTree = null;
        HashMap<String, String> url = null;
        for (SysResource r : resourceList) {
            fjtree = new Tree();
            if (null == r.getPid() ) {
                childTree = new ArrayList<>();
                fjtree.setId(r.getId());
                fjtree.setPid(r.getPid());
                fjtree.setText(r.getName());
                fjtree.setState("closed");
                for (SysResource zir : resourceList) {
                    if (null != zir.getPid() && zir.getPid().equals(r.getId())) {
                        zjtree = new Tree();
                        zjtree.setId(zir.getIconCls());
                        zjtree.setPid(zir.getPid());
                        zjtree.setText(zir.getName());
                        url = new  HashMap<>();
                        url.put("url", zir.getUrl());
                        zjtree.setAttributes(url);
                        childTree.add(zjtree);
                    }
                }
                fjtree.setChildren(childTree);
            }else{
                continue;
            }
            treeList.add(fjtree);
        }
        return treeList;

    }

    //新增用户
    @Override
    public int insertSelective(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    public static List<SysResource> removeDuplicate(List<SysResource> list){
        //实例化 hashSet
        Set<SysResource> set = new HashSet<SysResource>();
        //实例化 ArrayList
        List<SysResource> newList = new ArrayList<SysResource>();
      /*  Iterator<SysResource> it =  list.iterator();
        while( it.hasNext()){
        	SysResource element = it.next();
        }*/
        //  add() 返回boolean类型  true代表向集合添加元素成功   false代表向集合添加元素失败
        for(Iterator<SysResource> iter = list.iterator(); iter.hasNext();){
            SysResource element = iter.next();
            if(set.add(element)){ //返回true添加到newList //返回false不会添加newList
                newList.add(element);
            }
        }
        return newList;
    }
    }

