package com.seasonsfood.mall.util.model;

import java.io.Serializable;


/**
 * @author ron
 */
public class TreeModel implements Serializable{
    private static final long serialVersionUID = 7464133068368805975L;
    private Long id;
    private Long pId;
    private String name;

    public TreeModel() {
        super();
    }

    public TreeModel(Long id, Long pId, String name) {
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
