<script setup>
import { RouterView } from 'vue-router'
import Navbar from "./components/Navbar.vue";
import Footer from "@/components/Footer.vue";
</script>

<template>
  <div class="app-container">
    <Navbar />
    <main>
      <router-view />
    </main>
    <Footer />
  </div>
</template>

<style scoped>
.app-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  width: 100%;
}

main {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  padding: 20px;
}
</style>
