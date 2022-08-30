---------------------------------------------------
1. 사용 테이블
---------------------------------------------------
테이블스페이스 : petfriends

테이블생성 Script: 

CREATE TABLE `daily` (
	`daily_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`contents` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`daily_record_date` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`dog_walker_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`review` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`star_score` INT(11) NOT NULL,
	`user_id` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`user_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`walk_id` BIGINT(20) NULL DEFAULT NULL,
	`walking_place` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`daily_id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB;

INSERT INTO daily (contents, daily_record_date, dog_walker_id, review, star_score, user_id, user_name, walk_id, walking_place) 
VALUES ('일지를 작성합니다.', '2022-08-28 20:00', 'hisover', '후기를 작성합니다.', 5, 'ShinSeokHyeon', '신석현', 1, 'SEOUL');

---------------------------------------------------  
2. kafka설치    
---------------------------------------------------  
참고사이트 : http://www.msaschool.io/operation/implementation/implementation-seven/  

--------------------------------------------------  
3. API
--------------------------------------------------  
1) daily 에서 아래와 같이 api 통해 데이터 생성하면, mariadb[daily테이블]에 데이터 저장되고, message publish.
    - 일지 작성 (생성) : POST http://localhost:8080/dailys
                    { "contents" : "일지를 작성합니다.",
					  "walkingPlace" : "SEOUL",
					  "walkId" : 1, 
					  "userId" : "ShinSeokHyeon",
					  "userName" : "신석현",
					  "dogWalkerId" : "hisover"} 

    - 별점 부여 및 후기 작성 (업데이트) : PUT http://localhost:8080/dailys/starscore
    						  	{ "id" : 1,
								  "starScore" : 5,
								  "review" : "후기를 작성하였습니다.",
								  "walkId" : 1,
								  "dogWalkerId" : "hisover",
								  "userId" : "ShinSeokHyeon", 
								  "userName" : "신석현"}
  	- 일지 목록 조회 (사용자 기준) : GET http://localhost:8080/dailys/user/{userId}
  	- 일지 조회 (단건) : http://localhost:8080/dailys/{id}

--------------------------------------------------  
4. 구조   
   -controller  
   -service  
   -repository  
   -dto  
   -model
   -view : Request 파라미터  
   -config : KafkaProcessor.java, WebConfig.java(CORS적용)  
--------------------------------------------------  
5. swagger추가 : http://localhost:8080/swagger-ui.html  
--------------------------------------------------  
