--
-- @lc app=leetcode id=1757 lang=mysql
--
-- [1757] Recyclable and Low Fat Products
--

-- @lc code=start
# Write your MySQL query statement below

-- return both low fat and recyclable

SELECT product_id
FROM products
WHERE low_fats = true AND recyclable = true;

-- @lc code=end

