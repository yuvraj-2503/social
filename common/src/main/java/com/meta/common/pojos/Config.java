package com.meta.common.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yuvraj Singh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Config {
    private String userServerBaseUrl;
    private String baseUrl;
}
