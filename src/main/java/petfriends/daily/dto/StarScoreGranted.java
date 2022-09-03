package petfriends.daily.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import petfriends.AbstractEvent;
import petfriends.daily.model.WalkingPlace;

public class StarScoreGranted extends AbstractEvent {

	private Long id;					// 일지ID
    private String dailyRecordDate;		// 작성일자
    
//    @Enumerated(EnumType.STRING)
//    private WalkingPlace walkingPlace;	// 산책장소
    
    private String contents;			// 작성내용
    private int starScore;				// 별점
    private String review;				// 후기
    private Long walkId;				// 산책ID
    private String dogWalkerId;			// 도그워커ID
    private String dogWalkerName;		// 도그워커명
    private String userId;				// 회원ID
    private String userName;			// 회원명
    private String walkStartDate; 		// 산책 시작 일시분(실제)
	private String walkEndDate;			// 산책 종료 일시분(실제)
    
    public StarScoreGranted(){
        super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDailyRecordDate() {
		return dailyRecordDate;
	}

	public void setDailyRecordDate(String dailyRecordDate) {
		this.dailyRecordDate = dailyRecordDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getWalkId() {
		return walkId;
	}

	public void setWalkId(Long walkId) {
		this.walkId = walkId;
	}

	public int getStarScore() {
		return starScore;
	}

	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDogWalkerId() {
		return dogWalkerId;
	}

	public void setDogWalkerId(String dogWalkerId) {
		this.dogWalkerId = dogWalkerId;
	}

	public String getWalkStartDate() {
		return walkStartDate;
	}

	public void setWalkStartDate(String walkStartDate) {
		this.walkStartDate = walkStartDate;
	}

	public String getWalkEndDate() {
		return walkEndDate;
	}

	public void setWalkEndDate(String walkEndDate) {
		this.walkEndDate = walkEndDate;
	}

	public String getDogWalkerName() {
		return dogWalkerName;
	}

	public void setDogWalkerName(String dogWalkerName) {
		this.dogWalkerName = dogWalkerName;
	}
	
	
	
}