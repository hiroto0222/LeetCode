--
-- @lc app=leetcode id=1581 lang=mysql
--
-- [1581] Customer Who Visited but Did Not Make Any Transactions
--

-- @lc code=start
# Write your MySQL query statement below

-- return customer_id of those who visited without making transaction, cnt
-- left join on visits
-- group by customer_id -> cnt

SELECT customer_id, COUNT(customer_id) AS count_no_trans
FROM visits a
LEFT JOIN transactions b
ON b.visit_id = a.visit_id
WHERE transaction_id IS NULL
GROUP BY customer_id;

-- @lc code=end

