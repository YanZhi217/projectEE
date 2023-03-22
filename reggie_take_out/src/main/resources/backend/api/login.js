function loginApi(data) {
  return $axios({
    // 以post请求方式携带用户名密码数据向后端/employee/login发送请求
    'url': '/employee/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/employee/logout',
    'method': 'post',
  })
}
