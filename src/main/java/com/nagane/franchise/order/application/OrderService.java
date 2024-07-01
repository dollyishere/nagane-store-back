package com.nagane.franchise.order.application;

import java.util.List;

import com.nagane.franchise.order.dto.order.OrderDetailDto;
import com.nagane.franchise.order.dto.order.OrderResponseDto;
import com.nagane.franchise.order.dto.order.PaymentResponseDto;

/**
 * @author ljy
 * @since 2024.07.01
 * Order Service 코드
 * 주문 관련 Service
 * **/
public interface OrderService {
	
	/** 현재 주문 목록 조회 */
    List<OrderResponseDto> getOrderList(Long storeNo);
	
	/** 선택한 주문 상세 정보 조회*/
    OrderDetailDto getOrder(Long orderNo);
	
	/** 결제 목록 조회(영수증)*/
    List<PaymentResponseDto> getPaymentList(Long storeNo);
	
	/** 단일 결제 환불 */
    void refundPayment(Long orderNo);
    
	/** 해당 테이블 주문 내역 조회 */
    List<OrderResponseDto> getTableOrder(Long tableNo);
	
	/** 주문 신규 등록 */
    void createOrder(Long tableNo);
    
}
