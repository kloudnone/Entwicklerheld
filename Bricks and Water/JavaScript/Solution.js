export function bricksAndWater(bricksArray) {
    let res = 0;
    for (let i in bricksArray) {
        for (let j = i; j <= bricksArray.length; j++) {
            for (let k = i; k <= j; k++) {
                if (bricksArray[k] < bricksArray[i] && bricksArray[k] < bricksArray[j]) {
                    let minValue = Math.min(bricksArray[i], bricksArray[j]);
                    res += minValue - bricksArray[k];
                    bricksArray[k] = minValue;
                }
            }
        }
    }

    return res;
}