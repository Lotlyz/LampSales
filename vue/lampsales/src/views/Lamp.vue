<template>
  <div class="lamp">
    <h1>灯具管理</h1>
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
      <el-button type="success" @click="queryAll">查询所有的灯具</el-button>
      <el-button type="primary" @click="dialogFormVisible = true"
        >添加灯具</el-button
      >
    </div>

    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column label="Id">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampId }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="型号">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampName }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="品牌">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampBrand }}</span>
          </div>
        </template>
      </el-table-column>

      <el-table-column label="电压">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampPower }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="价格">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampPrice }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="库存量">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampInventory }}</span>
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
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- InsertFormDialog -->
    <el-dialog v-model="dialogFormVisible" title="添加灯具">
      <el-form :model="form">
        <el-form-item label="Id" :label-width="formLabelWidth">
          <el-input v-model="form.lampId" autocomplete="off" />
        </el-form-item>
        <el-form-item label="型号" :label-width="formLabelWidth">
          <el-input v-model="form.lampName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="品牌" :label-width="formLabelWidth">
          <el-input v-model="form.lampBrand" autocomplete="off" />
        </el-form-item>
        <el-form-item label="电压" :label-width="formLabelWidth">
          <el-input v-model="form.lampPower" autocomplete="off" />
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth">
          <el-input v-model="form.lampPrice" autocomplete="off" />
        </el-form-item>
        <el-form-item label="库存量" :label-width="formLabelWidth">
          <el-input v-model="form.lampInventory" autocomplete="off" />
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
    <el-dialog v-model="updateDialogFormVisible" title="修改灯具信息">
      <el-form :model="form">
        <el-form-item label="Id" :label-width="formLabelWidth">
          <el-input v-model="form.lampId" autocomplete="off" />
        </el-form-item>
        <el-form-item label="型号" :label-width="formLabelWidth">
          <el-input v-model="form.lampName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="品牌" :label-width="formLabelWidth">
          <el-input v-model="form.lampBrand" autocomplete="off" />
        </el-form-item>
        <el-form-item label="电压" :label-width="formLabelWidth">
          <el-input v-model="form.lampPower" autocomplete="off" />
        </el-form-item>
        <el-form-item label="价格" :label-width="formLabelWidth">
          <el-input v-model="form.lampPrice" autocomplete="off" />
        </el-form-item>
        <el-form-item label="库存量" :label-width="formLabelWidth">
          <el-input v-model="form.lampInventory" autocomplete="off" />
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

      value: ref("灯具编号(Id)"),
      options: [
        {
          value: "userId",
          label: "灯具编号(Id)",
        },
        {
          value: "userName",
          label: "型号",
          disabled: true,
        },
        {
          value: "userPhone",
          label: "品牌",
          disabled: true,
        },
      ],
      dialogFormVisible: ref(false),
      updateDialogFormVisible: ref(false),
      formLabelWidth: "140px",
      form: {
        lampId: "",
        lampName: "",
        lampBrand: "",
        lampPower: "",
        lampPrice: "",
        lampInventory: "",
      },
    };
  },
  methods: {
    queryAll() {
      var that = this;
      axios
        .get("/api/lamp/findAll")
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
        .get("/api/lamp/findOne?lampId=" + this.input)
        .then(function (response) {
          console.log(response.data);
          that.tableData = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    insert() {
      axios
        .post(
          "/api/lamp/insert?lampId=" +
            this.form.lampId +
            "&lampName=" +
            this.form.lampName +
            "&lampBrand=" +
            this.form.lampBrand +
            "&lampPower=" +
            this.form.lampPower +
            "&lampPrice=" +
            this.form.lampPrice +
            "&lampInventory=" +
            this.form.lampInventory
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
      this.form.lampId = "";
      this.form.lampName = "";
      this.form.lampBrand = "";
      this.form.lampPower = "";
      this.form.lampPrice = "";
      this.form.lampInventory = "";
      // queryAll();
    },
    handleEdit(index, row) {
      console.log(row.lampId);
      this.updateDialogFormVisible = true;
      this.form.lampId = row.lampId;
      this.form.lampName = row.lampName;
      this.form.lampBrand = row.lampBrand;
      this.form.lampPower = row.lampPower;
      this.form.lampPrice = row.lampPrice;
      this.form.lampInventory = row.lampInventory;
    },
    handleEditCommit() {
      axios
        .post(
          "/api/lamp/update?lampId=" +
            this.form.lampId +
            "&lampName=" +
            this.form.lampName +
            "&lampBrand=" +
            this.form.lampBrand +
            "&lampPower=" +
            this.form.lampPower +
            "&lampPrice=" +
            this.form.lampPrice +
            "&lampInventory=" +
            this.form.lampInventory
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
      // this.queryAll();

      this.updateDialogFormVisible = false;
      this.form.lampId = "";
      this.form.lampName = "";
      this.form.lampBrand = "";
      this.form.lampPower = "";
      this.form.lampPrice = "";
      this.form.lampInventory = "";
      location.reload();
    },
    handleDelete(index, row) {
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
            .get("/api/lamp/delete", {
              params: {
                lampId: row.lampId,
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


