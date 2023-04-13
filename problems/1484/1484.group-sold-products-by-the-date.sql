--
-- @lc app=leetcode id=1484 lang=mysql
--
-- [1484] Group Sold Products By The Date
--

-- @lc code=start
# Write your MySQL query statement below

-- 1. group by sell_date
-- 2. count only distinct products
-- 3. list all products for each date
-- 4. order by sell_date

SELECT sell_date,
       COUNT(DISTINCT product) AS num_sold,
       GROUP_CONCAT(
        DISTINCT product
        ORDER BY product
        SEPARATOR ','
       ) AS products
FROM activities
GROUP BY sell_date
ORDER BY sell_date;

-- @lc code=end

