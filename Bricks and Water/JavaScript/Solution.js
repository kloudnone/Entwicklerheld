export function bricksAndWater(bricksArray) {
    let result = 0;

    for(let i = 1; i < bricksArray.length - 1; i++) {
        let leftBrickHeight = 0;
        let rightBrickHeight = 0;

        for (let j = i; j >= 0; j--) {
            leftBrickHeight = Math.max(leftBrickHeight, bricksArray[j]);
        }

        for (let j = i; j < bricksArray.length; j++) {
            rightBrickHeight = Math.max(rightBrickHeight, bricksArray[j]);
        }
        result += Math.min(leftBrickHeight, rightBrickHeight) - bricksArray[i];
    }
    return result;
}
