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
public class Result {
    private int errorCode;
    private String errorMessage;
}
