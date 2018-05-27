#### 应用链接

http://127.0.0.1:8080/log/add


#### 建表语句

```
create table t_log_0(
id bigint(20) not NULL,
app_id bigint(20) not NULL,
title VARCHAR(255),
 primary key (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


create table t_log_1(
id bigint(20) not NULL,
app_id bigint(20) not NULL,
title VARCHAR(255),
 primary key (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

```