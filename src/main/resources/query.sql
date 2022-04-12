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
) character set = utf8mb4;

insert into `greenery`.post (id, hits, like_numbers, title, member_id)
values (1, 5, 7, 'hell world', 1);

create table `greenery`.like_number
(
    id        bigint not null
        primary key,
    member_id bigint null,
    post_id   bigint null
) character set = utf8mb4;

create table `greenery`.post_content
(
    id             bigint       not null
        primary key,
    content        longtext     null,
    post_image_url varchar(255) null,
    post_id        bigint       null
) character set = utf8mb4;

insert into `greenery`.post_content (id, content, post_image_url, post_id)
values (1, '안녕하세요 헬로로', 'https://contents.lotteon.com/itemimage/_v000249/LO/15/32/55/97/16/_1/53/25/59/71/7/LO1532559716_1532559717_1.jpg/dims/optimize/dims/resizemc/400x400', 1);

create table `greenery`.member
(
    id                bigint       not null
        primary key,
    email             varchar(255) null,
    password          varchar(255) null,
    profile_image_url varchar(255) null,
    username          varchar(255) null
) character set = utf8mb4;

insert into `greenery`.member (id, email, password, profile_image_url, username)
values (1, 'iamscvv@gmail.com', '$2a$10$pUOkbjxQXSfHWO.ZFfQcXevGIyFxm01iiWZN1rjXMLzhFsUj7YZmW', 'https://avatars.githubusercontent.com/u/59721293?v=4', 'kyupid');
