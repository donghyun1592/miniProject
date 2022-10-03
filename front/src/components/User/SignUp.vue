<template>
  <div>
    <b-card title="회원가입" class="pt-3 pb-5">
      <div class="input-form col-md-12 mx-auto">
        <b-form @submit.stop.prevent="signUp">
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="email">이름</label>
            </b-col>
            <b-col cols='5'>
              <b-form-group id="example-input-group-1"
                            labal="이름"
                            label-for="example-input-1">
                <b-form-group id="example-input-group-1"
                              label-for="example-input-1">
                  <b-form-input
                      id="example-input-1"
                      name="example-input-1"
                      v-model="$v.form.name.$model"
                      :state="validateState('name')"
                      aria-describedby="input-1-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback
                      id="input-1-live-feedback">
                    필수입력란 입니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="email">아이디(이메일)</label>
            </b-col>
            <b-col cols='5'>
              <b-form-group id="example-input-group-2"
                            labal="아이디(이메일)"
                            label-for="example-input-2">
                <b-form-group id="example-input-group-2"
                              label-for="example-input-2">
                  <b-form-input
                      id="example-input-2"
                      name="example-input-2"
                      v-model="$v.form.email.$model"
                      :state="validateState('email') && !this.isDuplicateEmail"
                      aria-describedby="input-2-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback
                      v-if="form.email==''"
                      id="input-2-live-feedback">
                    필수입력란 입니다.
                  </b-form-invalid-feedback>
                  <b-form-invalid-feedback
                      v-else-if="isDuplicateEmail"
                      id="input-2-live-feedback">
                    이메일 중복확인을 해주세요.
                  </b-form-invalid-feedback>
                  <b-form-invalid-feedback
                      v-else
                      id="input-2-live-feedback">
                    이메일형식이 아닙니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
            <b-col cols="2">
              <b-button class="ml-2" @click="checkDuplication" size="sm">
                중복확인
              </b-button>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="password">비밀번호</label>
            </b-col>
            <b-col cols='5'>
              <b-form-group id="example-input-group-1"
                            label-for="example-input-1">
                <b-form-group id="example-input-group-1"
                              label-for="example-input-1">
                  <b-form-input
                      type="password"
                      id="example-input-1"
                      name="example-input-1"
                      v-model="$v.form.password.$model"
                      :state="validateState('password')"
                      aria-describedby="input-1-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-1-live-feedback">
                    필수입력란 입니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="password">주소</label>
            </b-col>
            <b-col cols='5'>
              <b-form-group id="example-input-group-1"
                            label-for="example-input-1">
                <b-form-group id="example-input-group-1"
                              label-for="example-input-1">
                  <b-form-input
                      id="example-input-1"
                      name="example-input-1"
                      v-model="$v.form.address.$model"
                      :state="validateState('address')"
                      aria-describedby="input-1-live-feedback"
                      disabled
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-1-live-feedback">
                    필수입력란 입니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
            <b-col cols="2">
                <b-button class="ml-2" @click="addressApi()" size="sm">
                  검색
                </b-button>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="password">상세주소</label>
            </b-col>
            <b-col cols='5'>
              <b-form-group id="example-input-group-1"
                            label-for="example-input-1">
                <b-form-group id="example-input-group-1"
                              label-for="example-input-1">
                  <b-form-input
                      type="password"
                      id="example-input-1"
                      name="example-input-1"
                      v-model="form.addressDetail"
                      aria-describedby="input-1-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-1-live-feedback">
                    필수입력란 입니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
          </b-row>
          <br>
          <b-row>
            <b-col cols='3' offset-md="1" align-self="center">
              <label for="password">휴대폰번호</label>
            </b-col>
            <b-col cols='5'>
              <b-form-group id="example-input-group-1"
                            label-for="example-input-1">
                <b-form-group id="example-input-group-1"
                              label-for="example-input-1">
                  <b-form-input
                      id="example-input-1"
                      name="example-input-1"
                      v-model="$v.form.phone.$model"
                      :state="validateState('phone')"
                      aria-describedby="input-1-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-1-live-feedback">
                    필수입력란 입니다.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
          </b-row>
          <div class="submit pt-3">
            <b-button type="submit" variant="primary">
              회원가입
            </b-button>
          </div>
        </b-form>
      </div>
    </b-card>
  </div>
</template>
<script>
import {validationMixin} from 'vuelidate';
import {required, email} from 'vuelidate/lib/validators';
import axios from 'axios';

export default {
  mixins: [validationMixin],
  name: 'SignUp',
  data() {
    return {
      form: {
        name: '',
        email: '',
        password: '',
        address: '',
        addressNum: '',
        addressDetail: '',
        phone: '',
      },
      isDuplicateEmail: true,
    };
  },
  validations: {
    form: {
      name: {
        required,
      },
      email: {
        required,
        email,
      },
      password: {
        required,
      },
      address: {
        required,
      },
      phone: {
        required,
      },
    },
  },
  watch: {
    'form.email'() {
      this.isDuplicateEmail = true;
    },
  },
  methods: {
    validateState(name) {
      const {$dirty, $error} = this.$v.form[name];
      return $dirty ? !$error : null;
    },
    checkDuplication() {
      if (this.form.email == '') {
        this.isDuplicateEmail = true;
        return;
      }
      axios({
        url: '/api/member/' + this.form.email,
        method: 'get',
      }).then((res) => {
        if (!res.data && !this.form.email == '') {
          alert('사용가능한 이메일 입니다');
          this.isDuplicateEmail = false;
        } else {
          alert('중복 이메일입니다');
        }
      });
    },
    signUp() {
      this.$v.form.$touch();
      if (this.$v.form.$anyError) {
        return;
      }
      if (this.isDuplicateEmail) {
        alert('이메일 중복체크를 해주세요');
        return;
      }

      axios.post('/api/member', this.form).then((res) => {
        alert('회원가입 성공');
        this.$router.push('/login');
      }).catch((err) => {
        console.log(err);
      });
    },
    addressApi() {
      new window.daum.Postcode({
        oncomplete: (
            data,
        ) => {
          let fullRoadAddr = data.roadAddress; // 도로명 주소 변수
          let extraRoadAddr =
              '';

          if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          } // 건물명이 있고, 공동주택일 경우 추가한다.

          if (data.buildingName !== '' && data.apartment === 'Y') {
            extraRoadAddr += (extraRoadAddr !== '' ?
                ', ' + data.buildingName : data.buildingName);
          } // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== '') {
            extraRoadAddr = ' (' + extraRoadAddr + ')';
          } // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
          if (fullRoadAddr !== '') {
            fullRoadAddr += extraRoadAddr;
          } // 우편번호와 주소 정보를 해당 필드에 넣는다.

          this.form.addressNum = data.zonecode; // 5자리 새우편번호 사용
          this.form.address = fullRoadAddr;
        },
      }).open(this.$refs.embed);
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
