package com.nagane.franchise.store.api;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagane.franchise.store.application.AdminService;
import com.nagane.franchise.store.dto.admin.AdminCreateDto;
import com.nagane.franchise.util.model.response.BaseResponseBody;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * @author ljy
 * @since 2024.06.28
 * Admin controller 코드
 * 관리자 관련 controller
 * **/
@Tag(name= "관리자 API")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:${pos.port}")
public class AdminController {
	
	// 반환할 데이터를 담을 객체 생성
    private BaseResponseBody responseBody;
    
	// 의존성 주입(di)
	@Autowired
	private AdminService adminService;
	
	/**
	 * 관리자 생성
	 * @param AdminCreateDto
	 * @return Map<String, Object>>
	 */
	@PostMapping("/admin")
	public ResponseEntity<? extends BaseResponseBody> createAdmin( // BaseResponseBody 상속 받는 다양한 클래스 return 가능
			@RequestBody AdminCreateDto adminCreateDto) {
		
		// 신규 관리자 계정 생성
		try {
			this.adminService.createAdmin(adminCreateDto);
			responseBody = BaseResponseBody.of(HttpStatus.OK.value(), "성공적으로 등록되었습니다.");
		// 예외 발생 시, 에러 return
		} catch (Exception e) {
			responseBody = BaseResponseBody.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "에러가 발생했습니다.");
		}
		
		return ResponseEntity.status(responseBody.getStatusCode()).body(responseBody);
	}
	
	
	/**
	 * 관리자 로그인
	 * @param AdminCreateDto
	 * @return Map<String, Object>>
	 */
	@PostMapping("/admin/login")
	public ResponseEntity<? extends BaseResponseBody> loginAdmin(
			@RequestBody AdminCreateDto adminLoginDto) {
	    
		// 로그인
		try {
			this.adminService.loginAdmin(adminLoginDto);
			responseBody = BaseResponseBody.of(HttpStatus.OK.value(), "로그인에 성공했습니다.");
		// 예외 발생 시, 로그인 x
		} catch (NoSuchElementException se) {
			responseBody = BaseResponseBody.of(HttpStatus.NOT_FOUND.value(), se.getMessage());
		} catch (Exception e) {
			responseBody = BaseResponseBody.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "에러가 발생했습니다.");
		}
		
		return ResponseEntity.status(responseBody.getStatusCode()).body(responseBody);
	}
	
}
