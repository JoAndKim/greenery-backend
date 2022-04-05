SET foreign_key_checks = 0;
DROP TABLE IF EXISTS comment CASCADE;
DROP TABLE IF EXISTS member CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS like_number CASCADE;
DROP TABLE IF EXISTS post_content CASCADE;
SET foreign_key_checks = 1;

create table comment
(
    id        bigint                              not null
        primary key,
    content   varchar(255)                        null,
    group_id  bigint                              null,
    level     int                                 null,
    reg_date  timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    member_id bigint                              null,
    post_id   bigint                              null

);

create index fk_comment_author
    on comment (member_id);

create index fk_comment
    on comment (post_id);


create table member
(
    id                bigint       not null
        primary key,
    email             varchar(255) null,
    password          varchar(255) null,
    profile_image_url varchar(255) null,
    username          varchar(255) null
);

create table post
(
    id           bigint                              not null primary key,
    hits         int                                 null,
    like_numbers int                                 null,
    reg_date     timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    title        varchar(255)                        null,
    member_id    bigint                              null,
    constraint fk_post_author
        foreign key (member_id) references member (id)
);

create table like_number
(
    id        bigint not null
        primary key,
    member_id bigint null,
    post_id   bigint null,
    constraint fk_like_member
        foreign key (member_id) references member (id),
    constraint fk_like_post
        foreign key (post_id) references post (id)
);

create table post_content
(
    id             bigint       not null
        primary key,
    content        longtext null,
    post_image_url varchar(255) null,
    post_id        bigint       null,
    constraint fk_post_content
        foreign key (post_id) references post (id)
);

alter table comment
    add constraint fk_comment
        foreign key (post_id) references post (id),
    add constraint fk_comment_author
        foreign key (member_id) references member (id)
