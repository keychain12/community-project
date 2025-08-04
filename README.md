<h2>기술스택</h2>

BACK-END
<div>
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/AWS EC2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white">
<img src="https://img.shields.io/badge/AWS S3-569A31?style=for-the-badge&logo=amazons3&logoColor=white">
<img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
</div>
FRONT-END
<div>
<img src="https://img.shields.io/badge/HTML-E34F26?style=for-the-badge&logo=html&logoColor=white">
<img src="https://img.shields.io/badge/CSS-1572B6?style=for-the-badge&logo=css&logoColor=white"> 
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
<img src="https://img.shields.io/badge/Json-000000?style=for-the-badge&logo=json&logoColor=white">
<img src="https://img.shields.io/badge/Boot Strap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">

</div>



working title

---

**Back-End Developer**

개발 2024.05~2024.06 

**🔗  Links**

깃허브

https://github.com/keychain12/community-project

---

## 📜 서비스 내용

 커뮤니티 게시판 입니다.

1. 커뮤니티 게시판입니다 사용자들이 글쓰기, 읽기 , 댓글 시스템, 아이콘구매와 같이 즐길 수 있는 서비스를 제공하고자 했습니다.

## 🛠 기술 스택

- Java , Spring-boot , Mybatis , Oracle , AWS-EC2 , S3 , Docker
- JSP

## 주요 기능

**요약**

| 공통 | 사용자 | 관리자 |
| --- | --- | --- |
| - 회원가입, 로그인- 게시판 목록 게시물 글 읽기 - 게시물 검색 | - 포인트구매 -아이콘구매- 게시물 쓰기 , 수정 , 삭제  - 구매내역 | - 공통기능+ 사용자기능 + 게시물관리 및 회원관리 |

## 🖥 개발 내용

## 1. 프로젝트 구조

<img width="832" height="580" alt="Untitled (1)" src="https://github.com/user-attachments/assets/52669cd7-1515-4cff-90c4-50df86d049e7" />


Controller , domain (DTO) , mapper , repository , service 단으로 나누어 개발을 진행하였습니다.

## 2. 데이터베이스 ERD

<img width="904" height="289" alt="Untitled (2)" src="https://github.com/user-attachments/assets/54156a40-af03-4241-a8f4-b98e34414a5e" />

### 테이블은 크게  게시물을 저장할 Board 테이블과 회원을 저장할 User 테이블이 있습니다.

### 1.보드 테이블

<img width="837" height="309" alt="Untitled (3)" src="https://github.com/user-attachments/assets/84813ed1-9cdc-4209-9fc7-abcd23a49ffb" />

보드테이블은  Likes , Dislikes , FileAttachment ,Comments , PopularPost 와 연결되어있습니다. 

추천 ,반대 중복여부를 체크하기 위해 따로 테이블을 만들었습니다.

### 2.유저 테이블

<img width="837" height="309" alt="Untitled (3)" src="https://github.com/user-attachments/assets/66562309-1792-4a8f-9fbd-b6f46824b833" />

유저 테이블은  board 테이블과 , 구매내역을 확인할 수 있는 PaymentHistory 와 연결되어있습니다.

# 기능 몇가지..

## 1. 인기포스트

자유,익명,공부,연애 게시판의 글들중 추천수가 10개가 넘은 글들은 인기포스트로 넘어갑니다.

<img width="870" height="631" alt="Untitled (4)" src="https://github.com/user-attachments/assets/5155594b-21a4-4556-a541-ddf2cbb58d6b" />

기본적으로 페이징 작업도 해주었고 ,  인기글 과 해당글의 첨부파일도 가져왔습니다.

Service 단 코드입니다.  추천수 10개가 넘은 글이 인기포스트 디비에 있는지 확인하고 없을시 저장합니다.

<img width="669" height="630" alt="Untitled (5)" src="https://github.com/user-attachments/assets/07ad874d-f587-44d0-bdfa-8c4323e19056" />

- 해당 쿼리보기
    
    board 테이블과 user테이블을 inner join 과 서브쿼리를통해 인기포스트의 게시물 정보와 해당 게시물의 유저 정보를 가져왔습니다.
  
    


### 인기포스트 서비스 화면

<img width="1419" height="569" alt="Untitled (6)" src="https://github.com/user-attachments/assets/8b39c9d9-4663-4052-9db7-ad12d907fa1c" />

## 2. 게시판 읽기 , ajax 비동기 처리.

<img width="1184" height="768" alt="Untitled (7)" src="https://github.com/user-attachments/assets/d7cd702d-808e-44a8-a800-cb5955f33650" />

<img width="1175" height="645" alt="Untitled (8)" src="https://github.com/user-attachments/assets/41712d96-7611-4f85-b144-bd1ec93b274d" />


좋아요, 싫어요는 Ajax 를 통해 비동기 방식으로 처리하였습니다.    
   

## 3. 이미지 업로드

