<template>
  <nav>
    <router-link to="/">首页</router-link> |
    <router-link to="/lamp">灯具管理</router-link> |
      <router-link to="/user">用户管理</router-link> |
    <router-link to="/sale">销售订单</router-link>
  </nav>
  <router-view />
</template>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 5px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>





