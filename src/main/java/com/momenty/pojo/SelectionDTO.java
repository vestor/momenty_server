package com.momenty.pojo;



/**
 * Created by manish on 13/09/16.
 */

import lombok.Data;

import java.util.Map;

@Data
public class SelectionDTO {

    String id;
    String url;
    Long userId;
    String text;
    Map<String,Object> range;
}
