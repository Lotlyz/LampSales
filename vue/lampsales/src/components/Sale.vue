<template>
  <div class="order">
    <h1>销售订单</h1>
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
      <el-button type="success" @click="queryAll">查询所有的订单</el-button>
      <!-- <el-button type="primary" @click="dialogFormVisible = true"
        >添加灯具</el-button
      > -->
    </div>

    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column label="订单编号">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.saleId }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="用户名字">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.userName }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="灯具型号">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampName }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="购买数量">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.buyCount }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="收货地址">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.address }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="总金额/元">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.totalMoney }}</span>
          </div>
        </template>
      </el-table-column>
      <!-- <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
            >修改</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
          >
            删除
          </el-button>
        </template>
      </el-table-column> -->
    </el-table>
  </div>
</template>

<script>
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
      tableData: [],
      value: ref("订单编号(Id)"),
      options: [
        {
          value: "saleId",
          label: "订单编号(Id)",
        },
        {
          value: "lampName",
          label: "灯具型号",
          disabled: true,
        },
        {
          value: "userName",
          label: "用户名字",
          disabled: true,
        },
      ],
    };
  },
  methods: {
    queryAll() {
      var that = this;
      axios
        .get("/api/sale/findAllVo")
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
        .get("/api/sale/findOne?saleId=" + this.input)
        .then(function (response) {
          console.log(response.data);
          that.tableData = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>

<style>
</style>