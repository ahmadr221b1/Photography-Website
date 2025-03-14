import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import GalleryView from '../views/GalleryView.vue';
import ContactView from '../views/ContactView.vue';
import ServicesView from "@/views/ServicesView.vue";
import TestimonialsView from "@/views/TestimonialsView.vue";

const routes = [
  {path:'/', name: 'Home', component: HomeView},
  {path:'/gallery', name: 'Gallery', component: GalleryView},
  {path: '/services', name: 'Services', component: ServicesView},
  {path: '/testimonials', name: 'Testimonials', component: TestimonialsView},
  {path: '/contact', name: 'Contact', component: ContactView}
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
