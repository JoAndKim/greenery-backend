DROP TABLE IF EXISTS `greenery`.comment;
DROP TABLE IF EXISTS `greenery`.member;
DROP TABLE IF EXISTS `greenery`.post;
DROP TABLE IF EXISTS `greenery`.like_number;
DROP TABLE IF EXISTS `greenery`.post_content;

create table `greenery`.comment
(
    id        bigint                              not null
        primary key,
    content   varchar(255)                        null,
    group_id  bigint                              null,
    level     int                                 null,
    reg_date  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    member_id bigint                              null,
    post_id   bigint                              null
) character set = utf8mb4;



create table `greenery`.post
(
    id           bigint                              not null primary key,
    hits         int                                 null,
    like_numbers int                                 null,
    reg_date     timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    title        varchar(255)                        null,
    member_id    bigint                              null
) character set = utf8mb4;;

create table `greenery`.like_number
(
    id        bigint not null
        primary key,
    member_id bigint null,
    post_id   bigint null
) character set = utf8mb4;;

create table `greenery`.post_content
(
    id             bigint       not null
        primary key,
    content        longtext     null,
    post_image_url varchar(255) null,
    post_id        bigint       null
) character set = utf8mb4;;

create table `greenery`.member
(
    id                bigint       not null
        primary key,
    email             varchar(255) null,
    password          varchar(255) null,
    profile_image_url varchar(255) null,
    username          varchar(255) null
) character set = utf8mb4;;
