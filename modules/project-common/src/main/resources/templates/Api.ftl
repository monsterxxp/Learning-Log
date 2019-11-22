import request from '@/utils/request'

export function getList(params) {
    return request({
        url: '/${table_name?uncap_first}',
        method: 'get',
        params
    })
}

export function save(params) {
    return request({
        url: '/${table_name?uncap_first}',
        method: 'post',
        data: params
    })
}

export function findDTOById(id) {
    return request({
        url: `/${table_name?uncap_first}/${r'${id}'}`,
        method: 'get'
    })
}

export function update(params) {
    return request({
        url: `/${table_name?uncap_first}/${r'${params.id}'}`,
        method: 'put',
        data: params
    })
}

export function bulk(id) {
    return request({
        url: `/${table_name?uncap_first}/${r'${id}'}/bulk`,
        method: 'delete'
    })
}
