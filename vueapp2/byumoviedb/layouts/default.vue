<template>
  <div>
    <header>
      <img src="/moviereel.svg" width="100px">
      <h1>BYU Movie DB</h1>
    </header>
    <nuxt/>
  </div>
</template>

<style>
html, body {
  margin: 0px !important;
}

body {
  background-color: #333 !important;
}

header {
  background-color: white;
  height: 80px;
  top: 0px;
  position: sticky;
}

header img {
  padding-left: 20px;
}

header h1 {
  font-family: 'Paytone One', sans-serif;
  color: #555;
  font-size: 30px;
  position: relative;
  top: -105px;
  left: 105px;
  right: -105px;
  padding-left: 20px;
  margin-top: 20px;
}
</style>
