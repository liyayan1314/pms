<template>
  <div>
    <el-row>
      <div style="float: left">
        <vue-file-upload url="/ocr/OCRwithAccurate" ref="vueFileUploader"
                         class="fileupload-button" :events="cbEvents" :filters="filters" :request-options="reqopts"
                         @onAdd="onAddItem"><span slot="label">选择文件</span></vue-file-upload>
        <!--<el-button type="primary" size="mini" @click="uploadAll">上传所有文件-->
        <!--</el-button>-->
        <!--<el-button type="primary" size="mini" @click="clearAll">清空文件列表-->
        <!--</el-button>-->
      </div>

    </el-row>
    <el-row>
      <el-card>
        <el-table :data="files" height="650" style="width:100%;"  :border="true">
          <el-table-column label="文件名" width="120">
            <template slot-scope="scope">
              <span>{{scope.row.name }}</span>
            </template>
          </el-table-column>
          <el-table-column label="大小" width="100">
            <template slot-scope="scope">
              <span>{{scope.row.size }}</span>
            </template>
          </el-table-column>
          <el-table-column prop="date" label="预览" width="400">

            <template slot-scope="scope">
              <img :src="onPreview(scope.row)" width="400px"/>
            </template>
          </el-table-column>

          <el-table-column label="识别内容" width="400">
            <template slot-scope="scope">
              <span>{{scope.row.wordstomsg }}</span>
            </template>
          </el-table-column>

          <el-table-column label="进度" width="100">
            <template slot-scope="scope">
              <span>{{scope.row.progress }}</span>
            </template>
          </el-table-column>

          <el-table-column label="状态" width="120">
            <template slot-scope="scope">
              <span>{{ scope.row | onStatus }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" width="180" fixed="right">

            <template slot-scope="scope">
              <el-button type="primary" size="mini" @click="uploadItem(scope.row)">识别
              </el-button>
              <el-button type="primary" size="mini" @click="deleteItem(scope.row)">删除
              </el-button>
            </template>
          </el-table-column>


        </el-table>


      </el-card>
    </el-row>
  </div>
</template>

<script>
  import VueFileUpload from 'vue-file-upload';
  import {logout,test} from '@/api/login';

  export default {
    name: "ocrlist",
    data() {
      return {
        files: [],
        //过滤器回调
        filters: [
          {
            name: "imageFilter",
            fn(file) {
              var type = '|' + file.type.slice(file.type.lastIndexOf('/') + 1) + '|';
              return '|jpg|png|jpeg|bmp|gif|'.indexOf(type) !== -1;
            }
          }
        ],
        //事件回调
        cbEvents: {
          onCompleteUpload: (file, response, status, header) => {
        //    console.log(file);
            this.$set(file, 'wordstomsg', response.wordstomsg);

            console.log("finish upload;")
          },
          onAddFileSuccess: (file) => {
            console.log(file);
            console.log("success add to queue");
          },
          onProgressUpload: (file, progress) => {
            console.log(file.name + ":" + progress);
          }
        },
        reqopts: {
          formData: {
            tokens: 'tttttttttttttt',
            authorization: '',
          },
          responseType: 'json',
          withCredentials: false,
          headers: {
            'custormerHeader': 'aaa'
          }
        }
      }
    },

    filters: {
      onStatus(file) {
        if (file.isSuccess) {
          return "识别成功";
        } else if (file.isError) {
          return "识别失败";
        } else if (file.isUploading) {
          return "正在识别";
        } else {
          return "待识别";
        }
      },
    },

    created() {

        var user={
          "id": "李压延",
          "name": "liyayan",
          "password": "string",
          "phone": "13800138000"
        }
      logout(0).then(response => {
       console.log(response);
      });

      test(user).then(response => {
       console.log(response);
      })
    },
    mounted() {
      this.$refs.vueFileUploader.setFormDataItem('authorization', "123");
    },
    methods: {

      onPreview(file) {
        if ("URL" in window) {
          var src = window.URL.createObjectURL(file.file);
          return src;
        }

      },
      onAddItem(files) {
        console.log(files);
        this.files = files;
      },
      uploadItem(file) {
        file.upload();
      },
      deleteItem(file) {
        file.remove();
      },
      uploadAll() {
        this.$refs.vueFileUploader.uploadAll();
      },
      clearAll() {
        this.$refs.vueFileUploader.clearAll();
      }
    },
    components: {
      VueFileUpload
    }
  }

</script>

<style>
  .vue-file-upload {
    position: relative;
    overflow: hidden;
    display: inline-block;
    color: #fff;
    padding: 6px 12px;
    background-color: #5cb85c;
    border-color: #4cae4c;
    margin: 0;
    font-size: 14px;
    font-weight: 400;
    line-height: 1.42857143;
    text-align: center;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
  }

  .vue-file-upload input[type=file] {
    position: absolute;
    top: 0;
    right: 0;
    margin: 0;
    opacity: 0;
    -ms-filter: alpha(opacity=0);
    font-size: 200px;
    direction: ltr;
    cursor: pointer;
  }
</style>
