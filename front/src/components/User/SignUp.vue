<template>
  <div>
    <b-card title="회원가입">
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
                @click="signUp">
          회원가입
        </button>
      </div>
    </b-card>
  </div>
</template>
<script>

export default {
  name: 'SignUp',
  data() {
    return {
      form: {
        email: '',
        password: '',
        rePassword: '',
        address: '',
        gender: '',
      },
    };
  },
  methods: {
    signUp() {
      const user = {
        accountId: 'test3',
        password: '23',
        name: '손',
        phoneNum: '123',
        lastLoginDate: new Date().valueOf(),
        regDate: new Date().valueOf(),
        updateDate: new Date().valueOf(),
      };
      this.$axios.post('http://localhost:8080/user/signup', user).then((res) => {
        console.log(res);
      }).catch((err) => {
        console.log(err);
      });
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
