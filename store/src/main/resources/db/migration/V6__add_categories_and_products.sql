-- store.categories definition

CREATE TABLE `categories` (
  `id` tinyint PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255)
);

-- store.products
CREATE TABLE `products` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255),
  `price` DECIMAL(10, 2),
  `category_id` TINYINT,
  CONSTRAINT `fk_category`
   FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE RESTRICT
);
