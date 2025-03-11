import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import GalleryView from '../views/GalleryView.vue';
import ContactView from '../views/ContactView.vue';

const routes = [
  {path:'/', name: 'Home', component: HomeView},
  {path:'/gallery', name: 'Gallery', component: GalleryView},
  {path: '/contact', name: 'Contact', component: ContactView},
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