이미지 업로드 하는데 애먹었습니다.  기존 프로젝트에 했었던 방식 말고 다른방식을 제 프로젝트에서 사용해보려다 많은 시간을 소모했습니다.  그러나 배포 후 글쓰기를 하면 이미지가 엑박이뜨는 오류가 생겼습니다.(아마 경로문제) 그래서 수정하는김에 그동안 너무 사용해보고싶었던 AWS - S3를 사용해보자 해서 S3를 도입해 해결했습니다.

링크 > [AWS S3 사용하기](https://www.notion.so/AWS-S3-0255cf16ca3942f8a18396bfd4447599?pvs=21) 

S3(images 폴더)에 잘 저장이 됩니다. 

<img width="1026" height="544" alt="Untitled (9)" src="https://github.com/user-attachments/assets/7d5cba0b-c705-4bf9-9054-5a7d4daf1d10" />


<img width="1139" height="562" alt="Untitled (10)" src="https://github.com/user-attachments/assets/ce7f3387-4c7f-4452-b3f3-4a946c58463c" />



이미지도 잘불러와집니다.

## 4. 아이콘 구매

유저는 포인트를 구매해 포인트로 아이콘을 구매할수있습니다.

<img width="1123" height="503" alt="Untitled (11)" src="https://github.com/user-attachments/assets/7d58d159-b518-4f65-8cc7-40954d8b7776" />

구매함과 동시에  아이콘이 바뀝니다.

<img width="190" height="89" alt="Untitled (12)" src="https://github.com/user-attachments/assets/02e29c7a-5ce3-46fd-88d3-82be66077137" />

구매 내역에서 구매한 아이콘을 확인할 수 있습니다.

<img width="751" height="221" alt="Untitled (13)" src="https://github.com/user-attachments/assets/37aa2e9b-be27-45c5-9211-e9da3e2b57df" />

## 5. 로그인 인증 , 인가

글쓰기 , 댓글 , 회원정보 , 아이콘 구매 페이지등 로그인 체크 인터셉터, WebConfig를 통해 로그인 한 회원 만 이용 가능하게 막았습니다.

<img width="1002" height="605" alt="Untitled (14)" src="https://github.com/user-attachments/assets/54a97b89-22af-44b5-8a2b-d67c1ea1831e" />

order 는 순서 

addPathPatterns 에 넣은 url은 로그인시에만 허가를 받습니다.

<img width="1097" height="408" alt="Untitled (15)" src="https://github.com/user-attachments/assets/01414b3e-52f2-4bce-a4b5-5218cddc70b0" />

# 프로젝트 완성후 배포

프로젝트 배포는  docker 와 AWS - EC2 로 진행했습니다. 

링크 >  [docker로 프로젝트 배포하기](https://www.notion.so/docker-feddc335924445bc9a8b5a2d9e9dfc8f?pvs=21) 

배포 흐름  

1. 도커 파일 작성

<img width="520" height="292" alt="Untitled (16)" src="https://github.com/user-attachments/assets/6980ca4c-a240-49db-a1d7-9e40f8976a0d" />

1. gradle 에서 build 로 스냅샷 만들기

<img width="239" height="202" alt="Untitled (17)" src="https://github.com/user-attachments/assets/10cd5e11-9c78-40f4-b78a-5e963c3f40fe" />

1. 프로젝트 이미지 빌드 , 실행 , 도커허브에 푸쉬하기

<img width="893" height="175" alt="Untitled (18)" src="https://github.com/user-attachments/assets/db08ca5f-3bdc-48f8-b68f-966dd8d12a31" />

1. ec2 접속 후 풀로 땡겨온후 컨테이너 실행 

<img width="1126" height="102" alt="Untitled (19)" src="https://github.com/user-attachments/assets/f13e6aa5-bc1e-4eda-9b03-3ece37657104" />

# 마무리

느낀점으론 블라인드나 , 에브리타임 같은 커뮤니티 사이트를 만들어보고 싶었습니다. 개발을 전체적으로 경험해보고싶어 이번엔 혼자서 진행을 하였고  혼자 개발하느라 시간이 좀 걸렸습니다 그리고 많은 기능들을 넣고싶었지만 너무 오래걸려서 최소한으로 개발했습니다. 제가하고싶었던 주제여서 그런지 많이 몰입하며 재밌게 프로젝트에 임했습니다.

좋았던점 : ajax 실력 향상 , sql 서브쿼리,조인 실력 향상 , s3 사용법 , docker를 통한 배포 , boot로 개발

많이 아쉬운점 : 이전과 똑같은 jsp , mybatis 프로젝트 , API 사용하지못한점 , 람다식과 stream 활용 부족. 

다음에는 restAPi 방식으로 개발하고싶고 mybatis 말고 jpa도 사용해 보고 싶습니다. 

코드짤때도 람다식과 스트림 사용에대한 연습이 좀 필요할거같습니다.

프로젝트 
<img width="1440" height="900" alt="스크린샷 2024-06-11 오전 11 17 21" src="https://github.com/user-attachments/assets/aa0928df-bb35-4640-9062-457dfaea5655" />


