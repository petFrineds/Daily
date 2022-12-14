package petfriends.daily.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import petfriends.daily.model.Daily;
import petfriends.daily.repository.DailyRepository;
import petfriends.daily.view.DailyRequestView;
import petfriends.daily.view.ScoreRequestView;

@Service
public class DailyService {
	 
	 @Autowired
	 DailyRepository dailyRepository;
	 
	 // 일지 단건 조회
	 public Daily findById(Long id) throws RuntimeException{
		 return dailyRepository.findById(id).orElseThrow(()->new RuntimeException("일지 건이 존재하지 않습니다."));
	 }
	 
	 // 일지 목록 조회 (사용자 기준)
	 public List<Daily> findAllByUserId(String userId) {
		 return dailyRepository.findAllByUserId(userId);
	 } 
	 
	 // 일지 목록 조회 (도그워커 기준)
	 public List<Daily> findByDogWalkerId(String dogWalkerId) {
		 return dailyRepository.findByDogWalkerId(dogWalkerId);
	 } 
	 
	 // 일지 작성
	 @Transactional
	 public Daily dailyWrited(DailyRequestView dailyRequest) throws Exception {
		 
		 Daily dailyWrited = Daily.of(
				 dailyRequest.getContents(),
				 //dailyRequest.getWalkingPlace(),
				 dailyRequest.getWalkId(), 
				 dailyRequest.getUserId(),
				 dailyRequest.getUserName(),
				 dailyRequest.getDogWalkerId(),
				 dailyRequest.getDogWalkerName(),
				 dailyRequest.getWalkStartDate(),
				 dailyRequest.getWalkEndDate()
				 );
		 
		 // 일지작성 일자는 현재일시분으로 세팅
//		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		 String dateStr = format.format(Calendar.getInstance().getTime());
//		 dailyWrited.setDailyRecordDate(dateStr);
		 
		 // 원본
//		 LocalDateTime current = LocalDateTime.now();
//		 String dateStr = current.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//		 dailyWrited.setDailyRecordDate(dateStr);
		 
		 String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		 dailyWrited.setDailyRecordDate(dateStr);
		 
		 // 강제로 현재 시간에 9시간 더하기 (west2 오레곤 시간과 맞추기 위함)
//		 LocalDateTime current = LocalDateTime.now();
//		 LocalDateTime targetDateTime2 = current
//				 .plusHours(9);
//				 
//		 String dateStr = targetDateTime2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//		 dailyWrited.setDailyRecordDate(dateStr);
		 
		 return dailyRepository.save(dailyWrited);
		 
	 }
	 
	// 일지 수정
//	@Transactional
//	public Daily dailyChanged(DailyChangedRequestView dailyChangedRequest) throws Exception {
//			 
//		// 해당건 존재여부 체크
//		dailyRepository.findById(dailyChangedRequest.getId()).orElseThrow(()->new RuntimeException("일지 건이 존재하지 않습니다."));
//		
//		// 해당건 조회
//		Daily dailyChanged = dailyRepository.findById(dailyChangedRequest.getId()).get();
//		
//		// 별점을 이미 부여하였으면, 수정불가
//		if(dailyChanged.getStarScore() != 0) {
//					 
//			throw new Exception("해당 건은 이미 별점을 부여하여 수정할 수 없습니다.");
//					 
//		}
//		
//		// 일지작성 일자는 현재일시분으로 업데이트
//		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String dateStr = format.format(Calendar.getInstance().getTime());
//		dailyChanged.setDailyRecordDate(dateStr);
//		
//		// 작성내용 업데이트
//		dailyChanged.setContents(dailyChangedRequest.getContents());
//		
//		// 산책장소 업데이트
//		dailyChanged.setWalkingPlace(dailyChangedRequest.getWalkingPlace());
//		 
//		return dailyRepository.save(dailyChanged);
//		
//	 }

	 
	 // 별점 부여 및 후기 작성
	 @Transactional
	 public Daily starScoreGranted(ScoreRequestView scoreRequest) throws Exception {
		 if(scoreRequest.getStarScore() <= 0 || scoreRequest.getStarScore() > 5) 
			 throw new Exception("별점은 1 ~ 5점 중 부여 가능합니다.");

		 // 해당건 조회
		 Daily starScoreGranted = dailyRepository.findById(scoreRequest.getId()).orElseThrow(()->new RuntimeException("일지 건이 존재하지 않습니다."));
			
		 //문자열 비교 취소
		 //String starScore = Integer.toString(starScoreGranted.getStarScore());
		 
		 // 별점을 이미 부여한 상태인지 체크
		 if(starScoreGranted.getStarScore() != 0) 
			 throw new Exception("해당 건은 이미 별점을 부여하셨습니다.");
			 
		 // 부여된 별점 세팅
		 starScoreGranted.setStarScore(scoreRequest.getStarScore());
		 
		 // 작성한 후기 세팅
		 starScoreGranted.setReview(scoreRequest.getReview());
		 
		 return dailyRepository.save(starScoreGranted);
		 
	 }
	 
		 
}

