<template>
  <div class="home">
    <el-carousel :interval="5000" arrow="always">
      <el-carousel-item v-for="item in 3" :key="item">
        <el-image
          style="width: 100%; height: 100%"
          :src="url"
          :fit="fit"
          @click="queryAll"
        />
      </el-carousel-item>
    </el-carousel>

    <el-table :data="tableData" stripe border style="width: 100%">
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
      <el-table-column label="价格/元">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampPrice }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="库存量/个">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <span style="margin-left: 1px">{{ scope.row.lampInventory }}</span>
          </div>
        </template>
      </el-table-column>
      <!-- <el-table-column label="购买数量">
          <el-input-number v-model="num" :min="1" :max="10" @change="handleChange"></el-input-number>
      </el-table-column> -->
      <el-table-column label="操作">
        <template #default="scope">
          <el-button
          type="success"
            size="small"
            @click="handleBuyCount(scope.$index, scope.row)"
            >购买</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- InsertFormDialog -->
    <el-dialog v-model="dialogFormVisible" title="购买灯具">
      <el-form :model="form">
        <el-form-item label="请输入您的Id" :label-width="formLabelWidth">
          <el-input v-model="form.userId" autocomplete="off" />
        </el-form-item>
        <el-form-item label="您要购买的灯具Id" :label-width="formLabelWidth">
          <el-input v-model="form.lampId" disabled autocomplete="off" />
        </el-form-item>
        <el-form-item label="您的购买数量" :label-width="formLabelWidth">
          <el-input v-model="form.buyCount" disabled autocomplete="off" />
        </el-form-item>
        <el-form-item label="请输入您的收货地址" :label-width="formLabelWidth">
          <el-input v-model="form.address" autocomplete="off" />
        </el-form-item>
        <!-- <el-form-item label="总金额" :label-width="formLabelWidth">
          <el-input v-model="form.totalMoney" autocomplete="off" />
        </el-form-item> -->
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click="handleBuyCommit">下单</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- BuyCountFormDialog -->
    <el-dialog v-model="countDialog" title="购买的数量">
      <h1>您想买多少呢？</h1>
      <el-input-number
        v-model="num"
        :min="1"
        :max="99"
        @change="handleChange"
      />
      <h5>(数量一定要改变过才可以计算价格)</h5>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="countDialog = false">取消</el-button>
          <el-button type="primary" @click="handleBuy()">好的</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- BuyMoneyFormDialog -->
    <el-dialog v-model="moneyDialog" title="请支付如下金额">
      <el-form :model="form">
        <el-form-item label="总金额:(/元)" :label-width="formLabelWidth">
          <el-input v-model="form.totalMoney" disabled autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="moneyDialog = false">取消</el-button>
          <el-button type="primary" @click="handleThanks">支付</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- BuyMoneyFormDialog -->
    <el-dialog v-model="thanksDialog" title="欢迎下次光临">
      <h1>支付成功！感谢您的支持！</h1>
      <template #footer>
        <span class="dialog-footer">
          <!-- <el-button @click="thanksDialog = false">取消</el-button> -->
          <el-button type="primary" @click="thanksDialog = false"
            >好的</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
import { ref } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";
export default {
  mounted() {
    this.queryAll();
  },
  data() {
    return {
      input: ref(""),
      tableData: [],
      dialogFormVisible: ref(false),
      countDialog: ref(false),
      moneyDialog: ref(false),
      thanksDialog: ref(false),
      formLabelWidth: "140px",
      num: ref(1),
      form: {
        saleId: "",
        userId: "",
        lampId: "",
        buyCount: "",
        address: "",
        totalMoney: "",
        price: "",
      },
      currentDate: ref(new Date()),
      fits: ["fill"],
      url: "https://lotlyzbolg.oss-cn-shenzhen.aliyuncs.com/img/1a431258d20a3ccfecc24fbf9d04a672.jpeg",
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
    handleBuyCount(index, row) {
      // this.dialogFormVisible = false;

      // console.log(this.totalMoney);
      // this.totalMoney = this.form.totalMoney;
      this.form.lampId = row.lampId;
      this.form.price = row.lampPrice;
      this.countDialog = true;
    },
    handleChange(value) {
      console.log(value);
      this.form.buyCount = value;
      // console.log("当前数量为"+this.form.buyCount)
      this.form.totalMoney = this.form.price * this.form.buyCount;
      // console.log("当前数量为"+this.form.totalMoney)
    },
    handleBuy() {
      // console.log(row.lampId);
      // this.totalMoney = this.form.price*this.form.buyCount;
      this.countDialog = false;
      this.dialogFormVisible = true;
      console.log("总金额为：" + this.totalMoney);
      // this.form.lampId = row.lampId;
      // var price = row.lampPrice;
      // var count = this.form.buyCount;
      // console.log("购买的灯的价格为：" + price);
      // console.log("购买的数量为：" + count);
      // this.totalMoney = count * price;
      // console.log(this.totalMoney);
    },
    handleBuyCommit() {
      // this.totalMoney = this.form.price * this.num;
      console.log("总金额为：" + this.totalMoney);
      this.dialogFormVisible = false;
      this.moneyDialog = true;
    },
    handleThanks() {
      axios
        .post(
          "/api/sale/insert?userId=" +
            this.form.userId +
            "&lampId=" +
            this.form.lampId +
            "&buyCount=" +
            this.form.buyCount +
            "&address=" +
            this.form.address +
            "&totalMoney=" +
            this.form.totalMoney
        )
        .then(function (response) {
          console.log(response);
          ElMessage({
            type: "success",
            message: "购买成功",
          });
        })
        .catch(function (error) {
          console.log(error);
        });
      this.moneyDialog = false;

      this.thanksDialog = true;
      this.num = 1;
      this.form.userId = "";
      (this.form.buyCount = ""), (this.form.address = "");
    },
  },
};
</script>


<style>
.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}

.image {
  width: 100%;
  display: block;
}
</style>


