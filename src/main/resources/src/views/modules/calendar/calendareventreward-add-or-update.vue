<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="活动id" prop="eventId">
      <el-input v-model="dataForm.eventId" placeholder="活动id"></el-input>
    </el-form-item>
    <el-form-item label="奖励code" prop="rewardCode">
      <el-input v-model="dataForm.rewardCode" placeholder="奖励code"></el-input>
    </el-form-item>
    <el-form-item label="奖励数量" prop="rewardNum">
      <el-input v-model="dataForm.rewardNum" placeholder="奖励数量"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          eventId: '',
          rewardCode: '',
          rewardNum: ''
        },
        dataRule: {
          eventId: [
            { required: true, message: '活动id不能为空', trigger: 'blur' }
          ],
          rewardCode: [
            { required: true, message: '奖励code不能为空', trigger: 'blur' }
          ],
          rewardNum: [
            { required: true, message: '奖励数量不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/calendar/calendareventreward/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.eventId = data.calendarEventReward.eventId
                this.dataForm.rewardCode = data.calendarEventReward.rewardCode
                this.dataForm.rewardNum = data.calendarEventReward.rewardNum
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/calendar/calendareventreward/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'eventId': this.dataForm.eventId,
                'rewardCode': this.dataForm.rewardCode,
                'rewardNum': this.dataForm.rewardNum
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
