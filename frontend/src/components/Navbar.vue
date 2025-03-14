<script setup>
import { RouterLink } from 'vue-router';
import TestimonialsView from "@/views/TestimonialsView.vue";
</script>

<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/gallery">Gallery</router-link> |
    <router-link to="/services">Services</router-link> |
    <router-link to="testimonials">Testimonials</router-link> |
    <router-link to="/contact">Contact</router-link>
  </nav>
</template>

<style scoped>
nav {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  background: #333;
  padding: 15px 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 20px;
  height: auto;
  z-index: 1000;
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
