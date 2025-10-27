export function encode(text) {
    let res = "";
    let count = 1;

    for (let c = 0; c < text.length; c++) {
        if (text[c] !== text[c + 1]) {
            res += count + text[c]
            count = 1
        } else {
            count++
        }
    }
    
    return res;
}