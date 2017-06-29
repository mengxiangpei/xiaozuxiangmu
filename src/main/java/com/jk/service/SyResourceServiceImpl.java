package com.jk.service;

import com.jk.dao.SysresourceMapper;
import com.jk.dao.UserInfoMapper;
import com.jk.pojo.Sysresource;
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
        List<Sysresource> resourceList =  sysresourceMapper.selectMainMenu(userId);
        resourceList = new ArrayList<Sysresource>(new HashSet<Sysresource>(resourceList));
        List<Sysresource>   list = removeDuplicate(resourceList);
        Collections.sort(resourceList, new Comparator<Sysresource>() {
            @Override
            public int compare(Sysresource o1, Sysresource o2) {
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
        for (Sysresource r : resourceList) {
            fjtree = new Tree();
            if (null == r.getPid() ) {
                childTree = new ArrayList<>();
                fjtree.setId(r.getId());
                fjtree.setPid(r.getPid());
                fjtree.setText(r.getName());
                fjtree.setState("closed");
                for (Sysresource zir : resourceList) {
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

    public static List<Sysresource> removeDuplicate(List<Sysresource> list){
        //实例化 hashSet
        Set<Sysresource> set = new HashSet<Sysresource>();
        //实例化 ArrayList
        List<Sysresource> newList = new ArrayList<Sysresource>();
      /*  Iterator<SysResource> it =  list.iterator();
        while( it.hasNext()){
        	SysResource element = it.next();
        }*/
        //  add() 返回boolean类型  true代表向集合添加元素成功   false代表向集合添加元素失败
        for(Iterator<Sysresource> iter = list.iterator(); iter.hasNext();){
            Sysresource element = iter.next();
            if(set.add(element)){ //返回true添加到newList //返回false不会添加newList
                newList.add(element);
            }
        }
        return newList;
    }
    }

