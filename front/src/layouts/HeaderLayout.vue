<template>
  <div class="header">
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
              <a class="nav-link" href="#">
                <span class="main-tab">중고거래</span>
              </a>
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
          <form class="d-flex align-middle">
            <input class="form-control me-2 search-input"
                   type="search"
                   placeholder="물품이나 동네를 검색해보세요"
                   aria-label="Search">
            <router-link to="/login" class="login pt-1">
              <span class="pr-2">로그인</span>
            </router-link>
            <router-link to="/signup" class="login pt-1">
              <span>회원가입</span>
            </router-link>
          </form>
        </div>
      </div>
    </nav>
  </div>
</template>
<script>
export default {
  name: 'HeaderLayout',
};
</script>
<style lang="scss" scoped>
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
    width: 250px;
    background-color: #f2f3f6;
  }
  .login{
    margin-right: 5px;
  }
}

</style>
