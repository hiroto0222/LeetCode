#
# @lc app=leetcode id=1603 lang=python3
#
# [1603] Design Parking System
#


# @lc code=start
class ParkingSystem:
    def __init__(self, big: int, medium: int, small: int):
        """
        carType 1 -> big, 2 -> medium, 3 -> small
        """
        self.parking_slots = {1: big, 2: medium, 3: small}

    def addCar(self, carType: int) -> bool:
        if self.parking_slots[carType] <= 0:
            return False

        self.parking_slots[carType] -= 1
        return True


# Your ParkingSystem object will be instantiated and called as such:
# obj = ParkingSystem(big, medium, small)
# param_1 = obj.addCar(carType)
# @lc code=end
