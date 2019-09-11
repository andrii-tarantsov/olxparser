package com.tarantsoff;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class Item {
    private long dataId;
    private String title;
    private String href;
    private String thumbSrc;
    private String location;
    private String price;
}
