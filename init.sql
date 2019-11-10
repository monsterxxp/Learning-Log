create table sys_user
(
    id           varchar(32) not null
        constraint sys_user_pk
            primary key,
    name         varchar(32),
    account      varchar(32),
    password     varchar(32),
    created_time timestamp,
    updated_time timestamp,
    status       varchar(2),
    sex          varchar(2),
    mobile       varchar(32),
    email        varchar(64),
    dept_id      varchar(32),
    description  varchar(255),
    post_id      varchar(32)
);

comment on table sys_user is '系统用户';

comment on column sys_user.id is '主键ID';

comment on column sys_user.name is '姓名';

comment on column sys_user.account is '账号';

comment on column sys_user.password is '密码';

comment on column sys_user.created_time is '创建时间';

comment on column sys_user.updated_time is '更新时间';

comment on column sys_user.status is '用户状态';

comment on column sys_user.sex is '性别';

comment on column sys_user.mobile is '手机';

comment on column sys_user.email is '邮箱';

comment on column sys_user.dept_id is '所属部门';

comment on column sys_user.description is '描述';

comment on column sys_user.post_id is '岗位';

alter table sys_user
    owner to postgres;

create table sys_role
(
    id           varchar(32) not null
        constraint sys_role_pk
            primary key,
    name         varchar(32),
    description  varchar(255),
    created_time timestamp(6),
    updatd_time  timestamp(6),
    code         varchar(32)
);

comment on table sys_role is '角色表';

comment on column sys_role.id is '主键ID';

comment on column sys_role.name is '角色名称';

comment on column sys_role.description is '说明';

alter table sys_role
    owner to postgres;

create table sys_role_user
(
    id      varchar(32) not null
        constraint sys_role_user_pk
            primary key,
    role_id varchar(32),
    user_id varchar(32)
);

alter table sys_role_user
    owner to postgres;

create table sys_permission
(
    id           varchar(32) not null
        constraint sys_permission_pk
            primary key,
    name         varchar(32),
    code         varchar(32),
    description  varchar(255),
    created_time timestamp(6),
    updated_time timestamp(6)
);

alter table sys_permission
    owner to postgres;

create table sys_role_permission
(
    id            varchar(32) not null
        constraint sys_role_permission_pk
            primary key,
    role_id       varchar(32),
    permission_id varchar(32)
);

alter table sys_role_permission
    owner to postgres;

create table sys_dict_category
(
    id           varchar(32) not null
        constraint sys_dict_category_pk
            primary key,
    code         varchar(32),
    name         varchar(32),
    created_time timestamp,
    updated_time timestamp,
    status       varchar(2),
    is_update    varchar(2),
    created_id   varchar(32),
    updated_id   varchar(32),
    description  varchar(255)
);

alter table sys_dict_category
    owner to postgres;

create table sys_dict
(
    id            varchar(32) not null
        constraint sys_dict_pk
            primary key,
    code          varchar(32),
    name          varchar(32),
    category_code varchar(32),
    created_id    varchar(32),
    created_time  timestamp,
    updated_id    varchar(32),
    updated_time  timestamp,
    status        varchar(2),
    is_update     varchar(2),
    sort          integer,
    parent_id     varchar(32)
);

alter table sys_dict
    owner to postgres;

INSERT INTO public.sys_user (id, name, account, password, created_time, updated_time, status, sex, mobile, email, dept_id, description, post_id) VALUES ('1', '靓仔兼有型', 'smallking', '1', '2019-08-22 22:45:19.000000', '2019-08-22 22:45:23.000000', '1', null, null, null, null, null, null);