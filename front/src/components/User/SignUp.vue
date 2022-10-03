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
                      v-else-if="!$v.form.email.email"
                      id="input-2-live-feedback">
                    이메일 형식이아닙니다
                  </b-form-invalid-feedback>
                  <b-form-invalid-feedback
                      v-else
                      id="input-2-live-feedback">
                    중복체크를 해주세요.
                  </b-form-invalid-feedback>
                </b-form-group>
              </b-form-group>
            </b-col>
            <b-col cols="2">
              <b-button class="ml-2"
                        @click="checkDuplication"
                        size="sm"
                        :disabled="form.email==''">
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
              <b-form-group id="example-input-group-3"
                            label-for="example-input-3">
                <b-form-group id="example-input-group-3"
                              label-for="example-input-3">
                  <b-form-input
                      type="password"
                      id="example-input-3"
                      name="example-input-3"
                      v-model="$v.form.password.$model"
                      :state="validateState('password')"
                      aria-describedby="input-1-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-3-live-feedback">
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
              <b-form-group id="example-input-group-4"
                            label-for="example-input-4">
                <b-form-group id="example-input-group-4"
                              label-for="example-input-4">
                  <b-form-input
                      id="example-input-4"
                      name="example-input-4"
                      v-model="$v.form.address.$model"
                      :state="validateState('address')"
                      aria-describedby="input-4-live-feedback"
                      disabled
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-4-live-feedback">
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
              <b-form-group id="example-input-group-5"
                            label-for="example-input-5">
                <b-form-group id="example-input-group-5"
                              label-for="example-input-5">
                  <b-form-input
                      type="password"
                      id="example-input-5"
                      name="example-input-5"
                      v-model="form.addressDetail"
                      aria-describedby="input-5-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-5-live-feedback">
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
              <b-form-group id="example-input-group-6"
                            label-for="example-input-6">
                <b-form-group id="example-input-group-6"
                              label-for="example-input-6">
                  <b-form-input
                      id="example-input-6"
                      name="example-input-6"
                      v-model="$v.form.phone.$model"
                      :state="validateState('phone')"
                      aria-describedby="input-6-live-feedback"
                  ></b-form-input>
                  <b-form-invalid-feedback id="input-6-live-feedback">
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

    <AddressSelectModal ref="addressSelectModal"
                        @setAddress="setAddress">
    </AddressSelectModal>
    <ConfirmModal ref="confirmModal"></ConfirmModal>
  </div>
</template>
<script>
import {validationMixin} from 'vuelidate';
import {required, email} from 'vuelidate/lib/validators';
import AddressSelectModal from '@/components/common/AddressSelectModal';
import axios from 'axios';

export default {
  components: {AddressSelectModal},
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
          this.$refs.confirmModal.show('이메일 중복확인', '사용가능한 이메일입니다');
          this.isDuplicateEmail = false;
        } else {
          this.$refs.confirmModal.show('이메일 중복확인', '중복된 이메일입니다.');
        }
      });
    },
    signUp() {
      this.$v.form.$touch();
      if (this.$v.form.$anyError) {
        return;
      }
      if (this.isDuplicateEmail) {
        this.$refs.confirmModal.show('회원가입 실패', '이메일 중복체크를 해주세요');
        return;
      }

      axios.post('/api/member', this.form).then((res) => {
        this.$refs.confirmModal.show('회원가입 성공', '회원가입 되셨습니다.');
        setTimeout(() => {
          this.$router.push('/login');
        }, 3000);
      }).catch((err) => {
        console.log(err);
      });
    },
    addressApi() {
      this.$refs.addressSelectModal.show();
    },
    setAddress(addressInfo) {
      this.form.address = addressInfo.address;
      this.form.addressNum = addressInfo.addressNum;
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
