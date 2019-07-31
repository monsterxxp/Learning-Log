create table sys_user
(
    id          varchar(32) not null
        constraint sys_user_pk
            primary key,
    name        varchar(32),
    account     varchar(32),
    password    varchar(32),
    create_time timestamp,
    update_time timestamp,
    status      varchar(2)
);

comment on table sys_user is '系统用户';

comment on column sys_user.id is '主键ID';

comment on column sys_user.name is '姓名';

comment on column sys_user.account is '账号';

comment on column sys_user.password is '密码';

comment on column sys_user.create_time is '创建时间';

comment on column sys_user.update_time is '更新时间';

comment on column sys_user.status is '用户状态';

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
