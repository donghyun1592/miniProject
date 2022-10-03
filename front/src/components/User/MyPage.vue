<template>
  <div class="container">
    <b-card title="마이페이지" class="pb-5 pt-3 border-0">
      <b-tabs card>
        <b-tab title="회원정보" active>
          {{$store.state.member}}
          <b-card-text>
            <b-table
                     :items="$store.state.member"
                     fields="infoField">
            </b-table>
          </b-card-text>
        </b-tab>
        <b-tab title="게시글">
          <b-card-text>Tab contents 2</b-card-text>
        </b-tab>
        <b-tab title="채팅방">
          <b-card-text>Tab contents 2</b-card-text>
        </b-tab>
      </b-tabs>
    </b-card>
  </div>
</template>
<script>
export default {
  name: 'MyPage',
  data() {
    return {
      infoField: [
        {key: 'name', label: '이름'},
        {key: 'email', label: '이메일'},
      ],
    };
  },
};
</script>
<style lang="scss" scoped>
.container{
  padding-left: 10rem;
  padding-right: 10rem;
}
</style>
