<script setup>
import { RouterLink } from 'vue-router';
</script>

<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/gallery">Gallery</router-link> |
    <router-link to="/contact">Contact</router-link>
  </nav>
</template>

<style scoped>
nav {
  display: flex;
  gap: 20px;
  background: #333;
  padding: 10px;
}
nav a {
  color: white;
  text-decoration: none;
  font-size: 18px;
}
nav a:hover {
  text-decoration: underline;
}
</style>
