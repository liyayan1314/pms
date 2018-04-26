import fetch from '@/utils/fetch';


export function logout(user) {
  return fetch({
    url: '/user/findUserById',
    method: 'post',
    data: user
  });
}

export function test(user) {
  return fetch({
    url: '/user/test',
    method: 'post',
    data: user
  });
}

export function findAll() {
  return fetch({
    url: '/user/findAll',
    method: 'post',
    data: ""
  });
}

export function selectName(name) {
  return fetch({
    url: '/user/findUserByName',
    method: 'post',
    data: {name:name}
  });
}

