const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
  devServer: {
    https: true,
    port: 8080,
    open: true,
    proxy: {
      '/api/v1': {
        target: 'https://localhost:8080/'
      },
    },
    historyApiFallback: true,
    hot: true
  },
  // css : {
  //   // import 할 때 경로에 .module 포함하지 않아도 됨
  //   requireModuleExtension: false
  // },
  transpileDependencies: [
    'element-plus'
  ],
  lintOnSave: false,
  // outputDir: '../backend/src/main/resources/dist'
  outputDir: './dist'
}
