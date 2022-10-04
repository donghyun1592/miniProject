<template>
  <div class="header-layout-container">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">
          <img class="logo-image" src='../assets/logo.png' alt="logo">
        </a>
        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mt-1 mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link to="/market" class="nav-link">
                <span class="main-tab">중고거래</span>
              </router-link>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="sub-tab">알바</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span class="sub-tab">부동산 직거래</span>
              </a>
            </li>
          </ul>
          <form class="d-flex justify-content-center">
            <input class="form-control me-2 search-input"
                   type="search"
                   placeholder="물품이나 동네를 검색해보세요."
                   aria-label="Search">
          </form>
            <ul class="navbar-nav me-auto mt-1 mb-2">
              <li>
                <router-link to="/login" v-if="!isLogin" class="login pt-1">
                  <span class="pr-2">로그인</span>
                </router-link>
              </li>
              <li>
                <router-link to="/signup" v-if="!isLogin" class="login pt-1">
                  <span>회원가입</span>
                </router-link>
              </li>
              <li>
                <router-link to="/mypage" v-if="isLogin" class="login pt-1">
                  <span> 마이페이지 </span>
                </router-link>
              </li>
              <li>
                <a href="/" v-if="isLogin" @click="logout" class="login pt-1">
                  <span> 로그아웃 </span>
                </a>
              </li>
            </ul>
        </div>
      </div>
    </nav>

    <ConfirmModal ref="confirmModal"></ConfirmModal>
  </div>
</template>
<script>
export default {
  name: 'HeaderLayout',
  data() {
    return {

    };
  },
  computed: {
    isLogin() {
      return this.$store.state.token != '';
    },
  },
  methods: {
    logout() {
      this.$store.commit('logout');
      this.$refs.confirmModal.show('로그아웃', '로그아웃 되었습니다.');
    },
  },
};
</script>
<style lang="scss" scoped>
.header-layout-container{
  border-bottom: 1px solid #EAEBEE;
}
::v-deep{
  .navbar{
    padding-left: 5rem;
    padding-right: 5rem;
  }
  .logo-image{
    width: 120px;
  }
  .main-tab{
    color: darkorange;
    font-size: 1.3em;
    font-weight: bold;
  }
  .sub-tab{
    font-size: 1.3em;
    font-weight: bold;
  }
  .nav-link{
    margin-right: 20px;
  }
  .search-input{
    width: 18rem;
    background-color: #f2f3f6;
  }
  .login{
    margin-right: 5px;
  }
}

</style>
