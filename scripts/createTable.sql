/*
drop table worker;
drop table system_log;
*/

create table worker (
    id           bigint        not null,
	create_at    bigint        not null,
	worker_id    int           not null,
	worker_name  varchar(50)   not null,
	cpu_usage     varchar(1000) not null,
	ram_usage     varchar(1000) not null,
	vmem_usage    varchar(1000) not null,
	gpu_usage     varchar(1000),
	constraint pk_worker primary key (create_at,worker_id)
) ENGINE=innodb
partition by range(create_at) (
    partition p20210901 values less than (UNIX_TIMESTAMP('2021-09-01 00:00:00')*1000),
    partition p20211001 values less than (UNIX_TIMESTAMP('2021-10-01 00:00:00')*1000),
    partition p20211101 values less than (UNIX_TIMESTAMP('2021-11-01 00:00:00')*1000),
    partition pMax values less than maxvalue
);


create table system_log (
    id           bigint        not null,
	create_at    bigint        not null,
    admin_id     varchar(50)   not null,
	result_code   int           not null,
	result_msg    varchar(200)  not null,
	error_count   int           not null,
	constraint pk_system_log primary key (create_at,admin_id)
) ENGINE=innodb
partition by range(create_at) (
    partition p20210901 values less than (UNIX_TIMESTAMP('2021-09-01 00:00:00')*1000),
    partition p20211001 values less than (UNIX_TIMESTAMP('2021-10-01 00:00:00')*1000),
    partition p20211101 values less than (UNIX_TIMESTAMP('2021-11-01 00:00:00')*1000),
    partition pMax values less than maxvalue
);



