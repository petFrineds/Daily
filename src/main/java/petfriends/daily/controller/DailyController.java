package petfriends.daily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import petfriends.daily.model.Daily;
import petfriends.daily.service.DailyService;
import petfriends.daily.view.DailyRequestView;
import petfriends.daily.view.ScoreRequestView;

 @RestController
 public class DailyController {

	 @Autowired
	 DailyService dailyService;
	 
	 // 일지 단건 조회
	 @GetMapping("/dailys/{id}")
	 public ResponseEntity<Daily> findById(@PathVariable("id") Long id) throws Exception {
		 
		 return ResponseEntity.ok(dailyService.findById(id));
	 
	 }
	 
	 // 일지 목록 조회 (사용자 기준)
	 @GetMapping("/dailys/user/{userId}")
	 public List<Daily> findAllByUserId(@PathVariable("userId") String userId) throws Exception {
		 return dailyService.findAllByUserId(userId);
	 }
	 
	 // 일지 작성 (생성)
	 @PostMapping("/dailys")
	 public ResponseEntity<Daily> dailyWrited(@RequestBody DailyRequestView dailyRequest) throws Exception {
		 
		 Daily dailyWrited = dailyService.dailyWrited(dailyRequest);
		 
		 return ResponseEntity.ok(dailyWrited);
		 
	 }
	 
	 // 일지 수정 (수정: 작성일자, 산책장소, 작성내용)
//	 @PutMapping("/dailys/Change")
//	 public ResponseEntity<Daily> dailyChanged(@RequestBody DailyChangedRequestView dailyChangedRequest) throws Exception {
//			 
//		 Daily dailyChanged = dailyService.dailyChanged(dailyChangedRequest);
//			 
//		 return ResponseEntity.ok(dailyChanged);
//			 
//	 }
	 
	 // 별점 부여 및 후기 작성
	 @PutMapping("/dailys/starscore")
	 public ResponseEntity<Daily> starScoreGranted(@RequestBody ScoreRequestView scoreRequest) throws Exception {
		 
		 Daily starScoreGranted = dailyService.starScoreGranted(scoreRequest);
		 
		 return ResponseEntity.ok(starScoreGranted);
		        
	 }
	 

//	 @Autowired
//	 WalkRepository walkRepository;
	 
	 // 산책 단건 조회
//	 @GetMapping("/walks/{id}")
//	 public Walk findById(@PathVariable("id") Long id) {
//		 
//		 return walkService.findById(id);
//	 
//	 }	 
	 
	 
	 // 산책 시작 (생성)
//	 @PostMapping("/walks/start")
//	 public void walkStart(@RequestBody WalkRequestView walkRequest) throws Exception {
//		 
//		 //System.out.println("##### /walk/walkStart  called #####");
//	
//		 walkService.walkStart(walkRequest);
//		 
//	 }	 
	 
	 
	 // 산책 종료 (수정: 산책종료일자, SMS발송상태 업데이트)
//	 @PutMapping("/walks/end/{id}")
//	 public void walkEnd(@PathVariable("id") Long id) throws Exception {
//		 
//		 //System.out.println("##### /walk/walkEnd  called #####");
//		 
//		 walkService.walkEnd(id);
//		        
//	 }
	 
	 
	 // 산책 리스트 조회
//	 @GetMapping("/walks/{id}")
//	 public List<Walk> findAllByUserId(@PathVariable("id") Long id) {
//		 
//		 return walkService.findAllById(id);
//	 
//	 }
	 
	 
	 // Service를 사용하지 않는 경우 (산책 시작 함수)
		/*
		 * @PostMapping("/start") public ResponseEntity<Walk> walkStart2(@RequestBody
		 * Walk walk) {
		 * 
		 * walk.setWalkStartDate(LocalDateTime.now()); walk.setSmsStatus(SmsStatus.END);
		 * 
		 * Walk startWalk = walkRepository.save(walk);
		 * 
		 * return ResponseEntity.ok(startWalk);
		 * 
		 * }
		 */
	 
	 // Service를 사용하지 않는 경우 (산책 종료 함수)
		/*
		 * @PutMapping("/end/{userId}") public ResponseEntity<Walk>
		 * walkEnd2(@PathVariable Long id) {
		 * 
		 * Walk walk = walkRepository.findById(id).orElseThrow(null);
		 * 
		 * walk.setWalkEndDate(LocalDateTime.now());
		 * 
		 * walk.setSmsStatus(SmsStatus.END);
		 * 
		 * Walk endWalk = walkRepository.save(walk);
		 * 
		 * return ResponseEntity.ok(endWalk); }
		 */
	 
 }

 