--
-- @lc app=leetcode id=1084 lang=mysql
--
-- [1084] Sales Analysis III
--

-- @lc code=start
# Write your MySQL query statement below
# report products that were only sold between 2019-01-01 and 2019-03-31
# return product_id, product_name
# group by product_id and check min sale_date and max sale_date is between

SELECT p.product_id, p.product_name
FROM product p
INNER JOIN sales s USING(product_id)
GROUP BY p.product_id
HAVING MIN(s.sale_date) >= '2019-01-01' AND MAX(s.sale_date) <= '2019-03-31';

-- @lc code=end

