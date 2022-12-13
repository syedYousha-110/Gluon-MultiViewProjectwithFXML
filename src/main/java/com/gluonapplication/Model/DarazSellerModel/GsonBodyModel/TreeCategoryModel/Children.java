package com.gluonapplication.Model.DarazSellerModel.GsonBodyModel.TreeCategoryModel;

import java.util.List;

public class Children {

    private long categoryId;
    private List<Children> children;
    private boolean leaf;
    private String name;
    private boolean var;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVar() {
        return var;
    }

    public void setVar(boolean var) {
        this.var = var;
    }
}
