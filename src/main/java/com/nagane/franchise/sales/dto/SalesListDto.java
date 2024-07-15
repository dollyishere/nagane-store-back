package com.nagane.franchise.sales.dto;

import com.nagane.franchise.store.domain.Store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nsr
 * @since 2024.07.01
 * 매출 List Dto
 * **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SalesListDto {

	/* 월 매출액 */
	private Long monthlySales;
	
	/* 연도 */
	private Integer year;
	
	/* 월 */
	private Integer month;
	
	/* 점포 */
    private String storeCode;
}
