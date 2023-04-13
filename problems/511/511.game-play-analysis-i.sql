--
-- @lc app=leetcode id=511 lang=mysql
--
-- [511] Game Play Analysis I
--

-- @lc code=start
# Write your MySQL query statement below
# return first login date for each player

SELECT a.player_id, MIN(a.event_date) AS first_login
FROM activity a
GROUP BY player_id;

-- @lc code=end

