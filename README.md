# <img src="./img/지구방위대.png" alt="image" width="50" height="50" />  지구를 지켜라! 지구방위대 🔫

<img width="1628" alt="playStore" src="https://github.com/EarthDefenseCorps/earth-defense-corps-backend/assets/37647483/dd137a4e-bcf0-4e15-8e07-21e364cd3c5f">


### 🌕 우주인들을 막는 종스크롤 액션 게임 🌎 

Play Store : https://play.google.com/store/apps/details?id=com.devurim.earthdefensecorps&hl=ko-KR

-----------------

## TEAM 지구방위대 개발팀 👨‍👨‍👧‍👦
| <img src="https://avatars.githubusercontent.com/u/77566434?v=4" width=1250px alt="강동현"/> | ![image](https://user-images.githubusercontent.com/105579811/226158691-dca8e766-38c8-4c26-b336-a01f4321e3a2.jpg) | ![image](https://user-images.githubusercontent.com/105579811/226158703-7557808d-2274-441b-b3d9-80a56c3bf6cc.jpeg) |
|---------------------------------------------|------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| 강동현([@hyeon23](https://github.com/hyeon23)) | 윤병욱([@speculatingwook](https://github.com/speculatingwook))                                                      | 조성현([@chosunghyun18](https://github.com/chosunghyun18))                                                           |
| Leader / Design & Game Client                               | Backend                                                                                                          | Back End                                                                                                          |


## 프로젝트(게임) 개요

**1. 우주인(=우주 해적)들이 연구를 위해 지구의 여러 물체를 흡수해가고, 연구가 끝나면 쓸모가 없어져 다시 지구에 버리는 상황입니다.**

**2. 우주인을 막기 위해 지구 방위대 조직이 구성되었고, 지구 수호대원들은 우주인들이 지구로 버리는 우주 쓰레기들을 처리합니다.**

**3. 우주인들을 추적해 우주인들과 싸우고, 해치웁니다.**

**4. 우주해적선(BOSS)을 격파해, 우주 해적들을 물리치고, 각 행성을 점령해나가는 스토리입니다.**


### 프로젝트(백엔드) 목표

게임 클라이언트에서 원할때 필요한 정보를 가져올 수 있다.

## 백엔드 도메인별 요구사항 정리


### 게임 유저

- Member
- [x] gpgsId를 확인하여 유저가 기존 유저인지 확인
- [x] 기존 유저인지 아닌지 확인하는 로직 필요


- 만약 기존 유저가 아닌 경우(멤버 로직에 해당? 일단 아이템 로직 먼저 만들어야 할 듯)
- [x] 캐릭터를 기본값으로 생성합니다.
- [x] 유저의 인벤토리를 생성하고, 인벤토리의 보유 아이템 리스트와 착용중인 아이템의 기본값을 설정합니다.
- [x] 인벤토리를 빈 값으로 생성하고, 유저의 총 스탯 객체를 생성하고, 계산한 값을 데이터베이스에 저장합니다.
- [x] 그리고 유저 보유 골드와 보유 젬을 0으로 설정합니다.
- [x] 위의 내용을 반영한 새로운 멤버 객체를 생성합니다.


- 기존 유저의 경우
- [x] 인벤토리와 착용중인 아이템 정보를 가져옵니다.


### 인벤토리
- [x] 유저의 아이템 정보를 가져옵니다.
- [x] 착용중인 아이템 정보를 가져옵니다.


### 아이템
- [x] 상점에서 뽑은 아이템을 등록합니다.
- [x] 강화한 아이템을 반영합니다.
- [x] 판매한 아이템을 삭제합니다.

### 캐릭터(확장성을 고려한 설계)
- [x] 캐릭터의 정보를 등록합니다.(게임 반영 x, 컨텐츠용)
- 
### Back-end

| Category  | Stack               |
|-----------|---------------------|
| Framework | - Spring Boot 2.6.3 |
| Test      | - JUnit 5           |
| Infra     | - AWS EC2           |
| Database  | - MySql             |

### Communication

| Category          | Stack     |
|-------------------|-----------|
| Communication     | KakaoTalk |
| Documents         | Notion    |

### ERD Table
![image](https://github.com/Team-Greendar/GreendarServer/assets/105579811/a79b167b-dd93-4780-8c38-5965b1897774)
