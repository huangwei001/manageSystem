package com.test.springBoot.manageApi.Utils;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Page<T> implements Serializable {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

    private Integer total = 0;

    private List<T> rows = new ArrayList<>();



}
