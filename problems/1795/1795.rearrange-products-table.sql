--
-- @lc app=leetcode id=1795 lang=mysql
--
-- [1795] Rearrange Products Table
--

-- @lc code=start
# Write your MySQL query statement below

-- 1. return product_id, store, price
-- 2. if price is null, dont include

SELECT
  product_id,
  'store1' AS store,
  store1 AS price
FROM products
WHERE store1 IS NOT NULL

UNION

SELECT
  product_id,
  'store2' AS store,
  store2 AS price
FROM products
WHERE store2 IS NOT NULL

UNION

SELECT
  product_id,
  'store3' AS store,
  store3 AS price
FROM products
WHERE store3 IS NOT NULL;

-- @lc code=end

