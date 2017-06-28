package com.jk.pojo;

import java.util.Date;

public class Sysresource {
    private String id;

    private Date createdatetime;

    private String description;

    private String iconcls;

    private String name;

    private Integer seq;

    private Date updatedatetime;

    private String url;

    private String pid;

    private String resourcetypeid;

    private Integer leafnode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls == null ? null : iconcls.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Date getUpdatedatetime() {
        return updatedatetime;
    }

    public void setUpdatedatetime(Date updatedatetime) {
        this.updatedatetime = updatedatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getResourcetypeid() {
        return resourcetypeid;
    }

    public void setResourcetypeid(String resourcetypeid) {
        this.resourcetypeid = resourcetypeid == null ? null : resourcetypeid.trim();
    }

    public Integer getLeafnode() {
        return leafnode;
    }

    public void setLeafnode(Integer leafnode) {
        this.leafnode = leafnode;
    }
}