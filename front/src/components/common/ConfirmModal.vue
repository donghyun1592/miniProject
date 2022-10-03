<template>
  <b-modal ref="m"
           :title="title"
           centered
           ok-title="확인"
           ok-only>
    {{text}}
  </b-modal>
</template>
<script>
export default {
  name: 'ConfirmModal',
  data() {
    return {
      text: '',
      title: '',
    };
  },
  methods: {
    show(title, text) {
      this.title = title;
      this.text = text;
      this.$refs.m.show();
    },
  },
};
</script>
