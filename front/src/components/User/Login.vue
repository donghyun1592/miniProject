<template>
  <div>
    <b-card title="로그인">
      <div class="input-form col-md-12 mx-auto">
        <b-row>
          <b-col cols='3' offset-md="1" align-self="center">
            <label for="email">아이디(이메일)</label>
          </b-col>
          <b-col cols='7'>
            <input type="email"
                   class="form-control"
                   v-model="form.email"
                   placeholder="you@example.com"
                   required>
          </b-col>
        </b-row>
        <br>
        <b-row>
          <b-col cols='3' offset-md="1" align-self="center">
            <label for="password">비밀번호</label>
          </b-col>
          <b-col cols='7'>
            <input type="password"
                   class="form-control"
                   v-model="form.password"
                   required>
            <div class="invalid-feedback"> 비밀번호를 입력해주세요. </div>
          </b-col>
        </b-row>
        <button class="btn btn-primary btn-small btn-block mb-3 mt-3"
                type="submit"
                size="sm"
                @click="login">
          로그인
        </button>
        <b-row class="m-3">
          <b-col>
            <a href="#" class="mx-3" v-b-modal.findEmail>아이디찾기</a>
          </b-col>
          <b-col>
            <a href="#" class="mx-3" v-b-modal.findPassword>비밀번호찾기</a>
          </b-col>
          <b-col>
            <b-link href='/join' class="mx-3">회원가입</b-link>
          </b-col>
        </b-row>
      </div>
    </b-card>
  </div>
</template>
<script>
export default {
  name: 'LoginPage',
  data() {
    return {
      form: {
        email: '',
        password: '',
      },
    };
  },
  methods: {
    login() {
      console.log('login');
    },
  },
};
</script>
<style lang="scss" scoped>
.input-form {
  max-width: 680px;
  margin-top: 30px;
  padding: 32px;
  background: #fff;
  border-radius: 10px;
  box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
