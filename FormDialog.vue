<template>
    <el-dialog :title="isEdit ? '修改角色表': '新增角色表'" :visible.sync="open" v-if="open" @close="close">
        <div>
            <el-form ref="form" :model="form" :rules="rules" label-width="120px">

            </el-form>
        </div>
        <div slot="footer" class="dialog-footer">
            <el-button @click="open = false">取 消</el-button>
            <el-button type="primary" :loading="submitLoading" @click="submit">确 定</el-button>
        </div>
    </el-dialog>
</template>

<script>
    import { save, findDTOById, update } from '@/api/sys/sysRole'

    export default {
        data() {
            return {
                open: false,
                isEdit: false,
                form: {
                    name: '',
                    code: '',
                    description: ''
                },
                formLabelWidth: '120px',
                submitLoading: false,
                rules: {
                    name: [
                        { required: true, message: '请输入角色名称', trigger: 'blur' },
                        { min: 3, max: 32, message: '长度在 3 到 32 个字符', trigger: 'blur' }
                    ],
                    code: [
                        { required: true, message: '请输入角色代码', trigger: 'blur' },
                        { max: 32, message: '长度在 32 个字符以内', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            openDialog(isEdit, id) {
                this.isEdit = isEdit
                if (this.isEdit) {
                    findDTOById(id).then(response => {
                        this.form = response.data
                        this.open = true
                    })
                } else {
                    this.open = true
                }
            },
            submit() {
                this.$refs.form.validate((valid) => {
                    if (valid) {
                        this.submitLoading = true
                        if (this.isEdit) {
                            update(this.form).then(response => {
                                this.$emit('search')
                                this.open = false
                                this.submitLoading = false
                                this.$message({
                                    message: '修改成功',
                                    type: 'success'
                                })
                            }).catch(()=>{
                                this.submitLoading = false
                            })
                        } else {
                            save(this.form).then(response => {
                                this.$emit('search')
                                this.open = false
                                this.submitLoading = false
                                this.$message({
                                    message: '新增成功',
                                    type: 'success'
                                })
                            }).catch(()=>{
                                this.submitLoading = false
                            })
                        }
                    }
                })
            },
            close () {
                this.form = {}
            }
        }
    }
</script>

<style scoped>

</style>
