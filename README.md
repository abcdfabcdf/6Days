> # 6Days

## 소개
유사 사이트인 'Facebook'과 'Instagram'을 모방해서 개발한 기본적인 기능을 갖춘 SNS 플랫폼입니다.

## 내용
* 프로젝트명 : 6Days
* 개발기간 : 2020.01.01 ~ 2020.02.24
* 프로젝트 참여 인원 : 5명
* 담당 역할 : 공지사항, QnA 게시판(페이징 처리, 검색 기능 구현), 각 게시물 댓글 작성
             
## 개발 환경
* 운영체제 : Windows
* 서버 : Tomcat
* 언어 : Java, HTML5, CSS3, JavaScript, ajax, JSP
* 데이터베이스 : ORACLE

## DB 설계
![ERD](https://user-images.githubusercontent.com/50040251/86762352-8dc47c80-c081-11ea-8b37-ae04dda0e08a.PNG)

## 구현 기능 소개

### 게시판(공지사항 & QnA)

> ### List 불러오기
![1](https://user-images.githubusercontent.com/50040251/87034137-54774280-c222-11ea-8aa2-1c446f0876db.png)
![1-1](https://user-images.githubusercontent.com/50040251/87034210-6fe24d80-c222-11ea-8876-c5633490983d.png)
- 공지사항은 관리자만 작성할 수 있도록 조건을 걸어놓았습니다.
- QnA는 모든 사용자가 작성할 수 있도록 구현하였습니다.
- RowNum을 이용하여 오름차순으로 정렬을 하였고, 페이징처리와 검색기능을 구현하였습니다.

> ### Detail View
![2-2](https://user-images.githubusercontent.com/50040251/87034271-8ab4c200-c222-11ea-924d-da5ef181b7f0.png)
![2](https://user-images.githubusercontent.com/50040251/87034264-87213b00-c222-11ea-95d6-47277a2a1c7d.png)
- List에서 해당 글을 선택하면 글의 자세한 내용을 확인할 수 있습니다.
- QnA 게시글에는 댓글을 작성할 수 있으며, 본인이 쓴 댓글에 한해서 수정이 가능합니다.
- 댓글은 프로필사진, 아이디, 내용, 댓글작성일자가 나타나도록 구현하였습니다.

> ### Insert
![9](https://user-images.githubusercontent.com/50040251/87036009-20515100-c225-11ea-8dec-d42ed345a7dd.png)
- 게시판 작성의 기본적인 틀이 되는 것을 구현하였으며, 첨부파일도 함께 올릴 수 있도록 구현하였습니다.
- 텍스트 에디터 API를 사용하여 글 작성시 여러 기능을 사용할 수 있도록 구현하였습니다.
- QnA 게시글은 공개/비공개로 설정할 수 있습니다. 비공개 된 글은 본인과 관리자만 확인할 수 있습니다.

> ### Update
![3](https://user-images.githubusercontent.com/50040251/87034312-9c966500-c222-11ea-8d34-7e31c0930097.png)
![4](https://user-images.githubusercontent.com/50040251/87034395-bc2d8d80-c222-11ea-8799-a5657d5a2fa8.png)
- 해당 글의 내용을 그대로 불러와 수정할 수 있도록 구현하였습니다.
- 수정 버튼을 눌렀을 때, 수정한 내용이 바로 적용이 됩니다.

> ### Delete
![5](https://user-images.githubusercontent.com/50040251/87034435-c94a7c80-c222-11ea-9349-07bfdef6d971.png)
![6](https://user-images.githubusercontent.com/50040251/87034476-d7989880-c222-11ea-8d60-6388e8cbc006.png)
- 수정창에서 삭제버튼을 누르면 게시글에서 삭제됩니다.

> ### 게시물 댓글
![7](https://user-images.githubusercontent.com/50040251/87034514-e54e1e00-c222-11ea-8ea0-9128040ca344.png)
- 해당 게시물의 번호를 찾아 그 해당 게시물의 댓글을 불러오고, 댓글을 작성할 수 있도록 구현하였습니다.
