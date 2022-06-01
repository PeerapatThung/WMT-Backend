package com.project.demo.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryFilter {
    Integer pageNo;
    Integer pageSize;
}
