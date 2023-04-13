--
-- @lc app=leetcode id=183 lang=mysql
--
-- [183] Customers Who Never Order
--

-- @lc code=start
# Write your MySQL query statement below

-- return all customers who have no orders
SELECT name AS Customers
FROM customers
WHERE NOT EXISTS (
  SELECT customerId
  FROM orders
  WHERE customerId = customers.id
);

-- @lc code=end

