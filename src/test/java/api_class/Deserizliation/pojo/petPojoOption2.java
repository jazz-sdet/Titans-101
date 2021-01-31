package api_class.Deserizliation.pojo;

import lombok.Getter;

import lombok.Setter;

import java.util.List;
@Getter @Setter


public class petPojoOption2 {

    long id;
    CategoryPojo category;
    List<TagsPojo> tags;
    String name;
    List<String> photoUrls;
    String status;



}