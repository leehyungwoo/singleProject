import Vue from 'vue'
import Router from 'vue-router'
import myComponent from '@/components/myComponent'
import Home from '@/components/pages/Home'
import Join from '@/components/pages/Join'
import Login from '@/components/pages/Login'
import FindUser from '@/components/pages/FindUser'
import Mypage from '@/components/pages/Mypage'

Vue.use(Router)

export default new Router({
  mode:"history",
  routes: [
    {
      path: '/myComponent',
      name: 'myComponent',
      component: myComponent
    },
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/join',
      name: 'Join',
      component: Join
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/find-user',
      name: 'FindUser',
      component: FindUser
    },
    {
      path: '/mypage',
      name: 'Mypage',
      component: Mypage
    }
  
  ]
})
