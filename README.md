# 🧚‍♂️ 위잉위잉
> 32기 GO SOPT 솝커톤 모기🦟 퇴치 서비스 위잉위잉 

<img src="https://github.com/SOPT32-SOPKATHON/sopkathon-server/assets/67463603/29be8b9d-3162-4eee-9621-3ed830ea4dee" width="700"/>
<img src="https://github.com/SOPT32-SOPKATHON/sopkathon-server/assets/67463603/dc28ad07-a6fc-4ffc-9ecb-74415611aec2" width="700"/>

---

## 🌸 Contributors 섭팟이들
|                             이동섭                             |                               안채린                        |
| :----------------------------------------------------------: | :----------------------------------------------------------: |
| <img src="https://github.com/SOPT32-SOPKATHON/sopkathon-server/assets/67463603/c064ed3b-4b7f-48e4-9e67-c6cf4c8564b6" width="300"/> | <img src="https://github.com/SOPT32-SOPKATHON/sopkathon-server/assets/72637095/98e83aa6-492c-4e78-9f55-c0fa02555253" width="300"/>  |
|              [ddongseop](https://github.com/ddongseop)               |             [chaerin00](https://github.com/chaerin00)              |

<img src="https://github.com/SOPT32-SOPKATHON/sopkathon-server/assets/67463603/086ab97f-d66f-4705-b20d-ca6c861f3949" width="300"/>

<hr>

## ⭐️ Role

| 담당 역할                          | Role |
|:-------------------------------|:----:|
| 프로젝트 초기 세팅 후 푸시                | 이동섭  |
| RDS 세팅                              | 이동섭  |
| 공공 API                             | 안채린  |
| ERD 작성                             | 이동섭, 안채린  |
| DB 구축                            | 안채린  |
| EC2 배포                            | 이동섭  |

<hr>

## 👻 API Docs

### 🔗 [API Docs](https://www.notion.so/go-sopt/6-API-81c96c78c2624fc88f1d7ec691de18b5?pvs=4)

## ⭐️ API 담당

| 이름                      | 담당 역할                           | Role |
|:------------------------|:-------------------------------|:----:|
| 모기지수 불러오기              | [GET] /score                    | 안채린  |
| 모기 예방법 랜덤하게 하나 불러오기 | [GET] /prevention               | 안채린  |
| 모기 퇴치법 랜덤하게 하나 불러오기 | [GET] /kill/random              | 이동섭  |
| 모기 퇴치법 좋아요/싫어요        | [PATCH] /kill/vote              | 안채린  |
| 모기 퇴치법 랭킹 불러오기        | [GET] /kill                     | 이동섭  |

<hr>

## 👉️ ERD
<img width="500" src="https://github.com/SOPT32-SOPKATHON/sopkathon-server/assets/67463603/bc7001a2-6ad3-49a6-a685-e5a01e4181ee">

<hr>

## 👉 Project Structure

```
🗂 sopkathon
    🗂 common (공통 처리 관련 클래스)
        🗂 advice
        🗂 dto
    🗂 controller (클라이언트의 요청을 받는 컨트롤러 계층)
        🗂 kill
        🗂 prevention
        🗂 score
            🗂 dto
                🗂 request
                🗂 response
    🗂 domain (도메인)
    🗂 exception (예외처리)
        🗂 model
    🗂 infrastructure (데이터베이스 등 외부 요소와 연결을 수행하는 계층)
    🗂 service (비즈니스로직이 있는 서비스 계층)
```

# 🌱 Branch

<aside>

`main branch` : 주요 개발 branch
`feature branch`: 각자 개발 branch

-   작업단위별로 breanch를 생성
    -   feat, refactor 등의 branch 네이밍 사용
    -   띄어쓰기는 언더바(_)가 아닌 대쉬(-)
    -   api의 구현의 경우 아래의 예시처럼 작성 (method 포함)
    -   ex) feat/get-score-api
  

-   해당 branch 작업 완료 후 PR 보내기
    -   항상 local에서 충돌 해결 후 → remote에 올리기
    -   reviewer에 서로 tag후 code-review
    -   comment 전 merge 불가!
    -   ⭐️ squash and merge 방식 사용
    -   merge 후 main branch에서 작동 확인
    -   작동 확인된 기능의 branch는 삭제


