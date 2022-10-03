<template>
  <div id="footer">
    <div id="footer_container">
      <section id="footer_first_sec">
        <section id="app_download">
          <div>당근마켓 앱 다운로드</div>
          <div>
            <a href="https://apps.apple.com/kr/app/%EB%8B%B9%EA%B7%BC%EB%A7%88%EC%BC%93-%EC%A4%91%EA%B3%A0%EA%B1%B0%EB%9E%98-%ED%95%84%EC%88%98%EC%95%B1/id1018769995" class="app_icon">
              <div><img src="https://www.freepnglogos.com/uploads/apple-logo-png/apple-logo-png-dallas-shootings-don-add-are-speech-zones-used-4.png">App Store</div>
              <span>iOS<img src="https://cdn-icons-png.flaticon.com/512/130/130893.png"></span>
            </a>
            <a href="https://play.google.com/store/apps/details?id=com.towneers.www&hl=ko" class="app_icon">
              <div><img src="https://www.freelogovectors.net/wp-content/uploads/2022/07/google-play-2022-logo-freelogovectors.net_.png">Google Play</div>
              <span>Android<img src="https://cdn-icons-png.flaticon.com/512/130/130893.png"></span>
            </a>
          </div>
        </section>
        <section id="nav_menu">
          <ul class="footer_category">
            <li><a href="javascript::void(0)">중고거래</a></li>
            <li><a href="javascript::void(0)">동네가게</a></li>
            <li><a href="javascript::void(0)">당근알바</a></li>
          </ul>
          <ul class="footer_category">
            <li><a href="javascript::void(0)">당근비즈니스</a></li>
            <li><a href="javascript::void(0)">채팅하기</a></li>
          </ul>
          <ul class="footer_category">
            <li><a href="javascript::void(0)">자주 묻는 질문</a></li>
            <li><a href="javascript::void(0)">회사 소개</a></li>
            <li><a href="javascript::void(0)">인재 채용</a></li>
          </ul>
        </section>
      </section>
      <section id="footer_second_sec">
        <section>
          <section id="company_info">
            <div>
             <span>
              <b>대표</b>
              손동현
              </span>
              <span>|</span>
              <span>
                <b>사업자번호</b>
                375-87-00088
              </span>
            </div>
            <div>
              <span>
              <b>직업정보제공사업 신고번호</b>
              2016-서울서초-0051
              </span>
            </div>
            <div>
              <span>
                <b>주소</b>
                서울특별시 구로구 디지털로 30길 28, 609호 (당근서비스)
                </span>
            </div>
            <div>
                        <span>
                            <b>전화</b>
                            010-6611-9189
                        </span>
              <span>|</span>
              <span>
                            <b>고객문의</b>
                            cs@daangnservice.com
                        </span>
            </div>
          </section>
          <section id="inquiry">
            <a href="/">제휴 문의</a>
            <a href="/">광고 문의</a>
            <a href="/">PR 문의</a>
            <a href="/">IR 문의</a>
          </section>
          <section id="clause">
            <div><a href="/">이용약관</a></div>
            <div><a style="color:#4d5159" href="/">개인정보처리방침</a></div>
            <div><a href="/">위치기반서비스 이용약관</a></div>
            <div><a href="/">이용자보호 비전과 계획</a></div>
          </section>
        </section>
        <section id="sns">
          <a href="https://www.facebook.com/daangn"><img src="https://www.picng.com/upload/circle/png_circle_84154.png" alt="페이스북"></a>
          <a href="https://www.instagram.com/daangnmarket/"><img src="https://www.picng.com/upload/circle/png_circle_84154.png" alt="인스타그램"></a>
          <a href="https://www.youtube.com/channel/UC8tsBsQBuF7QybxgLmStihA"><img src="https://www.picng.com/upload/circle/png_circle_84154.png" alt="유튜브"></a>
          <a href="https://blog.naver.com/daangn"><img src="https://www.picng.com/upload/circle/png_circle_84154.png" alt="네이버 블로그"></a>
          <div id="language">
            <img src="https://seeklogo.com/images/G/globe-logo-42DE548AC7-seeklogo.com.png">
            <select>
              <option>한국</option>
              <option>영국</option>
              <option>캐나다</option>
              <option>미국</option>
              <option>일본</option>
            </select>
            <img src="https://vieuxfourmanago.com/wp-content/uploads/2017/06/Down-Arrow-PNG-HD.png">
          </div>
        </section>
      </section>
    </div>
  </div>
