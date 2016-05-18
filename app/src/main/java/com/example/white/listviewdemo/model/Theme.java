package com.example.white.listviewdemo.model;

/**
 * Created by white on 2016/5/12.
 */
public class Theme {
    /*{
        "limit": 1000,
        "subscribed": [ ],
        "others": [
            // Themes单元
            {
                "color": 15007,
                "thumbnail": "http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg",
                "description": "了解自己和别人，了解彼此的欲望和局限。",
                "id": 13,
                "name": "日常心理学"
            }
        ]
    }*/
    private String name;
    private String id;
    private int imageViewid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageViewid() {
        return imageViewid;
    }

    public void setImageViewid(int imageViewid) {
        this.imageViewid = imageViewid;
    }
}
