<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="游戏id" prop="gameId">
      <el-input v-model="dataForm.gameId" placeholder="游戏id"></el-input>
    </el-form-item>
    <el-form-item label="活动名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="活动名称"></el-input>
    </el-form-item>
    <el-form-item label="开始时间" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder="开始时间"></el-input>
    </el-form-item>
    <el-form-item label="结束时间" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="结束时间"></el-input>
    </el-form-item>
    <el-form-item label="平台code" prop="platformCode">
      <el-input v-model="dataForm.platformCode" placeholder="平台code"></el-input>
    </el-form-item>
    <el-form-item label="类目id" prop="categoryId">
      <el-input v-model="dataForm.categoryId" placeholder="类目id"></el-input>
    </el-form-item>
    <el-form-item label="图片地址" prop="imgUrl">
      <el-input v-model="dataForm.imgUrl" placeholder="图片地址"></el-input>
    </el-form-item>
    <el-form-item label="详情地址" prop="detailUrl">
      <el-input v-model="dataForm.detailUrl" placeholder="详情地址"></el-input>
    </el-form-item>
    <el-form-item label="活动地址" prop="eventUrl">
      <el-input v-model="dataForm.eventUrl" placeholder="活动地址"></el-input>
    </el-form-item>
    <el-form-item label="提示" prop="tip">
      <el-input v-model="dataForm.tip" placeholder="提示"></el-input>
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
          gameId: '',
          name: '',
          startTime: '',
          endTime: '',
          platformCode: '',
          categoryId: '',
          imgUrl: '',
          detailUrl: '',
          eventUrl: '',
          tip: ''
        },
        dataRule: {
          gameId: [
            { required: true, message: '游戏id不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '活动名称不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '开始时间不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '结束时间不能为空', trigger: 'blur' }
          ],
          platformCode: [
            { required: true, message: '平台code不能为空', trigger: 'blur' }
          ],
          categoryId: [
            { required: true, message: '类目id不能为空', trigger: 'blur' }
          ],
          imgUrl: [
            { required: true, message: '图片地址不能为空', trigger: 'blur' }
          ],
          detailUrl: [
            { required: true, message: '详情地址不能为空', trigger: 'blur' }
          ],
          eventUrl: [
            { required: true, message: '活动地址不能为空', trigger: 'blur' }
          ],
          tip: [
            { required: true, message: '提示不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/calendar/calendarevent/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.gameId = data.calendarEvent.gameId
                this.dataForm.name = data.calendarEvent.name
                this.dataForm.startTime = data.calendarEvent.startTime
                this.dataForm.endTime = data.calendarEvent.endTime
                this.dataForm.platformCode = data.calendarEvent.platformCode
                this.dataForm.categoryId = data.calendarEvent.categoryId
                this.dataForm.imgUrl = data.calendarEvent.imgUrl
                this.dataForm.detailUrl = data.calendarEvent.detailUrl
                this.dataForm.eventUrl = data.calendarEvent.eventUrl
                this.dataForm.tip = data.calendarEvent.tip
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
              url: this.$http.adornUrl(`/calendar/calendarevent/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'gameId': this.dataForm.gameId,
                'name': this.dataForm.name,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'platformCode': this.dataForm.platformCode,
                'categoryId': this.dataForm.categoryId,
                'imgUrl': this.dataForm.imgUrl,
                'detailUrl': this.dataForm.detailUrl,
                'eventUrl': this.dataForm.eventUrl,
                'tip': this.dataForm.tip
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
