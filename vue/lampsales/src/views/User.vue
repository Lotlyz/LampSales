<template>
  <div class="user">
    <h1>用户中心</h1>
    <div class="demo-input-size">
      <el-input
        v-model="input"
        size="large"
        clearable
        placeholder="输入对应类型的数据"
        style="width: 360px"
      ></el-input>

      <el-select v-model="value" class="m-2" placeholder="Select" size="large">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
          :disabled="item.disabled"
        />
      </el-select>
      <el-button @click="queryOne">查询</el-button>
      <el-button type="success" @click="queryAll">查询所有的用户</el-button>
      <el-button type="primary" @click="dialogFormVisible = true"
        >添加用户</el-button
      >
    </div>
    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column label="Id">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.userId }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="名字">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.userName }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="手机号">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.userPhone }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="密码" prop="userPassword">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.userPassword }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="收货地址">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.userAdress }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
            >修改</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- InsertFormDialog -->
    <el-dialog v-model="dialogFormVisible" title="添加用户">
      <el-form :model="form">
        <el-form-item label="Id" :label-width="formLabelWidth">
          <el-input v-model="form.userId" autocomplete="off" />
        </el-form-item>
        <el-form-item label="名字" :label-width="formLabelWidth">
          <el-input v-model="form.userName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth">
          <el-input v-model="form.userPhone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.userPassword" autocomplete="off" />
        </el-form-item>
        <el-form-item label="收货地址" :label-width="formLabelWidth">
          <el-input v-model="form.userAdress" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="insert">确认</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- UpdateFormDialog -->
    <el-dialog v-model="updateDialogFormVisible" title="修改用户信息">
      <el-form :model="form">
        <el-form-item label="Id" :label-width="formLabelWidth">
          <el-input v-model="form.userId" autocomplete="off" />
        </el-form-item>
        <el-form-item label="名字" :label-width="formLabelWidth">
          <el-input v-model="form.userName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="手机号" :label-width="formLabelWidth">
          <el-input v-model="form.userPhone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.userPassword" autocomplete="off" />
        </el-form-item>
        <el-form-item label="收货地址" :label-width="formLabelWidth">
          <el-input v-model="form.userAdress" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="updateDialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="handleEditCommit">确认</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>


<script>
// @ is an alias to /src
import axios from "axios";
import { reactive, ref } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";
export default {
  mounted() {
    this.queryAll();
  },
  data() {
    return {
      input: ref(""),
      value: ref("用户编号(Id)"),
      options: [
        {
          value: "userId",
          label: "用户编号(Id)",
        },
        {
          value: "userName",
          label: "用户名字",
          disabled: true,
        },
        {
          value: "userPhone",
          label: "用户手机号",
          disabled: true,
        },
      ],
      // search: ref(""),
      tableData: [],

      dialogFormVisible: ref(false),
      updateDialogFormVisible: ref(false),
      formLabelWidth: "140px",

      form: {
        userId: "",
        userName: "",
        userPhone: "",
        userPassword: "",
        userAdress: "",
      },
    };
  },
  methods: {
    insert() {
      // var that = this;
      axios
        .post(
          "/api/user/insert?userId=" +
            this.form.userId +
            "&userName=" +
            this.form.userName +
            "&userPhone=" +
            this.form.userPhone +
            "&userPassword=" +
            this.form.userPassword +
            "&userAdress=" +
            this.form.userAdress
        )
        .then(function (response) {
          console.log(response);
          ElMessage({
            type: "success",
            message: "添加成功",
          });
        })
        .catch(function (error) {
          console.log(error);
        });
      this.dialogFormVisible = false;
      this.form.userId = "";
      this.form.userName = "";
      this.form.userPhone = "";
      this.form.userPassword = "";
      this.form.userAdress = "";
    },
    queryAll() {
      var that = this;
      axios
        .get("/api/user/findAll")
        .then(function (response) {
          console.log(response.data);
          that.tableData = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    queryOne() {
      var that = this;
      axios
        .get("/api/user/findOne?userId=" + this.input)
        .then(function (response) {
          console.log(response.data);
          that.tableData = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    handleEdit(index, row) {
      console.log(index, row);
      this.updateDialogFormVisible = true;
      this.form.userId = row.userId;
      this.form.userName = row.userName;
      this.form.userPhone = row.userPhone;
      this.form.userPassword = row.userPassword;
      this.form.userAdress = row.userAdress;
    },
    handleEditCommit() {
      axios
        .post(
          "/api/user/update?userId=" +
            this.form.userId +
            "&userName=" +
            this.form.userName +
            "&userPhone=" +
            this.form.userPhone +
            "&userPassword=" +
            this.form.userPassword +
            "&userAdress=" +
            this.form.userAdress
        )
        .then(function (response) {
          console.log(response.data);
          ElMessage({
            type: "success",
            message: "修改成功",
          });
        })
        .catch(function (error) {
          console.log(error);
        });
      this.updateDialogFormVisible = false;
      this.form.userId = "";
      this.form.userName = "";
      this.form.userPhone = "";
      this.form.userPassword = "";
      this.form.userAdress = "";
      location.reload();
    },
    handleDelete(index, row) {
      console.log(index, row);
      ElMessageBox.confirm("确定删除它吗？", {
        confirmButtonText: "删除",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          ElMessage({
            type: "success",
            message: "成功删除",
          });
          axios
            .get("/api/user/delete", {
              params: {
                userId: row.userId,
              },
            })
            .then(function (response) {
              console.log(response.data);
            })
            .catch(function (error) {
              console.log(error);
            });
          this.tableData.splice(index, 1);
        })
        .catch(() => {
          ElMessage({
            type: "info",
            message: "取消删除",
          });
        });
    },
  },
};
</script>