</template>
<script>
export default {
  name: 'FooterLayout',
};
</script>
<style lang="scss" scoped>
a {
  color: black;
  text-decoration: none;
}
#footer {
  height: 46rem;
  display: block;
  border-top: 1px solid #EAEBEE;
  text-align: left;
  margin-left:1rem;
}
#footer_container {
  font-family: sans-serif;
  max-width: 52rem;
  margin: 0 auto;
}
#footer_first_sec{
  padding: 2rem 0;
  font-size: 0.9rem;
}
#nav_menu {
  display: flex;
}
.footer_category {
  display: flex;
  flex-direction: column;
  list-style: none;
  width: 33%;
  padding: 0;
}
.footer_category:last-child {
  margin-right: 15%;
}
.footer_category > li {
  margin: 1rem;
  width: fit-content;
}
.footer_category > li > a {
  color: #212124;
}
.footer_category > li > a:hover {
  text-decoration: underline;
}
#app_download, #sns{
  font-weight: 700;
}

@media screen and (min-width: 768px){
  #app_download{
    float: right;
  }
  .app_icon > div {
    display: inline-block;
    text-align: center;
    width: 150px;
    padding: 12px;
    background-color: #F2F3F6;
    border-radius: 5px;
    margin-top: 0.8rem;
    cursor: pointer;
  }
  .app_icon:last-child > div {
    margin-left: 0.6rem;
  }
  .app_icon > div > img{
    width: 20px;
    margin-right: 5px;
  }
  .app_icon > span {
    display: none;
  }
  #footer_second_sec {
    display: flex;
  }
}
@media screen and (max-width: 767px){
  #footer_first_sec{
    font-size: 0.8rem;
  }
  #app_download > div{
    display: inline-block;
  }
  .app_icon > div {
    display: none;
  }
  .app_icon > span {
    margin-left: 1.5rem;
  }
  .app_icon > span > img{
    width: 10px;
    margin-left: 0.8rem;
  }

  #sns{
    margin-top: 2rem;
  }
}

#footer_second_sec {
  border-top: 1px solid #EAEBEE;
  padding-top: 1.6rem;
  font-size: 0.8rem;
  color: #868b94;
}
#footer_second_sec > section {
  vertical-align: top;
  max-width: 26rem;
}
#footer_second_sec > section > section:not(:last-child) {
  padding-bottom: 1rem;
}
#company_info span:nth-child(2){
  font-weight: 900;
  margin: 0 5px 0 5px;
  color: #EAEBEE;
}

#inquiry > a, #clause > div > a {
  font-weight: 700;
  margin-right: 1rem;
  color: #868b94;
}
#inquiry > a:hover, #clause > div > a:hover{
  text-decoration: underline;
}

#clause, #sns {
  display: flex;
  flex-wrap: wrap;
}
#sns > a > img {
  width: 30px;
  margin-right: 0.4rem;
}
#language {
  //display: inline-block;
  padding: 0.3rem 1rem;
  border-radius: 4px;
  cursor: pointer;
  height:2rem;
}
#language:hover {
  background-color: #eaebee;
}
#language > img:first-child {
  width: 15px;
}
#language > img:last-child {
  width: 10px;
}
#language > select {
  border: none;
  padding: 0 0.6rem;
  -webkit-appearance: none;
  color: #868b94;
  background-color: transparent;
}

</style>
