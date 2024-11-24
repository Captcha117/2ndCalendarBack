<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="版本名 1.0.0" prop="name">
      <el-input v-model="dataForm.name" placeholder="版本名 1.0.0"></el-input>
    </el-form-item>
    <el-form-item label="版本描述" prop="desc">
      <el-input v-model="dataForm.desc" placeholder="版本描述"></el-input>
    </el-form-item>
    <el-form-item label="版本下载url" prop="downloadUrl">
      <el-input v-model="dataForm.downloadUrl" placeholder="版本下载url"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
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
          name: '',
          desc: '',
          downloadUrl: '',
          updateTime: ''
        },
        dataRule: {
          name: [
            { required: true, message: '版本名 1.0.0不能为空', trigger: 'blur' }
          ],
          desc: [
            { required: true, message: '版本描述不能为空', trigger: 'blur' }
          ],
          downloadUrl: [
            { required: true, message: '版本下载url不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/calendar/calendarversion/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.calendarVersion.name
                this.dataForm.desc = data.calendarVersion.desc
                this.dataForm.downloadUrl = data.calendarVersion.downloadUrl
                this.dataForm.updateTime = data.calendarVersion.updateTime
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
              url: this.$http.adornUrl(`/calendar/calendarversion/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'desc': this.dataForm.desc,
                'downloadUrl': this.dataForm.downloadUrl,
                'updateTime': this.dataForm.updateTime
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
