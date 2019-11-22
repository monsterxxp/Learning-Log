<template>
    <el-dialog :title="isEdit ? '修改${table_annotation}': '新增${table_annotation}'" :visible.sync="open" v-if="open" @close="close">
        <div>
            <el-form ref="form" :model="form" :rules="rules" label-width="120px">
                <#if model_column?exists>
                    <#list model_column as model>
                <el-row :gutter="20">
                    <el-col :span="11">
                        <el-form-item label="${model.columnComment!}" prop="${model.changeColumnName?uncap_first}">
                            <el-input v-model="form.${model.changeColumnName?uncap_first}" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="11">
                    </el-col>
                </el-row>
                    </#list>
                </#if>

            </el-form>
        </div>
        <div slot="footer" class="dialog-footer">
            <el-button @click="open = false">取 消</el-button>
            <el-button type="primary" :loading="submitLoading" @click="submit">确 定</el-button>
        </div>
    </el-dialog>
</template>

<script>
    import { save, findDTOById, update } from '@/api/sys/${table_name}'

    export default {
        data() {
            return {
                open: false,
                isEdit: false,
                form: {
                <#if model_column?exists>
                <#list model_column as model>
                ${model.changeColumnName?uncap_first}: '',
                </#list>
                </#if>
                },
                formLabelWidth: '120px',
                submitLoading: false,
                rules: {
                    <#if model_column?exists>
                    <#list model_column as model>
                    ${model.changeColumnName?uncap_first}: [
                        { required: true, message: '请输入${model.columnComment!}', trigger: 'blur' }
                    ],
                    </#list>
                    </#if>
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
