<template>
  <div>
  </div>
</template>
<script>
export default {
  name: 'AddressSelectModal',
  data() {
    return {
      addressInfo: {
        address: '',
        addressNum: '',
      },
    };
  },
  watch: {
    addressInfo: {
      deep: true,
      handler() {
        this.$emit('setAddress', this.addressInfo);
      },
    },
  },
  methods: {
    show() {
      this.showAddressSelector();
    },
    showAddressSelector() {
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

          this.addressInfo.addressNum = data.zonecode;
          this.addressInfo.address = fullRoadAddr;
        },
      }).open(this.$refs.embed);
    },
  },
};
</script>
