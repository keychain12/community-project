프로젝트 설명을 위한 노션링크

https://www.notion.so/working-title-2d91158462e6445ca7bd51f3d7d4ecee 

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

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/a6ad3b14-01b5-4650-8773-4cbda0c9d25a/Untitled.png)

Controller , domain (DTO) , mapper , repository , service 단으로 나누어 개발을 진행하였습니다.

## 2. 데이터베이스 ERD

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/68812d5b-5c81-49d8-8368-61f9a37b4c14/Untitled.png)

### 테이블은 크게  게시물을 저장할 Board 테이블과 회원을 저장할 User 테이블이 있습니다.

### 1.보드 테이블

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/c0326c2e-9d12-444f-ad7d-46b06cd5a1fa/Untitled.png)

보드테이블은  Likes , Dislikes , FileAttachment ,Comments , PopularPost 와 연결되어있습니다. 

추천 ,반대 중복여부를 체크하기 위해 따로 테이블을 만들었습니다.

### 2.유저 테이블

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/271d97a9-b327-4ade-a3ad-ac35894dfd38/Untitled.png)

유저 테이블은  board 테이블과 , 구매내역을 확인할 수 있는 PaymentHistory 와 연결되어있습니다.

# 기능 몇가지..

## 1. 인기포스트

자유,익명,공부,연애 게시판의 글들중 추천수가 10개가 넘은 글들은 인기포스트로 넘어갑니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/3c1b9da5-6d93-4ef8-b514-7d82badac0f3/Untitled.png)

기본적으로 페이징 작업도 해주었고 ,  인기글 과 해당글의 첨부파일도 가져왔습니다.

Service 단 코드입니다.  추천수 10개가 넘은 글이 인기포스트 디비에 있는지 확인하고 없을시 저장합니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/3647dfbb-fddb-4f64-907c-5ddda4999aca/Untitled.png)

- 해당 쿼리보기
    
    board 테이블과 user테이블을 inner join 과 서브쿼리를통해 인기포스트의 게시물 정보와 해당 게시물의 유저 정보를 가져왔습니다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/980881e4-06dc-47e3-9eb2-2c55d585c85a/Untitled.png)
    

### 인기포스트 서비스 화면

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/080d56bf-2398-4385-b8e2-57918527fe6f/Untitled.png)

## 2. 게시판 읽기 , ajax 비동기 처리.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/56085129-b29a-42cc-9515-d45b20ee77cd/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/60fad243-5cb4-4fc9-9c54-2d8e4448849b/Untitled.png)

좋아요, 싫어요는 Ajax 를 통해 비동기 방식으로 처리하였습니다.

- 해당 코드
    
    세션을 통해 로그인 한상태인지 확인하고 , 좋아요,싫어요를 이미 누른 상태인지 확인합니다.
    
    좋아요를 누르면 좋아요수 증가시킵니다.
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/a3ab0af0-82b9-4e33-98ff-1cbf04b32390/Untitled.png)
    
    ![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/b63fc8b1-02af-48ea-a4af-b158dea00017/Untitled.png)
    

## 3. 이미지 업로드

이미지 업로드 하는데 애먹었습니다.  기존 프로젝트에 했었던 방식 말고 다른방식을 제 프로젝트에서 사용해보려다 많은 시간을 소모했습니다.  그러나 배포 후 글쓰기를 하면 이미지가 엑박이뜨는 오류가 생겼습니다.(아마 경로문제) 그래서 수정하는김에 그동안 너무 사용해보고싶었던 AWS - S3를 사용해보자 해서 S3를 도입해 해결했습니다.

링크 > [AWS S3 사용하기](https://www.notion.so/AWS-S3-0255cf16ca3942f8a18396bfd4447599?pvs=21) 

S3(images 폴더)에 잘 저장이 됩니다. 

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/b96409bd-de37-4b2c-92e8-eb72ebaa9a87/Untitled.png)

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/5c468a80-10aa-4f45-bde9-b404306f31b6/Untitled.png)

이미지도 잘불러와집니다.

## 4. 아이콘 구매

유저는 포인트를 구매해 포인트로 아이콘을 구매할수있습니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/0353ef7a-9769-4713-baf6-270784b8f29d/Untitled.png)

구매함과 동시에  아이콘이 바뀝니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/f5ba528a-84e3-4704-a311-834a69352fc8/Untitled.png)

구매 내역에서 구매한 아이콘을 확인할 수 있습니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/42f4e6b4-9b29-4a46-95b2-10bcce1d3db9/Untitled.png)

## 5. 로그인 인증 , 인가

글쓰기 , 댓글 , 회원정보 , 아이콘 구매 페이지등 로그인 체크 인터셉터, WebConfig를 통해 로그인 한 회원 만 이용 가능하게 막았습니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/c82d62da-1824-4a06-8b9a-772fb54befe1/Untitled.png)

order 는 순서 

addPathPatterns 에 넣은 url은 로그인시에만 허가를 받습니다.

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/fbc4e461-47e6-41a1-b4aa-d6df8d22c05c/Untitled.png)

# 프로젝트 완성후 배포

프로젝트 배포는  docker 와 AWS - EC2 로 진행했습니다. 

링크 >  [docker로 프로젝트 배포하기](https://www.notion.so/docker-feddc335924445bc9a8b5a2d9e9dfc8f?pvs=21) 

배포 흐름  

1. 도커 파일 작성

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/ce00bfa9-c4b4-4d24-9962-459491772bc6/Untitled.png)

1. gradle 에서 build 로 스냅샷 만들기

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/53ab86ff-f471-496f-af6c-64e9fd5afd4c/Untitled.png)

1. 프로젝트 이미지 빌드 , 실행 , 도커허브에 푸쉬하기

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/9e953f01-c68e-4e18-bace-7f2f3d3599c5/Untitled.png)

1. ec2 접속 후 풀로 땡겨온후 컨테이너 실행 

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/07be84d2-1846-407e-803b-73d269df1d65/Untitled.png)

# 마무리

느낀점으론 블라인드나 , 에브리타임 같은 커뮤니티 사이트를 만들어보고 싶었습니다. 개발을 전체적으로 경험해보고싶어 이번엔 혼자서 진행을 하였고  혼자 개발하느라 시간이 좀 걸렸습니다 그리고 많은 기능들을 넣고싶었지만 너무 오래걸려서 최소한으로 개발했습니다. 제가하고싶었던 주제여서 그런지 많이 몰입하며 재밌게 프로젝트에 임했습니다.

좋았던점 : ajax 실력 향상 , sql 서브쿼리,조인 실력 향상 , s3 사용법 , docker를 통한 배포 , boot로 개발

많이 아쉬운점 : 이전과 똑같은 jsp , mybatis 프로젝트 , API 사용하지못한점 , 람다식과 stream 활용 부족. 

다음에는 restAPi 방식으로 개발하고싶고 mybatis 말고 jpa도 사용해 보고 싶습니다. 

코드짤때도 람다식과 스트림 사용에대한 연습이 좀 필요할거같습니다.

프로젝트 

![스크린샷 2024-06-11 오전 11.17.21.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/ebf8507a-8b03-45af-a5c4-735a5362bc5a/5bba6a0b-70e6-4e98-8e44-4d74e3e617e7/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-06-11_%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB_11.17.21.png)
          
