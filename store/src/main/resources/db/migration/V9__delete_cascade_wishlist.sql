alter table wishlist
drop foreign key wishlist_ibfk_1;

alter table wishlist
    add constraint wishlist_ibfk_1
        foreign key (user_id) references users (id)
            on delete cascade;