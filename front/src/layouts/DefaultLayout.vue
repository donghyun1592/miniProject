<template>
  <div>
    <HeaderLayout></HeaderLayout>
    <router-view/>
    <FooterLayout></FooterLayout>
  </div>
</template>
<script>
import HeaderLayout from './HeaderLayout';
import FooterLayout from '@/layouts/FooterLayout';

export default {
  name: 'defaultLayout',
  components: {
    HeaderLayout: HeaderLayout,
    FooterLayout: FooterLayout,
  },
};
</script>
<style>

</style>
