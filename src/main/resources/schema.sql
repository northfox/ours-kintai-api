create table if not exists kintai_user
(
    id         int                  not null auto_increment,
    name       varchar(4000) unique not null,
    created_at timestamp            not null default now(),
    created_by varchar(100),
    updated_at timestamp            not null default now(),
    updated_by varchar(100),
    deleted_at timestamp,
    deleted_by varchar(100)
);

create table if not exists kintai_time
(
    id         int                  not null auto_increment,
    category   varchar(4000) not null,
    in_time    timestamp,
    out_time   timestamp,
    user_id    int references kintai_user (id),
    created_at timestamp            not null default now(),
    created_by varchar(100),
    updated_at timestamp            not null default now(),
    updated_by varchar(100),
    deleted_at timestamp,
    deleted_by varchar(100)
);
