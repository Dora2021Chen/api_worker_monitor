/*
drop table if exists worker;
drop table if exists system_log;
drop table if exists hibernate_sequence;
*/

create table worker (
    id            bigint        not null, #--when using jdbc to access database, this column is unnecessary
	create_at     bigint        not null,
	worker_id     int           not null,
	access_code   int           not null, #-- a number is increased in range(0,100000) to make (create_at,worker_id,access_code) unique
	worker_name   varchar(50)   not null,
	cpu_usage     varchar(1000) not null,
	ram_usage     varchar(1000) not null,
	vmem_usage    varchar(1000) not null,
	gpu_usage     varchar(1000),
	constraint pk_worker primary key (create_at,access_code,worker_id)
) ENGINE=innodb
partition by range(create_at) (
    partition p20210901 values less than (UNIX_TIMESTAMP('2021-09-01 00:00:00')*1000),
    partition p20211001 values less than (UNIX_TIMESTAMP('2021-10-01 00:00:00')*1000),
    partition p20211101 values less than (UNIX_TIMESTAMP('2021-11-01 00:00:00')*1000),
    partition pMax values less than maxvalue
);


create table system_log (
    id            bigint        not null, #--when using jdbc to access database, this column is unnecessary
	create_at     bigint        not null,
    admin_id      varchar(50)   not null,
	access_code   int           not null, #-- a number is increased in range(0,100000) to make (create_at,admin_id,access_code) unique
	result_code   int           not null,
	result_msg    varchar(200)  not null,
	error_count   int           not null,
	constraint pk_system_log primary key (create_at,access_code,admin_id)
) ENGINE=innodb
partition by range(create_at) (
    partition p20210901 values less than (UNIX_TIMESTAMP('2021-09-01 00:00:00')*1000),
    partition p20211001 values less than (UNIX_TIMESTAMP('2021-10-01 00:00:00')*1000),
    partition p20211101 values less than (UNIX_TIMESTAMP('2021-11-01 00:00:00')*1000),
    partition pMax values less than maxvalue
);

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


#--populate the table,to tell the program library from which number to start the auto-generation id.
INSERT INTO hibernate_sequence (next_val) VALUES (0);

