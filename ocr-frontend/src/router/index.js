import Vue from 'vue'
import Router from 'vue-router'
import usermanagement from '@/components/usermanagement'
import ocr from '@/components/ocr'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'userManagement',
      component: usermanagement
    },
    {
      path: '/ocr',
      name: 'ocr',
      component: ocr
    }
  ]
})
