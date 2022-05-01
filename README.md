# VOC

## Spec
```
spring boot 2.6.7
JAVA 11
spring data JPA
H2 Database
```

##ERD
![image](https://user-images.githubusercontent.com/74886848/166135133-39622a30-3d0e-4b28-92d6-be75f90843db.png)

## REST-Api
```
BaseUri : http://localhost:8080

#VOC

1. VOC 등록
Method : POST 
EndPoint : /voc
 - 운송사, 고객사 Index와 귀책,클레임여부,사유 정보로 VOC 1건을 등록합니다.
  
  
2. VOC 조회
Method : GET 
EndPoint : /voc
 - 등록된 모든 VOC리스트를 조회합니다.

#배상(Compensation)

1. 배상 등록
Method : POST 
EndPoint : /compensation
 - VOC Index와 청구금액 정보로 배상을 등록합니다.

2. 배상 조회
Method : GET  
EndPoint : /compensation
 - 등록된 모든 배상리스트를 조회합니다.

#패널티
1. 패널티 등록
Method : POST 
EndPoint : /penalty
 - VOC Index와 패널티 금액 정보로 패널티를 등록합니다.
 
2. 패널티 읽음 
Method : PATCH 
EndPoint : /read/{penaltyIndex}
 - Push 알림을 읽을 시 읽음 상태를 변경합니다. 
3. 패널티 인정 
Method : PATCH 
EndPoint : /objection/{penaltyIndex}
 - 이의제기를 하지 않고 패널티를 인정시 상태를 변경합니다.
 - VOC 상태도 같이 변경됩니다.
 
4. 패널티 이의제기 
Method : POST
EndPoint : /objection/{penaltyIndex}
 - 이의제기시 이유와 함께 해당 레코드를 업데이트합니다.
 - VOC 상태도 같이 변경됩니다.
```

##Dependencies
```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

