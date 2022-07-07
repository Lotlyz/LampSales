import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/Home.vue'
import User from '../views/User.vue'
import Sale from '../components/Sale.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
    
  },
  // {
  //   path: '/about',
  //   name: 'about',
  //   component: () => import(/* webpackChunkName: "about" */  '../views/AboutView.vue')
  // },
  {
    path: '/lamp',
    name: 'lamp',
    component: () => import(/* webpackChunkName: "about" */  '../views/Lamp.vue')
    
  },

  {
    path: '/user',
    name: 'user',
    component: User
  },
  {
    path: '/sale',
    name: 'salea',
    component: Sale
    // component: () => import(/* webpackChunkName: "about" */  '../views/Lamp.vue')
  },

]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
