--
-- @lc app=leetcode id=1393 lang=mysql
--
-- [1393] Capital Gain/Loss
--

-- @lc code=start
# Write your MySQL query statement below
SELECT
    stock_name,
    SUM(IF(operation = "Buy", -price, price)) AS capital_gain_loss
FROM Stocks
GROUP BY stock_name;

-- @lc code=end

