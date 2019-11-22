<template>
    <div class="app-container">
        <div class="list-top">
            <div class="search-group">
                <el-input v-model="defaultSearch.params.name" class="search-input-out" prefix-icon="el-icon-search" placeholder="请输入名称按回车进行搜索..." @keyup.enter.native="fetchData" />
                <el-button circle @click="openSearchBox">
                    <i class="el-icon-caret-bottom" title="查询更多" />
                </el-button>
            </div>
            <search-box ref="searchBox" @search="fetchData" @clearSearch="clearSearch">
                <#if model_column?exists>
                    <#list model_column as model>
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-row :gutter="20">
                            <el-col :span="6"><label class="search-label">${model.columnComment!}</label></el-col>
                            <el-col class="search-item-cell" :span="18"><el-input placeholder="请输入${model.columnComment!}" v-model="defaultSearch.params.${model.changeColumnName?uncap_first}"></el-input></el-col>
                        </el-row >
                    </el-col>
                </el-row>
                    </#list>
                </#if>
            </search-box>
            <div class="list-botton-group">
                <el-button @click="create">
                    <i class="el-icon-plus" title="新增" />
                </el-button>
                <!-- <el-button @click="batchBulk">
                  <i class="el-icon-delete" title="批量删除" />
                </el-button> -->
            </div>
        </div>
        <el-table
                v-loading="listLoading"
                :data="list"
                element-loading-text="Loading"
                @selection-change="selectChange"
                border
                fit
                highlight-current-row
                @sort-change="orderSort"
        >
            <el-table-column
                    type="index"
                    width="35"
            />
                <#list model_column as model>
            <el-table-column align="center" label="${model.columnComment!}">
                <template slot-scope="scope">
                    <span :title="scope.row.${model.changeColumnName?uncap_first}">{{ scope.row.${model.changeColumnName?uncap_first} }}</span>
                </template>
            </el-table-column>
                </#list>

            <el-table-column align="center" label="操作" width="200">
                <template slot-scope="scope">
                    <i class="el-icon-edit operation" title="修改" @click="edit(scope.row.id)" />
                    <i class="el-icon-delete operation" title="删除" @click="remove(scope.row.id)"/>
                </template>
            </el-table-column>
        </el-table>

        <Pagination
                :total="total"
                :page="page"
                :limit="limit"
                @pagination="pageSearch"
        />

        <form-dialog ref="formDialog" @search="fetchData" />
    </div>
</template>

<script>
    import { getList, bulk } from '@/api/sys/${table_name}'
    import Pagination from '@/components/Pagination'
    import FormDialog from './dialog/FormDialog'

    export default {
        components: {
            Pagination,
            FormDialog
        },
        data() {
            return {
                showSearchBox: false,
                list: [],
                total: 0,
                page: 0,
                limit: 0,
                listLoading: true,
                defaultSearch: {
                    page: 1,
                    limit: 20,
                    params: {}
                },
            }
        },
        mounted() {
            this.fetchData()
        },
        methods: {
            fetchData() {
                this.listLoading = true
                getList(this.defaultSearch).then(response => {
                    this.list = response.data.records
                    this.total = response.data.total
                    this.page = response.data.current
                    this.limit = response.data.size
                    this.listLoading = false
                })
            },
            pageSearch(params) {
                if (params) {
                    this.defaultSearch.page = params.page
                    this.defaultSearch.limit = params.limit
                }
                this.fetchData()
            },
            orderSort(row) {
                this.defaultSearch.sortItem = row.prop
                this.defaultSearch.asc = row.order === 'ascending'
                this.fetchData()
            },
            clearSearch() {
                this.defaultSearch.params = {}
            },
            create() {
                this.$refs.formDialog.openDialog(false, null)
            },
            edit(id) {
                this.$refs.formDialog.openDialog(true, id)
            },
            openSearchBox () {
                this.$refs.searchBox.openDialog()
            },
            remove (id) {
                this.$confirm('是否删除该${table_annotation}?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    bulk(id).then(response => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        this.fetchData()
                    })
                })
            }
        }
    }
</script>