</aside>
<hr>

# 🙏 Commit Convention

`ex) feat: 모기지수 불러오기 API 구현`

```
- feat : 새로운 기능 구현
- fix : 버그, 오류 해결
- style : 코드가 아닌 스타일 변경을 하는 경우
- refactor : 프로덕션 코드 리팩토링
- docs : README나 WIKI 등의 문서 개정
- chore : 코드 수정, 내부 파일 수정
- rename : 파일 이름의 변경
- add : Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성 시
- del : 쓸모없는 코드 삭제
- move : 프로젝트 내 파일이나 코드의 이동
- merge: 다른브렌치를 merge하는 경우
- init : Initial commit을 하는 경우
```

# 🙏 Code Convention

> 💡 **동료들과 말투를 통일하기 위해 컨벤션을 지정합니다.**
> 오합지졸의 코드가 아닌, **한 사람이 짠 것같은 코드**를 작성하는 것이 추후 유지보수나 협업에서 도움이 됩니다. 내가 코드를 생각하면서 짤 수 있도록 해주는 룰이라고 생각해도 좋습니다!

<details>
<summary>명명규칙(Naming Conventions)</summary>
<div markdown="1">

1. 이름으로부터 의도가 읽혀질 수 있게 쓴다.

-   ex)

    ```jsx
    // bad
    function q() {
        // ...stuff...
    }

    // good
    function query() {
        // ..stuff..
    }
    ```

2. 오브젝트, 함수, 그리고 인스턴스에는 `camelCase`를 사용한다.

-   ex)
    ```jsx
    // bad
    const OBJEcttsssss = {};
    const this_is_my_object = {};
    function c() {}

    // good
    const thisIsMyObject = {};
    function thisIsMyFunction() {}
    ```

3. 클래스나 constructor에는 `PascalCase`를 사용한다.

-   ex)
    ```jsx
    // bad
    function user(options) {
        this.name = options.name;
    }

    const bad = new user({
        name: 'nope',
    });

    // good
    class User {
        constructor(options) {
            this.name = options.name;
        }
    }

    const good = new User({
        name: 'yup',
    });
    ```

4. 함수 이름은 동사 + 명사 형태로 작성한다.
   ex) `postUserInformation( )`
5. 약어 사용은 최대한 지양한다.
6. 이름에 네 단어 이상이 들어가면 팀원과 상의를 거친 후 사용한다
 </div>
 </details>

<details>
<summary>블록(Blocks)</summary>
<div markdown="1">

1. 복수행의 블록에는 중괄호({})를 사용한다.

-   ex)
    ```jsx
    // bad
    if (test)
      return false;

    // good
    if (test) return false;

    // good
    if (test) {
      return false;
    }

    // bad
    function() { return false; }

    // good
    function() {
      return false;
    }

    ```

2. 복수행 블록의 `if` 와 `else` 를 이용하는 경우 `else` 는 `if` 블록 끝의 중괄호( } )와 같은 행에 위치시킨다.

-   ex)
    ```java
    // bad
    if (test) {
    thing1();
    thing2();
    }
    else {
    thing3();
    }

    // good
    if (test) {
      thing1();
      thing2();
    } else {
      thing3();
    }

    ```
</div>
</details>

<details>
<summary>코멘트(Comments)</summary>
<div markdown="1">

1. 복수형의 코멘트는 `/** ... */` 를 사용한다.

-   ex)
    ```jsx
    // good
    /**
     * @param {String} tag
     * @return {Element} element
     */
    
    function make(tag) {
        // ...stuff...

        return element;
    }
    ```

2. 단일 행의 코멘트에는 `//` 을 사용하고 코멘트를 추가하고 싶은 코드의 상부에 배치한다. 그리고 코멘트의 앞에 빈 행을 넣는다.

-   ex)
    ```jsx
    // bad
    const active = true; // is current tab

    // good
    // is current tab
    const active = true;

    // good
    function getType() {
        console.log('fetching type...');

        // set the default type to 'no type'
        const type = this._type || 'no type';

        return type;
    }

    ```
</div>
</details>
