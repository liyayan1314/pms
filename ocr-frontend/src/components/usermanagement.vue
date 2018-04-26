<template>
  <el-container>
    <el-aside width="200px">
      <el-tree :data="data"></el-tree>
    </el-aside>
    <el-main>
      <template>
        <div class="left">
          <el-button type="primary" plain @click="newUser()">新 增</el-button>
        </div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
          <el-table-column
                  prop="name"
                  label="姓名"
                  width="100">
          </el-table-column>
          <el-table-column
                  prop="sex"
                  label="性别"
                  width="60">
          </el-table-column>
          <el-table-column
                  prop="login_id"
                  label="登录账号"
                  width="100">
          </el-table-column>
          <el-table-column
                  prop="password"
                  label="密码"
                  width="100">
          </el-table-column>
          <el-table-column
                  prop="telphone"
                  label="电话"
                  width="160">
          </el-table-column>
          <el-table-column
                  prop="email"
                  label="邮箱"
                  width="300">
          </el-table-column>
          <el-table-column
                  prop="status"
                  label="状态"
                  width="80">
          </el-table-column>
          <el-table-column
                  fixed="right"
                  label="操作"
                  width="150">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
              <el-button type="text" size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>

      <el-dialog title="新增用户" :visible.sync="dialogUser">
        <el-form ref="formtable" :model="formtable" label-width="80px">

          <div class="form-left">
            <el-form-item label="姓名 :">
              <el-input v-model="formtable.key"></el-input>
            </el-form-item>
          </div>
          <div class="form-left">
            <template>
              <el-form-item label="性别 :">
                <el-radio v-model="radio" label="1">男</el-radio>
                <el-radio v-model="radio" label="2">女</el-radio>
              </el-form-item>
            </template>
          </div>
          <div class="form-left">
            <el-form-item label="登录名:">
              <el-input v-model="formtable.key"></el-input>
            </el-form-item>
          </div>
          <div class="form-left">
            <el-form-item label="密码:">
              <el-input v-model="formtable.key"></el-input>
            </el-form-item>
          </div>
          <div class="form-left">
            <el-form-item label="电话号码:">
              <el-input v-model="formtable.key"></el-input>
            </el-form-item>
          </div>
          <div class="form-left">
            <el-form-item label="邮箱:">
              <el-input v-model="formtable.key"></el-input>
            </el-form-item>
          </div>
          <div class="form-left">
            <template>
              <el-form-item label="状态 :">
                <el-radio v-model="radio1" label="4">启用</el-radio>
                <el-radio v-model="radio1" label="5">停用</el-radio>
              </el-form-item>
            </template>
          </div>

        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="cancel()">取 消</el-button>
          <el-button type="primary" @click="saveUser(formtable)">保 存</el-button>
        </div>
      </el-dialog>
    </el-main>
  </el-container>
</template>

<script>
  import VueFileUpload from 'vue-file-upload';
  import {logout, test, selectName,findAll} from '@/api/login';

  export default {
    name: "userManagement",
    data() {
      return {
        dialogUser: false,
        radio: '1',
        radio1:'4',
        formtable: {
          key: '',
          value: ''
        },
        data: [{
          label: '一级 1',
          children: [{
            label: '二级 1-1',
            children: [{
              label: '三级 1-1-1'
            }]
          }]
        }, {
          label: '一级 2',
          children: [{
            label: '二级 2-1',
            children: [{
              label: '三级 2-1-1'
            }]
          }, {
            label: '二级 2-2',
            children: [{
              label: '三级 2-2-1'
            }]
          }]
        }, {
          label: '一级 3',
          children: [{
            label: '二级 3-1',
            children: [{
              label: '三级 3-1-1'
            }]
          }, {
            label: '二级 3-2',
            children: [{
              label: '三级 3-2-1'
            }]
          }]
        }],
        tableData: [{
          telphone: '2016-05-03',
          name: '王小虎',
          login_id: '上海',
          password: '普陀区',
          email: '上海市普陀区金沙江路 1518 弄',
          sex: '女',
          status: '有效'
        }, {
          telphone: '2016-05-02',
          name: '王小虎',
          login_id: '上海',
          password: '普陀区',
          email: '上海市普陀区金沙江路 1518 弄',
          sex: '男',
          status: '有效'
        }, {
          telphone: '2016-05-04',
          name: '王小虎',
          login_id: '上海',
          password: '普陀区',
          email: '上海市普陀区金沙江路 1518 弄',
          zip: '男',
          status: '有效'
        }, {
          telphone: '2016-05-01',
          name: '王小虎',
          login_id: '上海',
          password: '普陀区',
          email: '上海市普陀区金沙江路 1518 弄',
          sex: '男',
          status: '有效'
        }]
      }

    },

    created() {
        var user={
          "id": "46e4a8d7-b1b5-4f97-8289-66660ba9c9ce",
          "name": "liyayan",
          "password": "string",
          "phone": "13800138000"
        };

      logout(user.id).then(response => {
        console.log("查询Id");
        console.log(response);
      });
//      test(user).then(response => {
//        console.log(response);
//      });
      findAll().then(response => {
        console.log(response);
      });

//      selectName(user.name).then(response =>{
//        console.log("姓名");
//        console.log(response);
//      });
    },
    mounted() {

    },
    methods: {
      newUser(){
        this.dialogUser = true;
      },
      saveUser(){

      },
      cancel(){

      }
    }
  }


</script>

<style rel="stylesheet/scss" scoped>
  .el-main {
    -webkit-box-flex: 1;
    -ms-flex: 1;
    flex: 1;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    padding: 0px 10px 0px 10px;
  }

  .el-aside {
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    background-color: silver;
    height: 552px;
  }

  .el-tree {
    background: transparent;
    color: #000000;
  }

  .el-tree-node__label {
    font-size: 16px;
  }

  .left {
    float: left;
    margin: 5px;
  }
   .form-right {
    width:50%;
  }
   .form-left {
    width:50%;
  }



</style>
