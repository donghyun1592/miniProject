<template>
  <div class="login-container">
    <b-card title="로그인" class="pb-5 pt-3 border-0">
      <div class="input-form col-md-12 mx-auto">
        <b-form @submit.stop.prevent="login">
        <b-row>
          <b-col cols='3' offset-md="1" class="mt-2">
            <label for="email">아이디(이메일)</label>
          </b-col>
          <b-col cols='7'>
              <b-form-group id="example-input-group-1"
                            labal="아이디(이메일)"
                            label-for="example-input-1">
                <b-form-group id="example-input-group-1"
                              label-for="example-input-1">
                  <b-form-input
                      id="example-input-1"
                      name="example-input-1"
                      v-model="$v.form.email.$model"
                      :state="validateState('email')"
                      aria-describedby="input-1-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback
                      v-if="form.email == ''"
                      id="input-1-live-feedback">
                    필수 입력란 입니다.
                  </b-form-invalid-feedback>
                  <b-form-invalid-feedback
                      v-else
                      id="input-1-live-feedback">
                    이메일 형식으로 입력해주세요
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
          </b-col>
        </b-row>
          <br>
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="password">비밀번호</label>
            </b-col>
            <b-col cols='7'>
              <b-form-group id="example-input-group-2"
                            label-for="example-input-2">
                <b-form-group id="example-input-group-2"
                              label-for="example-input-2">
                  <b-form-input
                      type="password"
                      id="example-input-2"
                      name="example-input-2"
                      v-model="$v.form.password.$model"
                      :state="validateState('password')"
                      aria-describedby="input-2-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-2-live-feedback">
                    필수 입력란 입니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
          </b-row>
          <div class="submit pt-3">
            <b-button type="submit" variant="primary">로그인</b-button>
          </div>
        </b-form>
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
    <ConfirmModal ref="confirmModal" :text="text"></ConfirmModal>
  </div>
</template>
<script>
import {validationMixin} from 'vuelidate';
import {required, email} from 'vuelidate/lib/validators';
import axios from 'axios';

export default {
  mixins: [validationMixin],
  name: 'LoginPage',
  data() {
    return {
      form: {
        email: '',
        password: '',
      },
      text: '',
    };
  },
  validations: {
    form: {
      email: {
        required,
        email,
      },
      password: {
        required,
      },
    },
  },
  methods: {
    validateState(name) {
      const {$dirty, $error} = this.$v.form[name];
      return $dirty ? !$error : null;
    },
    login() {
      this.$v.form.$touch();
      if (this.$v.form.$anyError) {
        return;
      }
      const login = new Promise((resolve, reject) => {
        axios.post('/api/login', {
          email: this.form.email,
          password: this.form.password,
        }).then((res) => {
          if (res.status == 200) {
            const token = res.data.token || '';
            this.$store.commit('setToken', token);
            resolve(token);
          }
        }).catch((err) => {
          this.$refs.confirmModal.show('로그인 실패', '아이디 또는 비밀번호가 틀렸습니다.');
        });
      });

      if (!this.$v.$invalid) {
        login.then((res) => {
          this.getMemberInfo(res).then((res) => {
            this.$store.commit('setMember', res);
          });
        }).finally(()=>{
          this.$refs.confirmModal.show('로그인 성공', '환영합니다');
          setTimeout(() => {
            this.$router.push('/');
          }, 2000);
        });
      } else {
        return;
      }
    },
    getMemberInfo(token) {
      return new Promise((resolve, reject) => {
        axios.get('/api/member', {
          headers: {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer ' + token,
          },
        }).then((res) => {
          if (res.status == 200) {
            resolve(res.data);
          }
        }).catch((err)=> reject(err));
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
