-- store.profiles definition

CREATE TABLE `tags` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255)
);

-- store.user_tags
CREATE TABLE `user_tags` (
  `user_id` BIGINT NOT NULL,
  `tag_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `tag_id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`) ON DELETE CASCADE
);
