function calculateDistance(array) {
    let [speedA, speedB, timeInSec] = array;
    let s1 = speedA * 1000 * (timeInSec / (60 * 60));
    let s2 = speedB * 1000 * (timeInSec / (60 * 60));
    console.log(Math.abs(s1 - s2));
}

calculateDistance([0, 60, 3600]);
calculateDistance([11, 10, 120]);
calculateDistance([5, -5, 40]);